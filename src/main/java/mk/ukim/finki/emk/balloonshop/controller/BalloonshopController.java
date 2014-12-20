package mk.ukim.finki.emk.balloonshop.controller;

import javax.servlet.http.HttpSession;

import mk.ukim.finki.emk.balloonshop.model.User;
import mk.ukim.finki.emk.balloonshop.service.ProductService;
import mk.ukim.finki.emk.balloonshop.service.UserService;
import mk.ukim.finki.emk.balloonshop.utils.CustomerModelAndView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
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

	@RequestMapping(value = "/")
	public ModelAndView index(@RequestParam(required = false) String notice) {
		System.out.println(notice);
		ModelAndView view = new CustomerModelAndView("home", "user", new User());
		view.addObject("notice", notice);
		view.addObject("products", productService.getAllProducts());
		return view;
	}
}
