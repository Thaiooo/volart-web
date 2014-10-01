package com.ubp.volart.controller;

import java.util.ArrayList;
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

import com.ubp.volart.model.Portfolio;
import com.ubp.volart.service.PortfolioService;
import com.ubp.volart.vo.ptf.PtfContentCellVO;
import com.ubp.volart.vo.ptf.PtfContentLineVO;
import com.ubp.volart.vo.ptf.PtfHeaderCellVO;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes({ "POSITION", "PTF" })
public class PortfolioController {

    private static final Logger logger = LoggerFactory.getLogger(PortfolioController.class);

    @Autowired
    private PortfolioService ptfSvc;

    @RequestMapping(value = "/portfolio/{ptfName}", method = RequestMethod.GET)
    public String portfolio(@PathVariable String ptfName, Model model) {
	logger.info("Portfolio: " + ptfName);

	// Definir la position dans la session
	model.addAttribute("POSITION", "ptf");
	// Definir le fond selectionne dans la session
	model.addAttribute("PTF", ptfName);

	Date d = new Date();
	Portfolio ptf = ptfSvc.findByNameAndDate(ptfName, d);

	/*
	PortfolioVO ptf = new PortfolioVO();

	ptf.setName(ptfName);
	ptf.setAsset("123,123.123");
	ptf.setDate("2014/09/21");
	ptf.setPnlD("0.00%");
	ptf.setPnlD1("0.00%");
	ptf.setPnlMtD("0.00%");
	ptf.setPnlMtDD1("0.00%");
	ptf.setDelta("0.00%");
	ptf.setVega("0.00%");
	ptf.setTheta("0.00%");
	ptf.setInvPrem("0.00%");

	List<PtfHeaderCellVO> headerCol = createHeaderColumns();
	ptf.setPtfHeaderCols(headerCol);

	List<PtfContentLineVO> lines = createContentLines();
	ptf.setPtfContent(lines);
	*/

	model.addAttribute("ptf", ptf);
	return "portfolio";
    }

    private List<PtfContentLineVO> createContentLines() {
	List<PtfContentLineVO> lines = new ArrayList<PtfContentLineVO>();
	PtfContentLineVO line = new PtfContentLineVO("");
	List<PtfContentCellVO> cols = createContentColumns();
	line.setCols(cols);

	lines.add(line);
	lines.add(line);

	return lines;
    }

    private List<PtfContentCellVO> createContentColumns() {
	List<PtfContentCellVO> cols = new ArrayList<PtfContentCellVO>();
	return cols;
    }

    private List<PtfHeaderCellVO> createHeaderColumns() {
	List<PtfHeaderCellVO> headerCol = new ArrayList<PtfHeaderCellVO>();
	headerCol.add(new PtfHeaderCellVO("critical", "Date"));
	headerCol.add(new PtfHeaderCellVO("1", "Qt1"));
	headerCol.add(new PtfHeaderCellVO("6", "Nav"));
	headerCol.add(new PtfHeaderCellVO("6", "Nav fnd%"));
	headerCol.add(new PtfHeaderCellVO("6", "Qt2"));
	headerCol.add(new PtfHeaderCellVO("1", "Instrument"));
	headerCol.add(new PtfHeaderCellVO("1", "Type"));
	headerCol.add(new PtfHeaderCellVO("1", "Maturity"));
	headerCol.add(new PtfHeaderCellVO("1", "Strike"));
	headerCol.add(new PtfHeaderCellVO("6", "Vol"));
	headerCol.add(new PtfHeaderCellVO("6", "Vol D-1"));
	headerCol.add(new PtfHeaderCellVO("2", "P&L%"));
	headerCol.add(new PtfHeaderCellVO("6", "P&L Mtd%"));
	headerCol.add(new PtfHeaderCellVO("6", "P&L"));
	headerCol.add(new PtfHeaderCellVO("3", "Px"));
	headerCol.add(new PtfHeaderCellVO("6", "Px D-1"));
	return headerCol;
    }

}
