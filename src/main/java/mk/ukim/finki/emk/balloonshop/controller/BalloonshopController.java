package mk.ukim.finki.emk.balloonshop.controller;

import mk.ukim.finki.emk.balloonshop.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BalloonshopController {

	@RequestMapping(value = "/*")
	public String invalid() {
		return "redirect:";
	}

	@RequestMapping(value = "/")
	public ModelAndView index() {
		return new ModelAndView("header", "user", new User());
	}

}
