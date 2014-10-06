package com.ubp.volart.dao;

import java.util.Date;
import java.util.List;

import com.ubp.volart.model.indicator.BetaTarget;
import com.ubp.volart.model.indicator.DStat;
import com.ubp.volart.model.indicator.RelativeValue;

public interface IndicatorDAO {

    List<DStat> findDStatByDate(Date aDate);

    List<RelativeValue> findRelativeValueByDate(Date aDate);

    List<BetaTarget> findBetaTargetByDate(Date aDate);
}
