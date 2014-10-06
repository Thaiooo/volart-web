package com.ubp.volart.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ubp.volart.model.indicator.BetaTarget;
import com.ubp.volart.model.indicator.DStat;
import com.ubp.volart.model.indicator.RelativeValue;
import com.ubp.volart.service.IndicatorService;
import com.ubp.volart.vo.indicator.DStatGroupVO;
import com.ubp.volart.vo.indicator.IndicatorVO;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/indicator")
@SessionAttributes({ "POSITION", "PTF" })
public class IndicatorController {

    private static final Logger logger = LoggerFactory.getLogger(IndicatorController.class);

    @Autowired
    private IndicatorService indicatorSvc;

    @RequestMapping(method = RequestMethod.GET)
    public String indicator(Model model) {
	logger.info("Indicator");
	Date d = new Date();

	// Definir la position dans la session
	model.addAttribute("POSITION", "indicator");
	model.addAttribute("PTF", "");

	List<BetaTarget> betaTarget = indicatorSvc.findBetaTargetByDate(d);
	List<RelativeValue> relativeValue = indicatorSvc.findRelativeValueByDate(d);
	List<DStat> dtstat = indicatorSvc.findDStatByDate(d);

	IndicatorVO indicator = new IndicatorVO();
	indicator.setDate(d);
	indicator.setRelativeValueLines(relativeValue);
	indicator.setBetaTargetLines(betaTarget);
	indicator.setDstatLines(createDStat(dtstat));

	model.addAttribute("indicator", indicator);

	return "indicator";
    }

    private List<DStatGroupVO> createDStat(List<DStat> dStatList) {
	List<DStatGroupVO> groups = new ArrayList<DStatGroupVO>();
	Map<String, DStatGroupVO> map = new HashMap<String, DStatGroupVO>();
	for (DStat dstat : dStatList) {
	    DStatGroupVO g = map.get(dstat.getGroup());
	    if (g == null) {
		g = new DStatGroupVO();
		g.setName(dstat.getGroup());
		map.put(dstat.getGroup(), g);
		groups.add(g);
	    }
	    g.getLines().add(dstat);
	}

	return groups;
    }

}
