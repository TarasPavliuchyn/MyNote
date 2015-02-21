package com.pavliuchyn.mynote.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pavliuchyn.mynote.model.user.User;
import com.pavliuchyn.mynote.service.user.UserService;

@Controller
public class RegistrationController {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(RegistrationController.class);

	@Autowired
	public UserService userService;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String goToRegistr(Model model,
			@RequestParam(required = false) String message) {
		model.addAttribute("message", message);
		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String postRegisterPage(
			@Valid @ModelAttribute("newUser") User newUser,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "registration";
		}
		if (userService.findByLogin(newUser.getLogin()) != null) {
			String message = "exist";
			LOGGER.info("Another user already exists in the system with the same email address");
			return "redirect:/registration?message=" + message;
		}
		userService.create(newUser);
		model.addAttribute("login", "please.login");
		return "redirect:/login";

	}
}