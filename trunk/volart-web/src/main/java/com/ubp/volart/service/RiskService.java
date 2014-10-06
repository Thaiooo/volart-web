package com.ubp.volart.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ubp.volart.dao.RiskDAO;
import com.ubp.volart.model.risk.DrawDown;
import com.ubp.volart.model.risk.Greek;
import com.ubp.volart.model.risk.Var;

@Service
@Transactional(readOnly = true)
public class RiskService {

    @Autowired
    private RiskDAO riskDAO;

    public List<Var> findVarByFundAndDate(String aFundName, Date aDate) {
	return riskDAO.findVarByFundAndDate(aFundName, aDate);
    }

    public DrawDown findDrawDownByFundAndDate(String aFundName, Date aDate) {
	return riskDAO.findDrawDownByFundAndDate(aFundName, aDate);
    }

    public List<Greek> findGreekByFundDate(String aFundName, Date aDate) {
	return riskDAO.findGreekByFundAndDate(aFundName, aDate);
    }
}
