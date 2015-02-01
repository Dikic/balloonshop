package mk.ukim.finki.emk.balloonshop.utils;

import mk.ukim.finki.emk.balloonshop.model.User;

import org.springframework.web.servlet.ModelAndView;

/**
 * Custom view class for user pages
 * 
 * @author Dejan, Mila, Bojan
 *
 */
public class CustomerModelAndView extends ModelAndView {

	public CustomerModelAndView(String view) {
		super("/customer-pages/main");
		addObject("view", view);
		addObject("user", new User());
	}

	public CustomerModelAndView(String view, String modelName,
			Object modelObject) {
		this(view);
		addObject(modelName, modelObject);
	}

}
