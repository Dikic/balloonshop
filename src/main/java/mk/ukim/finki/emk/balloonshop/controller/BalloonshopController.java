package mk.ukim.finki.emk.balloonshop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import mk.ukim.finki.emk.balloonshop.model.Product;
import mk.ukim.finki.emk.balloonshop.model.User;
import mk.ukim.finki.emk.balloonshop.service.ProductService;
import mk.ukim.finki.emk.balloonshop.service.UserService;
import mk.ukim.finki.emk.balloonshop.utils.CustomerModelAndView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BalloonshopController {

	@Autowired
	UserService userService;

	@Autowired
	ProductService productService;

	@RequestMapping(value = "/*")
	public String invalid() {
		return "redirect:";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String loginPost(@ModelAttribute User user, HttpSession session) {
		userService.addUser(user);
		session.setAttribute("user", user);
		return "redirect:?notice=Your account has been created, please verify your account!";
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
			@RequestParam(defaultValue = "") String search) {
		ModelAndView view = new CustomerModelAndView("home");
		int pageCount = productService.getProductPageCount(search);

		if (page < 1 || page > pageCount) {
			page = 1;
		}

		List<Product> listProducts = productService.getProductsInRange(page,
				search);

		view.addObject("notice", notice);
		view.addObject("pageCount", pageCount);
		view.addObject("page", page);
		view.addObject("search", search);
		view.addObject("products", listProducts);
		return view;
	}

	@RequestMapping(value = "cart", method = RequestMethod.GET)
	public ModelAndView cart(HttpSession session) {
		ModelAndView view = new CustomerModelAndView("shopping_cart");

		return view;
	}

	@RequestMapping(value = "checkout", method = RequestMethod.GET)
	public ModelAndView checkout(HttpSession session) {
		ModelAndView view = new CustomerModelAndView("checkout");

		return view;
	}

}
