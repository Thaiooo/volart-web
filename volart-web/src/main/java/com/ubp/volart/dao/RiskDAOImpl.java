package com.ubp.volart.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ubp.volart.model.risk.DrawDown;
import com.ubp.volart.model.risk.Greek;
import com.ubp.volart.model.risk.Var;

@Repository
public class RiskDAOImpl implements RiskDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public DrawDown findDrawDownByFundAndDate(String aFundName, Date aDate) {
	String req = "from DrawDown p where p.fund.name=:fundName and p.date=:date";
	DrawDown r;
	try {
	    r = (DrawDown) entityManager.createQuery(req).setParameter("fundName", aFundName)
		    .setParameter("date", aDate).getSingleResult();
	} catch (NoResultException e) {
	    return null;
	}
	return r;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Greek> findGreekByFundAndDate(String aFundName, Date aDate) {
	String req = "from Greek p where p.fund.name=:fundName and p.date=:date";
	List<Greek> l = entityManager.createQuery(req).setParameter("fundName", aFundName).setParameter("date", aDate)
		.getResultList();
	return l;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Var> findVarByFundAndDate(String aFundName, Date aDate) {
	String req = "from Var p where p.fund.name=:fundName and p.date=:date";
	List<Var> l = entityManager.createQuery(req).setParameter("fundName", aFundName).setParameter("date", aDate)
		.getResultList();
	return l;
    }

}