package com.ubp.volart.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ubp.volart.model.portfolio.Portfolio;
import com.ubp.volart.service.PortfolioService;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes({ "POSITION", "PTF" })
public class PortfolioController {

    private static final Logger logger = LoggerFactory.getLogger(PortfolioController.class);

    @Autowired
    private PortfolioService ptfSvc;

    @RequestMapping(value = "/portfolio/{ptfName}/{ptfDate}", method = RequestMethod.GET)
    public String portfolio2(@PathVariable String ptfName, @PathVariable String ptfDate, Model model) {
	logger.info("Portfolio: " + ptfName + " Date:" + ptfDate);

	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	Date d = null;
	try {
	    d = sdf.parse(ptfDate);
	} catch (ParseException e) {
	    logger.error("Date format error:" + ptfDate);
	    d = new Date();
	}
	loadPortfolio(model, ptfName, d);

	return "portfolio";
    }

    @RequestMapping(value = "/portfolio/{ptfName}", method = RequestMethod.GET)
    public String portfolio(@PathVariable String ptfName, Model model) {
	logger.info("Portfolio: " + ptfName);

	Date d = new Date();
	loadPortfolio(model, ptfName, d);

	return "portfolio";
    }

    private void loadPortfolio(Model model, String aName, Date aDate) {
	// Definir la position dans la session
	model.addAttribute("POSITION", "ptf");
	// Definir le fond selectionne dans la session
	model.addAttribute("PTF", aName);

	Portfolio ptf = ptfSvc.findByNameAndDate(aName, aDate);
	if (ptf == null) {
	    ptf = new Portfolio();
	    ptf.setDate(aDate);
	}
	model.addAttribute("ptf", ptf);
    }

}
