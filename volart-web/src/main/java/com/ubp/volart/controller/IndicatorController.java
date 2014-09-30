package com.ubp.volart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ubp.volart.vo.indicator.BetatTargetLineVO;
import com.ubp.volart.vo.indicator.DStatGroupVO;
import com.ubp.volart.vo.indicator.DStatLineVO;
import com.ubp.volart.vo.indicator.IndicatorVO;
import com.ubp.volart.vo.indicator.RelativeValueLineVO;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/indicator")
public class IndicatorController {

    private static final Logger logger = LoggerFactory.getLogger(IndicatorController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String indicator(Model model, HttpSession session) {
	logger.info("Indicator");

	// Definir la position dans la session
	session.setAttribute("POSITION", "indicator");
	session.removeAttribute("PTF");

	IndicatorVO indicator = new IndicatorVO();
	indicator.setDate("2014/09/21");
	indicator.setDstatValues(createDStat());
	indicator.setRelativeValues(createRelativeValue());
	indicator.setBetaTargetValues(createBetaTarget());

	model.addAttribute("indicator", indicator);

	return "indicator";
    }

    private List<DStatGroupVO> createDStat() {
	List<DStatGroupVO> groups = new ArrayList<DStatGroupVO>();
	DStatGroupVO g = new DStatGroupVO();
	g.getLines().add(new DStatLineVO("1", "Under", "Down", "Up", "Today", "Yesterday"));
	g.setName("Bond");

	groups.add(g);

	return groups;
    }

    private List<RelativeValueLineVO> createRelativeValue() {
	List<RelativeValueLineVO> lines = new ArrayList<RelativeValueLineVO>();
	lines.add(new RelativeValueLineVO("Ins", "Today Val", "Yest. Val", "Last M Date", "Last M Val"));

	return lines;
    }

    private List<BetatTargetLineVO> createBetaTarget() {
	List<BetatTargetLineVO> lines = new ArrayList<BetatTargetLineVO>();
	lines.add(new BetatTargetLineVO("Ins", "Today Val", "Yest. Val", "Last M Date", "Last M Val"));

	return lines;
    }

}
