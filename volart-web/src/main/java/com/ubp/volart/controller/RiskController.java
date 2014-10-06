package com.ubp.volart.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ubp.volart.model.risk.DrawDown;
import com.ubp.volart.model.risk.Greek;
import com.ubp.volart.model.risk.Var;
import com.ubp.volart.service.RiskService;
import com.ubp.volart.vo.indicator.RiskVO;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes({ "POSITION", "PTF" })
public class RiskController {

    private static final Logger logger = LoggerFactory.getLogger(RiskController.class);

    @Autowired
    private RiskService riskSvc;

    @RequestMapping(value = "/risk/{ptfName}", method = RequestMethod.GET)
    public String indicator(@PathVariable String ptfName, Model model) {
	logger.info("Risk: " + ptfName);

	// Definir la position dans la session
	model.addAttribute("POSITION", "risk");
	// Definir le fond selectionne dans la session
	model.addAttribute("PTF", ptfName);

	Calendar cal = Calendar.getInstance();
	cal.add(Calendar.DATE, -1);
	cal.getTime();
	Date d = cal.getTime();

	List<Var> vars = riskSvc.findVarByFundAndDate(ptfName, d);
	DrawDown drawDown = riskSvc.findDrawDownByFundAndDate(ptfName, d);
	List<Greek> greeks = riskSvc.findGreekByFundDate(ptfName, d);

	// TODO: Controler l'authorisation de l'utilisateur pour le fond
	RiskVO risk = new RiskVO();
	risk.setDate(d);
	risk.setFundName(ptfName);
	risk.setGreeks(greeks);
	risk.setVars(vars);
	risk.setDrawDown(drawDown);
	// risk.setCurrentVar();

	model.addAttribute("risk", risk);

	return "risk";
    }

}
