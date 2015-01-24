package mk.ukim.finki.emk.balloonshop.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import mk.ukim.finki.emk.balloonshop.model.Cart;
import mk.ukim.finki.emk.balloonshop.model.CartProduct;
import mk.ukim.finki.emk.balloonshop.model.Category;
import mk.ukim.finki.emk.balloonshop.model.Product;
import mk.ukim.finki.emk.balloonshop.model.Purchase;
import mk.ukim.finki.emk.balloonshop.model.PurchaseDetail;
import mk.ukim.finki.emk.balloonshop.model.PurchaseProduct;
import mk.ukim.finki.emk.balloonshop.model.User;
import mk.ukim.finki.emk.balloonshop.service.CartProductService;
import mk.ukim.finki.emk.balloonshop.service.CartService;
import mk.ukim.finki.emk.balloonshop.service.CategoryService;
import mk.ukim.finki.emk.balloonshop.service.ProductService;
import mk.ukim.finki.emk.balloonshop.service.PurchaseDetailService;
import mk.ukim.finki.emk.balloonshop.service.PurchaseProductService;
import mk.ukim.finki.emk.balloonshop.service.PurchaseService;
import mk.ukim.finki.emk.balloonshop.service.UserService;
import mk.ukim.finki.emk.balloonshop.utils.CustomerModelAndView;

import org.jdom.JDOMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.datacash.client.Agent;
import com.datacash.client.Amount;
import com.datacash.client.CardDetails;
import com.datacash.errors.FailureReport;
import com.datacash.util.XMLDocument;

@Controller
public class BalloonshopController {

	@Autowired
	UserService userService;

	@Autowired
	ProductService productService;

	@Autowired
	CartService cartService;

	@Autowired
	CartProductService cartProductService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	PurchaseService purchaseService;

	@Autowired
	PurchaseProductService purchaseProductService;

	@Autowired
	PurchaseDetailService purchaseDetailService;

	private static final String TRANSACTION_HOST = "https://testserver.datacash.com/Transaction";
	private static final String TRANSACTION_USERNAME = "99571100";
	private static final String TRANSACTION_PASSWORD = "nAwc3Yqt";
	private static final int TRANSACTION_TIMEOUT = 6000;

	@ModelAttribute("cartProductCount")
	public int getProductCount(HttpSession session) {
		User user = (User) session.getAttribute("customer");
		if (user == null || user.getCart() == null) {
			return 0;
		}
		int id = user.getCart().getId();
		return cartProductService.getProductCount(id);
	}

	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryService.getAllCategories();
	}

	@ModelAttribute("promotions")
	public List<Product> getOnPromotions() {
		return productService.getOnPromotion();

	}

	@RequestMapping(value = "/*")
	public String invalid() {
		return "redirect:";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String loginPost(@ModelAttribute User user, HttpSession session) {
		userService.addUser(user);
		session.setAttribute("user", user);
		sendMail(user.getEmail(),
				"Please verify you account with the following link "
						+ session.getServletContext().getContextPath()
						+ "/verify/" + user.getVerificationUser().getLink());
		return "redirect:?notice=Your account has been created, please verify your account!";
	}

	@RequestMapping(value = "/verify/{uuid}")
	public String verify(@PathVariable String uuid) {
		String notice = userService.verifyUser(uuid) ? "Your account has been verified."
				: "Error verifying account.";
		return String.format("redirect:/?notice=%s", notice);
	}

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String signinPost(@ModelAttribute User user, HttpSession session) {
		String notice = userService.signInUser(user, session) ? "Welcome."
				: "Invalid username or password!";
		return String.format("redirect:?notice=%s", notice);
	}

	@RequestMapping(value = "/signout", method = RequestMethod.GET)
	public String signOut(HttpSession session) {
		session.removeAttribute("customer");
		return "redirect:?notice=You have signed out successfully";
	}

	@RequestMapping(value = "/details/{productId}", method = RequestMethod.GET)
	public ModelAndView details(@PathVariable int productId) {
		ModelAndView view = new CustomerModelAndView("product_details");

		view.addObject("product", productService.getProduct(productId));

		return view;
	}

	@RequestMapping(value = "/")
	public ModelAndView index(@RequestParam(required = false) String notice,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "") String search,
			@RequestParam(defaultValue = "0") int category) {
		ModelAndView view = new CustomerModelAndView("home");
		int pageCount = productService.getProductPageCount(search, category);

		if (page < 1 || page > pageCount) {
			page = 1;
		}

		List<Product> listProducts = productService.getProductsInRange(
				category, page, search);

		view.addObject("notice", notice);
		view.addObject("pageCount", pageCount);
		view.addObject("page", page);
		view.addObject("search", search);
		view.addObject("category", category);
		view.addObject("products", listProducts);
		return view;
	}

	@RequestMapping(value = "cart", method = RequestMethod.GET)
	public ModelAndView cart(HttpSession session) {

		User user = (User) session.getAttribute("customer");
		if (user == null) {
			return new CustomerModelAndView("sign-in-form", "notice",
					"please sign in to view your cart.");
		}
		ModelAndView view = new CustomerModelAndView("shopping_cart");
		Cart cart = user.getCart();
		view.addObject("cartProducts",
				cartProductService.getCartProductsFromCart(cart));
		return view;
	}

	@RequestMapping(value = "checkout", method = RequestMethod.GET)
	public ModelAndView checkout(HttpSession session) {
		ModelAndView view = new CustomerModelAndView("checkout");
		view.addObject("user", session.getAttribute("customer"));
		return view;
	}

	@RequestMapping(value = "profile", method = RequestMethod.GET)
	public ModelAndView profile(HttpSession session) {
		ModelAndView view = new CustomerModelAndView("profile");
		User user = (User) session.getAttribute("customer");
		if (user == null) {
			return new CustomerModelAndView("profile");
		}
		view.addObject("user", user);
		return view;
	}

	@RequestMapping(value = "profile", method = RequestMethod.POST)
	public String profilePost(HttpSession session, @ModelAttribute User user) {
		User customer = (User) session.getAttribute("customer");

		customer.setName(user.getName());
		customer.setSurname(user.getSurname());
		customer.setAddress(user.getAddress());
		customer.setCity(user.getCity());
		customer.setZip(user.getZip());
		customer.setCountry(user.getCountry());

		userService.addOrUpdateUser(customer);
		return "redirect:/?notice=Your account update successfully.";
	}

	@RequestMapping(value = "checkout", method = RequestMethod.POST)
	public String checkoutPost(HttpSession session, @ModelAttribute User user,
			@RequestParam String cardNumber, @RequestParam String dateExpire) {
		User customer = (User) session.getAttribute("customer");
		Cart cart = customer.getCart();

		Purchase purchase = new Purchase();
		purchase.setUser(customer);
		purchase.setDateCreated(new Date());
		purchase.setShippingAddress(user.getAddress());
		purchaseService.addPurchase(purchase);
		List<CartProduct> cartProducts = cartProductService
				.getCartProductsFromCart(cart);
		double amount = 0;
		for (CartProduct cartProduct : cartProducts) {
			PurchaseProduct purchaseProduct = new PurchaseProduct();
			purchaseProduct.setProduct(cartProduct.getProduct());
			purchaseProduct.setQuantity(cartProduct.getQuantity());
			purchaseProduct.setPurchase(purchase);
			purchaseProductService.addPurchaseProduct(purchaseProduct);
			amount += cartProduct.getQuantity()
					* cartProduct.getProduct().getPrice();
		}
		String merchantReference = 10000000000L + purchase.getId() + "";
		Agent agent = new Agent();
		agent.setHost(TRANSACTION_HOST);
		agent.setTimeout(TRANSACTION_TIMEOUT);

		XMLDocument xmlPreRequest = null;

		try {
			xmlPreRequest = new XMLDocument();
			/*
			 * Set your client and password details, for your test account
			 */
			xmlPreRequest.set("Request.Authentication.client",
					TRANSACTION_USERNAME);
			xmlPreRequest.set("Request.Authentication.password",
					TRANSACTION_PASSWORD);

			xmlPreRequest.set(
					"Request.Transaction.TxnDetails.merchantreference",
					merchantReference);

			CardDetails cardDetails = new CardDetails();
			cardDetails.put("pan", cardNumber);
			cardDetails.put("expirydate", dateExpire);
			cardDetails.put("method", "pre");
			xmlPreRequest.set(cardDetails);
			xmlPreRequest.set(new Amount("" + amount, "GBP"));

		} catch (IOException | JDOMException e) {
			e.printStackTrace();
			return "redirect:/?notice=Prerequest failed.";
		}

		String status = null;
		String reason = null;
		String authCode = null;
		String dcref = null; // data cash reference
		boolean success = false;
		XMLDocument xmlPreResponse;

		try {
			xmlPreResponse = agent.request(xmlPreRequest);
			status = xmlPreResponse.get("Response.status");
			reason = "prerequest: " + xmlPreResponse.get("Response.reason");
			authCode = xmlPreResponse.get("Response.CardTxn.authcode");
			dcref = xmlPreResponse.get("Response.datacash_reference");
		} catch (FailureReport e) {
			e.printStackTrace();
			return "redirect:/?notice=Preresponse failed.";
		}

		if (dcref != null && authCode != null) {
			XMLDocument xmlFulfillRequest = null;
			try {
				xmlFulfillRequest = new XMLDocument();
				xmlFulfillRequest.set("Request.Authentication.client",
						TRANSACTION_USERNAME);
				xmlFulfillRequest.set("Request.Authentication.password",
						TRANSACTION_PASSWORD);
				xmlFulfillRequest.set(
						"Request.Transaction.TxnDetails.merchantreference",
						merchantReference);
				xmlFulfillRequest.set(
						"Request.Transaction.HistoricTxn.reference", dcref);
				xmlFulfillRequest.set(
						"Request.Transaction.HistoricTxn.authcode", authCode);
				xmlFulfillRequest.set("Request.Transaction.HistoricTxn.method",
						"fulfill");

			} catch (IOException | JDOMException e) {
				e.printStackTrace();
				return "redirect:/?notice=Fulfillrequest failed.";
			}

			try {
				XMLDocument xmlFulfillResponse = agent
						.request(xmlFulfillRequest);
				status = xmlFulfillResponse.get("Response.status");
				reason = "fulfillment: "
						+ xmlFulfillResponse.get("Response.reason");
				if (status.equals("1")) {
					success = true;
				}
				System.out.println(xmlFulfillResponse.toString());
			} catch (FailureReport e) {
				e.printStackTrace();
				return "redirect:/?notice=Fulfillresponse failed.";
			}

		}

		if (success) {
			purchase.setVerified(true);
			for (CartProduct cartProduct : cartProducts) {
				PurchaseDetail purchaseDetail = new PurchaseDetail();
				purchaseDetail.setProduct(cartProduct.getProduct());
				purchaseDetail.setPurchase(purchase);
				purchaseDetail.setProductName(cartProduct.getProduct()
						.getName());
				purchaseDetail.setQuantity(cartProduct.getQuantity());
				purchaseDetail.setUnitCost(cartProduct.getProduct().getPrice());
				purchaseDetailService.addPurchaseDetail(purchaseDetail);
				cartProductService.deleteCartProduct(cartProduct.getId());

			}
			customer.getCart().setCartProduct(null);

			sendMail(
					user.getEmail(),
					"Your transaction is successful. \n"
							+ amount
							+ "$ have been paid. \n\n\n Thank you for using our service! \n Ballonshop team");
		} else {
			purchase.setCanceled(true);
		}

		purchaseService.updatePurchase(purchase);

		// StringBuilder link = new StringBuilder(
		// "https://www.paypal.com/xclick?business=balloonshopemk@balloonshop.com.mk");
		// link.append("&item_name=balloonshopOrder").append(purchase.getId());
		// link.append("&item_number=").append(purchase.getId());
		// link.append("&amount=").append(Math.ceil(amount));
		// link.append("&currency_code=USD");
		// link.append("&address1=").append(user.getAddress());
		// link.append("&address=").append(user.getAddress());
		// link.append("&city=").append(user.getCity());
		// link.append("&zip=").append(user.getZip());
		// link.append("&email=").append(user.getEmail());
		// link.append("&first_name=").append(user.getName());
		// link.append("&last_name=").append(user.getSurname());
		// link.append("&lc=").append(user.getCountry());
		// link.append("&return=http://localhost:8080/balloonshop/");
		// link.append("&cancel_return=http://localhost:8080/balloonshop/");
		// System.out.println(link.toString());
		// return "redirect:" + link.toString();

		return "redirect:/?notice=Your transaction" + (success ? "" : " not")
				+ " succeeded.";
	}

	private void sendMail(String to, String message) {
		JavaMailSenderImpl mail = new JavaMailSenderImpl();
		mail.setHost("smtp.gmail.com");
		mail.setPort(25);
		mail.setJavaMailProperties(getMailProperties());
		mail.setUsername("balloonshopemk@gmail.com");
		mail.setPassword("seminarskarabota");

		MimeMessage msg = mail.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg);
		try {
			helper.setSubject("Balloonshop transaction");
			helper.setTo(to);
			helper.setText(message);
			helper.setFrom("balloonshop@balloonshop.com");
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		mail.send(msg);
	}

	private Properties getMailProperties() {
		Properties properties = new Properties();
		properties.setProperty("mail.transport.protocol", "smtp");
		properties.setProperty("mail.smtp.auth", "true");
//		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.debug", "false");
		return properties;
	}

	@RequestMapping(value = "add-to-cart/{productId}", method = RequestMethod.GET)
	public String addToCart(HttpSession session, @PathVariable int productId) {
		User user = (User) session.getAttribute("customer");
		if (user == null) {
			return "redirect:/?notice=Please sign in to use your cart.";
		}
		cartService.addToCart(productId, user);
		return "redirect:/?notice=Your product is added to cart successfully.";
	}

	@RequestMapping(value = "removeFromCart/{cartProductId}", method = RequestMethod.GET)
	public String removeFromCart(HttpSession session,
			@PathVariable int cartProductId) {
		User user = (User) session.getAttribute("customer");
		cartProductService.deleteCartProduct(cartProductId, user);
		return "redirect:/cart";
	}

	@RequestMapping(value = "update-cart", method = RequestMethod.POST, produces = "application/json", headers = "Accept=application/json")
	public @ResponseBody int updateCart(HttpSession session,
			@RequestParam int id, @RequestParam int quantity) {
		User user = (User) session.getAttribute("customer");
		if (user == null) {
			return 0;
		}
		CartProduct cartProduct = cartProductService.getCartProduct(id);
		cartProduct.setQuantity(quantity);
		cartProductService.updateCartProduct(cartProduct);
		return id;
	}
}
