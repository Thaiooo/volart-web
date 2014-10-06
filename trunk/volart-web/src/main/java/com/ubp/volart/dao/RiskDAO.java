package com.ubp.volart.dao;

import java.util.Date;
import java.util.List;

import com.ubp.volart.model.risk.DrawDown;
import com.ubp.volart.model.risk.Greek;
import com.ubp.volart.model.risk.Var;

public interface RiskDAO {

    List<Var> findVarByFundAndDate(String aFundName, Date aDate);

    DrawDown findDrawDownByFundAndDate(String aFundName, Date aDate);

    List<Greek> findGreekByFundAndDate(String aFundName, Date aDate);
}
