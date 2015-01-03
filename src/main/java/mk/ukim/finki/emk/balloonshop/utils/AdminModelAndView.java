package mk.ukim.finki.emk.balloonshop.utils;

import org.springframework.web.servlet.ModelAndView;

public class AdminModelAndView extends ModelAndView {

	public AdminModelAndView(String view) {
		super("/admin-pages/main");
		addObject("view", view);
	}

	public AdminModelAndView(String view, String modelName, Object modelObject) {
		this(view);
		addObject(modelName, modelObject);
	}

}