package com.ubp.volart.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/login")
    public String login(Model model, HttpSession session) {
	logger.info("Login");
	return "login";
    }

    @RequestMapping(value = "/loginError")
    public String loginError(Model model, HttpSession session, HttpServletRequest request) {
	logger.info("Login Error");
	model.addAttribute("error", "true");
	return "login";
    }

    @RequestMapping(value = "/disconnect")
    public String disconnect(Model model, HttpSession session) {
	logger.info("Disconnect");
	return "login";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accesssDenied(Principal user, Model model) {
	if (user != null) {
	    model.addAttribute("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
	} else {
	    model.addAttribute("msg", "You do not have permission to access this page!");
	}
	return "403";
    }

    @RequestMapping(value = "/404", method = RequestMethod.GET)
    public String accesssNotFound(Model model) {
	return "404";
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String accesssError(Model model) {
	return "error";
    }

}
