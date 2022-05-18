package edu.vnu.websemantics.controller;

import com.google.api.client.http.HttpRequest;
import edu.vnu.websemantics.dao.UserDAO;
import edu.vnu.websemantics.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.vnu.websemantics.common.UserInfo;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthController {

	@Autowired
	UserDAO userDAO;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView model = new ModelAndView("login");
		return model;
	}
//
//	@RequestMapping(value = "/check_authenticate")
//	public ModelAndView loginSuccess(HttpServletRequest httpServletRequest) {
//
//		String username = httpServletRequest.getParameter("username");
//		String password = httpServletRequest.getParameter("password");
//		User user = userDAO.findUserByName(username);
//
//		ModelAndView model = new ModelAndView();
//
//		if (password.equals(user.getPassword())) {
//			model.setViewName("profile");
//			return model;
//		} else {
//
//			model.setViewName("login");
//
//			return model;
//		}
//	}


	// for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();

		// check if user is loggedin

		String userName = UserInfo.getUserName();
		if (userName != null) {
			model.addObject("username", userName);
		}

		model.setViewName("403");
		return model;

	}



}
