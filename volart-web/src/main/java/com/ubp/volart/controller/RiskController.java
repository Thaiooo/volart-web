package com.ubp.volart.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    @RequestMapping(value = "/risk/{ptfName}/{ptfDate}", method = RequestMethod.GET)
    public String riskByDate(@PathVariable String ptfName, @PathVariable String ptfDate, Model model) {
	logger.info("Risk: " + ptfName + " Date:" + ptfDate);

	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	Date d = null;
	try {
	    d = sdf.parse(ptfDate);
	} catch (ParseException e) {
	    logger.error("Date format error:" + ptfDate);
	    d = new Date();
	}
	loadRisk(model, ptfName, d);

	return "risk";
    }

    @RequestMapping(value = "/risk/{ptfName}", method = RequestMethod.GET)
    public String risk(@PathVariable String ptfName, Model model) {
	logger.info("Risk: " + ptfName);

	Calendar cal = Calendar.getInstance();
	cal.add(Calendar.DATE, -1);
	cal.getTime();
	Date d = cal.getTime();

	loadRisk(model, ptfName, d);

	return "risk";
    }

    private void loadRisk(Model model, String aName, Date aDate) {
	// Definir la position dans la session
	model.addAttribute("POSITION", "risk");
	// Definir le fond selectionne dans la session
	model.addAttribute("PTF", aName);

	List<Var> vars = riskSvc.findVarByFundAndDate(aName, aDate);
	DrawDown drawDown = riskSvc.findDrawDownByFundAndDate(aName, aDate);
	List<Greek> greeks = riskSvc.findGreekByFundDate(aName, aDate);

	RiskVO risk = new RiskVO();
	risk.setDate(aDate);
	risk.setFundName(aName);
	risk.setGreeks(greeks);
	risk.setVars(vars);
	risk.setDrawDown(drawDown);
	// risk.setCurrentVar();

	model.addAttribute("risk", risk);
    }

}
