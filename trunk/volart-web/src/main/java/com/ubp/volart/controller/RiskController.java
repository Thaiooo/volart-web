package com.ubp.volart.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ubp.volart.vo.indicator.CurrentVarVO;
import com.ubp.volart.vo.indicator.DrawDownVO;
import com.ubp.volart.vo.indicator.GreekLineVO;
import com.ubp.volart.vo.indicator.RiskVO;
import com.ubp.volart.vo.indicator.VarLineVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class RiskController {

    private static final Logger logger = LoggerFactory.getLogger(RiskController.class);

    @RequestMapping(value = "/risk/{ptfName}", method = RequestMethod.GET)
    public String indicator(@PathVariable String ptfName, Model model, HttpSession session) {
	logger.info("Risk: " + ptfName);

	// Definir la position dans la session
	session.setAttribute("POSITION", "risk");
	// Definir le fond selectionne dans la session
	session.setAttribute("PTF", ptfName);

	// TODO: Controler l'authorisation de l'utilisateur pour le fond
	RiskVO risk = new RiskVO();
	risk.setDate("2014/09/21");
	risk.setFundName(ptfName);
	risk.setGreeks(createGreeks());
	risk.setVars(createVars());
	risk.setDrawDown(new DrawDownVO(-0.02, -0.05, new Date(), new Date()));
	risk.setCurrentVar(new CurrentVarVO("250 Day", 0.99, -0.01, -0.1, 0.2));

	model.addAttribute("risk", risk);

	return "risk";
    }

    private List<VarLineVO> createVars() {
	List<VarLineVO> vars = new ArrayList<VarLineVO>();
	vars.add(new VarLineVO("250 D", 0.99, -0.0142, 646402.5, new Date()));
	return vars;
    }

    private List<GreekLineVO> createGreeks() {
	List<GreekLineVO> greeks = new ArrayList<GreekLineVO>();
	greeks.add(new GreekLineVO("Delta", -0.01, 0.05, 0.03));
	greeks.add(new GreekLineVO("Vega", -0.02, 0.06, 0.04));
	greeks.add(new GreekLineVO("Theta", -0.03, 0.08, 0.05));
	return greeks;
    }

}
