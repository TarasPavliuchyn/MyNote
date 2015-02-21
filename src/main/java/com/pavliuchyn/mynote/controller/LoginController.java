package com.pavliuchyn.mynote.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class LoginController {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(LoginController.class);

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model,
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "login", required = false) String login,
			@RequestParam(value = "logout", required = false) String logout) {
		if (error != null) {
			LOGGER.warn("Invalid username and password!");
			model.addAttribute("error", "fail");
		}
		if (logout != null) {
			LOGGER.warn("Have been logged out successfully.");
			model.addAttribute("msg", "logout");
		}
		if (login != null) {
			LOGGER.warn("Have been registered successfully.");
			model.addAttribute("msg", "please.login");
		}
		return "access/login";
	}
}