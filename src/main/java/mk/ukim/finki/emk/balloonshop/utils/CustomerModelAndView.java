package mk.ukim.finki.emk.balloonshop.utils;

import org.springframework.web.servlet.ModelAndView;

public class CustomerModelAndView extends ModelAndView {

	public CustomerModelAndView(String view) {
		super("/customer-pages/main");
		addObject("view", view);
	}

	public CustomerModelAndView(String view, String modelName,
			Object modelObject) {
		this(view);
		addObject(modelName, modelObject);
	}

}
