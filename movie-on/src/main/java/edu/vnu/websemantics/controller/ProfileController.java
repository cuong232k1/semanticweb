package edu.vnu.websemantics.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.vnu.websemantics.common.UserInfo;
import edu.vnu.websemantics.model.MovieDetails;
import edu.vnu.websemantics.service.MovieOnService;

@Controller
public class ProfileController {

	@Autowired
	private MovieOnService movieOnService;

	private static List<MovieDetails> movieDetails = null;

	private static String userName = null;

	@RequestMapping(value = "/profile**", method = RequestMethod.GET)
	public ModelAndView defaultPage() throws IOException {

		ModelAndView model = new ModelAndView();
		String user = UserInfo.getUserName();
		if (userName == null || !user.equals(userName)) {
			userName = user;
			movieDetails = movieOnService.moviesAndVideos(user);
		}
		model.addObject("movieDetails", movieDetails);
		model.setViewName("profile");
		return model;

	}
}