package com.ubp.volart.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ubp.volart.model.indicator.BetaTarget;
import com.ubp.volart.model.indicator.DStat;
import com.ubp.volart.model.indicator.RelativeValue;

@Repository
public class IndicatorDAOImpl implements IndicatorDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Override
    public List<BetaTarget> findBetaTargetByDate(Date aDate) {
	String req = "from BetaTarget p where p.date=:date";
	List<BetaTarget> l = entityManager.createQuery(req).setParameter("date", aDate).getResultList();
	return l;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<DStat> findDStatByDate(Date aDate) {
	String req = "from DStat p where p.date=:date";
	List<DStat> l = entityManager.createQuery(req).setParameter("date", aDate).getResultList();
	return l;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<RelativeValue> findRelativeValueByDate(Date aDate) {
	String req = "from RelativeValue p where p.date=:date";
	List<RelativeValue> l = entityManager.createQuery(req).setParameter("date", aDate).getResultList();
	return l;
    }

}