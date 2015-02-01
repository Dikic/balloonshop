package mk.ukim.finki.emk.balloonshop.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mk.ukim.finki.emk.balloonshop.AppConfig;
import mk.ukim.finki.emk.balloonshop.model.Category;
import mk.ukim.finki.emk.balloonshop.model.Product;
import mk.ukim.finki.emk.balloonshop.model.Purchase;
import mk.ukim.finki.emk.balloonshop.model.User;
import mk.ukim.finki.emk.balloonshop.service.CategoryService;
import mk.ukim.finki.emk.balloonshop.service.ProductService;
import mk.ukim.finki.emk.balloonshop.service.PurchaseService;
import mk.ukim.finki.emk.balloonshop.service.UserService;
import mk.ukim.finki.emk.balloonshop.utils.AdminModelAndView;

import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Admin controller
 * 
 * @author Dejan, Mila, Bojan
 *
 */
@Secured("ROLE_ADMIN")
@RequestMapping(value = "/admin")
@Controller
public class AdminController {

	FileItem small;
	FileItem large;
	public static final String FILEPATH = AppConfig.UPLOAD_PATH;

	@Autowired
	UserService userService;

	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	PurchaseService purchaseService;

	/**
	 * 
	 * @return number of unverified purchases
	 */
	@ModelAttribute("unverifiedCount")
	public long unverifiedCount() {
		return purchaseService.unverifiedCount();
	}

	/**
	 * 
	 * @return number of uncompleted purchases
	 */
	@ModelAttribute("uncompletedCount")
	public long uncompletedCount() {
		return purchaseService.uncompletedCount();
	}

	/**
	 * Admin root path
	 * 
	 * @return view
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView adminHome() {
		ModelAndView view = new AdminModelAndView("admin");
		view.addObject("usersCount", userService.getAllUsers().size());
		view.addObject("productsCount", productService.getAllProducts().size());
		view.addObject("categoriesCount", categoryService.getAllCategories()
				.size());
		view.addObject("purchasesCount", purchaseService.getAllPurchases()
				.size());
		view.addObject("promotions", productService.getOnPromotion());
		return view;
	}

	/**
	 * Request method to show all users
	 * 
	 * @param page
	 *            number of page
	 * @return view
	 */
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ModelAndView usersGet(@RequestParam(defaultValue = "1") int page) {
		ModelAndView view = new AdminModelAndView("users");
		int pageCount = userService.getUsersCount("");
		if (page < 1 || page > pageCount) {
			page = 1;
		}
		List<User> listUsers = userService.getUsersInRange(page, "");
		view.addObject("users", listUsers);
		view.addObject("user", new User());
		view.addObject("pageCount", pageCount);
		view.addObject("page", page);
		return view;
	}

	/**
	 * Request method to show all purchases
	 * 
	 * @param page
	 *            number of purchases page
	 * @param unverified
	 *            request unverified
	 * @param uncompleted
	 *            request uncompleted
	 * @return view
	 */
	@RequestMapping(value = "/purchases", method = RequestMethod.GET)
	public ModelAndView purchasesGet(
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "false") boolean unverified,
			@RequestParam(defaultValue = "false") boolean uncompleted) {
		ModelAndView view = new AdminModelAndView("purchases");
		if (unverified) {
			view.addObject("purchases", purchaseService.getUnverified());
			return view;
		}

		if (uncompleted) {
			view.addObject("purchases", purchaseService.getUncompleted());
			return view;
		}

		int pageCount = purchaseService.getPurchasesCount();
		if (page < 1 || page > pageCount) {
			page = 1;
		}
		List<Purchase> listPurchases = purchaseService
				.getPurchasesInRange(page);
		view.addObject("purchases", listPurchases);
		view.addObject("pageCount", pageCount);
		view.addObject("page", page);

		return view;
	}

	/**
	 * Request method to get purchase for editing
	 * 
	 * @param id
	 *            of purchase
	 * @return view
	 */
	@RequestMapping(value = "/purchases/edit", method = RequestMethod.GET)
	public ModelAndView getPurchase(@RequestParam int id) {
		return new ModelAndView("/admin-pages/purchase_form", "purchase",
				purchaseService.getPurchase(id));
	}

	/**
	 * Request method to get purchase for editing
	 * 
	 * @param purchase
	 *            to edit
	 * @return view
	 */
	@RequestMapping(value = "/purchases/edit", method = RequestMethod.POST)
	public String purchaseEditPOST(@ModelAttribute Purchase purchase,
			@RequestParam(defaultValue = "false") boolean shipped) {
		if (shipped) {
			purchase.setDateShipped(new Date());
		} else {
			purchase.setDateShipped(null);
		}
		purchaseService.updatePurchase(purchase);
		return "redirect:/admin/purchases";
	}

	/**
	 * Request method to delete user
	 * 
	 * @param id
	 *            of user
	 * @return view
	 */
	@RequestMapping(value = "/delete/user", method = RequestMethod.GET)
	public ModelAndView deleteUser(@RequestParam int id) {
		userService.deleteUser(id);
		ModelAndView view = new ModelAndView("redirect:/admin/users");
		view.addObject("users", userService.getAllUsers());
		return view;
	}

	/**
	 * Request method to add user
	 * 
	 * @param user
	 *            to add
	 * @return view
	 */
	@RequestMapping(value = "/add/user", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute User user) {
		userService.addOrUpdateUser(user);
		ModelAndView view = new ModelAndView("redirect:/admin/users");
		return view;
	}

	/**
	 * Request method to show all products
	 * 
	 * @param page
	 *            number for products
	 * @return view
	 */
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView productsGet(@RequestParam(defaultValue = "1") int page) {
		ModelAndView view = new AdminModelAndView("products");
		int pageCount = productService.getProductPageCount("", 0);
		if (page < 1 || page > pageCount) {
			page = 1;
		}

		List<Product> listProducts = productService.getProductsInRange(0, page,
				"");
		view.addObject("products", listProducts);
		view.addObject("pageCount", pageCount);
		view.addObject("page", page);
		return view;
	}

	/**
	 * Request method to delete product
	 * 
	 * @param id
	 *            of product to delete
	 * @return view
	 */
	@RequestMapping(value = "/delete/product", method = RequestMethod.GET)
	public ModelAndView deleteProduct(@RequestParam int id) {
		productService.deleteProduct(id);
		ModelAndView view = new ModelAndView("redirect:/admin/products");
		view.addObject("products", productService.getAllProducts());
		return view;
	}

	/**
	 * Request method to show one product
	 * 
	 * @param productId
	 *            id of product to show
	 * @return view
	 */
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public ModelAndView addOrEditProductGet(@RequestParam int productId) {
		ModelAndView view = new AdminModelAndView("add_product");
		if (productId == 0) {
			view.addObject("product", new Product());
		} else {
			view.addObject("product", productService.getProduct(productId));
		}
		view.addObject("categoriesList", categoryService.getAllCategories());
		return view;
	}

	/**
	 * Request method to add or edit product
	 * 
	 * @param productId
	 * @param name
	 * @param description
	 * @param price
	 * @param onPromotion
	 * @param categories
	 * @param p
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public String addProductPost(@RequestParam int productId,
			@RequestParam String name, @RequestParam String description,
			@RequestParam double price,
			@RequestParam(defaultValue = "false") boolean onPromotion,
			@RequestParam("cat") String[] categories, Product p)
			throws ParseException, IOException {

		small = p.getFileSmallImage().getFileItem();
		large = p.getFileLargeImage().getFileItem();

		FileOutputStream smallImageOutputStream = null;
		FileOutputStream largeImageOutputStream = null;

		if (small.getSize() > 0) {
			smallImageOutputStream = new FileOutputStream(new File(FILEPATH
					+ "t" + small.getName()));
			smallImageOutputStream.write(small.get());
			smallImageOutputStream.flush();
			smallImageOutputStream.close();
		}

		if (large.getSize() > 0) {
			largeImageOutputStream = new FileOutputStream(new File(FILEPATH
					+ large.getName()));
			largeImageOutputStream.write(large.get());
			largeImageOutputStream.flush();
			largeImageOutputStream.close();
		}

		if (name != "" && description != "" && price == (double) price
				&& onPromotion == true || onPromotion == false) {

			if (productId == 0) {
				Product product = new Product();
				ArrayList<Category> categoryList = new ArrayList<Category>();
				product.setName(name);
				product.setDescription(description);
				product.setPrice(price);
				product.setOnPromotion(onPromotion);
				product.setSmallImage("t" + small.getName());
				product.setLargeImage(large.getName());
				for (String i : categories) {
					categoryList.add(categoryService.getCategory(Integer
							.parseInt(i)));
				}
				product.setCategories(categoryList);
				productService.addProduct(product);
				return "redirect:/admin/products";
			} else {
				Product product = productService.getProduct(productId);
				ArrayList<Category> categoryList = new ArrayList<Category>();
				product.setName(name);
				product.setDescription(description);
				product.setPrice(price);
				product.setOnPromotion(onPromotion);
				product.setCategories(categoryList);
				if (!"".equals(small.getName())) {
					product.setSmallImage("t" + small.getName());
				}
				if (!"".equals(large.getName())) {
					product.setLargeImage(large.getName());
				}
				for (String i : categories) {
					categoryList.add(categoryService.getCategory(Integer
							.parseInt(i)));
				}
				productService.updateProduct(product);
				return "redirect:/admin/products";
			}
		} else {
			return "redirect:/admin/product";
		}
	}

	/**
	 * Request method to show all categories
	 * 
	 * @param page
	 *            number of categories
	 * @return view
	 */
	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public ModelAndView categoriesGet(@RequestParam(defaultValue = "1") int page) {
		int pageCount = categoryService.getCategoriesCount("");
		if (page < 1 || page > pageCount) {
			page = 1;
		}

		List<Category> listCategories = categoryService.getCategoriesInRange(
				page, "");

		ModelAndView view = new AdminModelAndView("categories");
		view.addObject("categories", listCategories);
		view.addObject("category", new Category());
		view.addObject("pageCount", pageCount);
		view.addObject("page", page);
		return view;
	}

	/**
	 * Request method to delete category
	 * 
	 * @param id
	 *            of category to delete
	 * @return view
	 */
	@RequestMapping(value = "/delete/category", method = RequestMethod.GET)
	public ModelAndView deleteCategory(@RequestParam int id) {
		categoryService.deleteCategory(id);
		ModelAndView view = new ModelAndView("redirect:/admin/categories");
		view.addObject("categories", categoryService.getAllCategories());
		return view;
	}

	/**
	 * Request method to add or update category
	 * 
	 * @param category
	 *            to add or update
	 * @return view
	 */
	@RequestMapping(value = "/add/category", method = RequestMethod.POST)
	public ModelAndView addCategory(@ModelAttribute Category category) {

		categoryService.addOrUpdateCategory(category);
		ModelAndView view = new ModelAndView("redirect:/admin/categories");

		return view;
	}

	/**
	 * Request method to get form for category
	 * 
	 * @param categoryId
	 *            category to edit
	 * @return view form
	 */
	@RequestMapping(value = "/edit/categoryform/{categoryId}", method = RequestMethod.GET)
	public ModelAndView editCategoryForm(@PathVariable int categoryId) {
		ModelAndView view = new ModelAndView("/admin-pages/category_form");
		view.addObject("category", categoryService.getCategory(categoryId));
		view.addObject("edit", true);
		return view;
	}

	/**
	 * Request method to get user form
	 * 
	 * @param userId
	 *            to edit
	 * @return view
	 */
	@RequestMapping(value = "/edit/userform/{userId}", method = RequestMethod.GET)
	public ModelAndView editUserForm(@PathVariable int userId) {
		ModelAndView view = new ModelAndView("/admin-pages/user_form");
		view.addObject("user", userService.getUser(userId));
		view.addObject("editUser", true);
		return view;
	}

}
