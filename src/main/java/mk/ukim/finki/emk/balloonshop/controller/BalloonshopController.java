package mk.ukim.finki.emk.balloonshop.controller;

import javax.servlet.http.HttpSession;

import mk.ukim.finki.emk.balloonshop.model.User;
import mk.ukim.finki.emk.balloonshop.service.UserService;
import mk.ukim.finki.emk.balloonshop.utils.CustomerModelAndView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BalloonshopController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/*")
	public String invalid() {
		return "redirect:";
	}

	@RequestMapping(value = "/")
	public ModelAndView index() {
		return new CustomerModelAndView("product_block", "user", new User());
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String loginPost(@ModelAttribute User user, HttpSession session) {
		userService.addUser(user);
		session.setAttribute("user", user);
		return "redirect:";
	}

}
