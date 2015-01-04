package mk.ukim.finki.emk.balloonshop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mk.ukim.finki.emk.balloonshop.model.User;
import mk.ukim.finki.emk.balloonshop.service.ProductService;
import mk.ukim.finki.emk.balloonshop.service.UserService;
import mk.ukim.finki.emk.balloonshop.utils.AdminModelAndView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

	@Autowired
	UserService userService;

	@Autowired
	ProductService productService;

	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView adminHome() {
		ModelAndView view = new AdminModelAndView("admin");
		return view;
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/users", method = RequestMethod.GET)
	public ModelAndView usersGet() {
		ModelAndView view = new AdminModelAndView("users");
		view.addObject("users", userService.getAllUsers());
		return view;
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/delete", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam int id) {
		userService.deleteUser(id);
		ModelAndView view = new ModelAndView("redirect:/admin/users");
		view.addObject("users", userService.getAllUsers());
		return view;
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/add", method = RequestMethod.POST)
	public ModelAndView add(@RequestParam String name,
			@RequestParam String surname, @RequestParam String email,
			@RequestParam String password, @RequestParam String address,
			@RequestParam String authority) {
		ModelAndView view = null;
		if (name != "" && surname != "" && email != ""
				&& password != "" && address != "" && authority != "") {
			User user = new User();
			user.setName(name);
			user.setSurname(surname);
			user.setEmail(email);
			user.setPassword(password);
			user.setAddress(address);
			user.setAuthority(authority);
			userService.addUser(user);
			view = new ModelAndView("redirect:/admin/users");
			view.addObject("users", userService.getAllUsers());
		} else {
			view = new ModelAndView("redirect:/admin/users");
			//view.addObject("users", userService.getAllUsers());
		}
		return view;
	}

}
