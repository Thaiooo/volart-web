package com.ubp.volart.dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ubp.volart.model.portfolio.Portfolio;

@Repository
public class PortfolioDAOImpl implements PortfolioDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Portfolio findByNameAndDate(String aName, Date aDate) {
	Portfolio ptf = null;

	String req = "from Portfolio p where p.fund.name=:name and p.date=:date";
	try {
	    ptf = (Portfolio) entityManager.createQuery(req).setParameter("name", aName).setParameter("date", aDate)
		    .getSingleResult();
	} catch (NoResultException e) {
	    return null;
	}

	return ptf;
    }
}