package mk.ukim.finki.emk.balloonshop.utils;

import mk.ukim.finki.emk.balloonshop.model.User;

import org.springframework.web.servlet.ModelAndView;

public class AdminModelAndView extends ModelAndView {

	public AdminModelAndView(String view) {
		super("/admin-pages/admin");
		addObject("view", view);
		addObject("user", new User());
	}

	public AdminModelAndView(String view, String modelName, Object modelObject) {
		this(view);
		addObject(modelName, modelObject);
	}

}