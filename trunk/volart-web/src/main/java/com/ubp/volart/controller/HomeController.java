package com.ubp.volart.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ubp.volart.model.Fund;
import com.ubp.volart.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes({ "FUNDS", "POSITION" })
public class HomeController {

    @Autowired
    private UserService userSvc;

    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String home(Model model, Principal principal) {
	model.addAttribute("POSITION", "home");

	// Load allow fund for the current user and put it in the session
	List<Fund> funds = userSvc.loadAllowFundsByUsername(principal.getName());
	model.addAttribute("FUNDS", funds);

	return "home";
    }
}
