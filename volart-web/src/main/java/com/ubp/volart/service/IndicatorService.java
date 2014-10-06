package com.ubp.volart.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ubp.volart.dao.IndicatorDAO;
import com.ubp.volart.model.indicator.BetaTarget;
import com.ubp.volart.model.indicator.DStat;
import com.ubp.volart.model.indicator.RelativeValue;

@Service
@Transactional(readOnly = true)
public class IndicatorService {

    @Autowired
    private IndicatorDAO indicatorDAO;

    public List<BetaTarget> findBetaTargetByDate(Date aDate) {
	return indicatorDAO.findBetaTargetByDate(aDate);
    }

    public List<RelativeValue> findRelativeValueByDate(Date aDate) {
	return indicatorDAO.findRelativeValueByDate(aDate);
    }

    public List<DStat> findDStatByDate(Date aDate) {
	return indicatorDAO.findDStatByDate(aDate);
    }
}
