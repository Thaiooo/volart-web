package com.ubp.volart.dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ubp.volart.model.Portfolio;

@Repository
public class PortfolioDAOImpl implements PortfolioDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Portfolio findByNameAndDate(String aName, Date aDate) {
	Portfolio ptf = null;

	try {
	    ptf = (Portfolio) entityManager.createQuery("from Portfolio p where p.fund.name=:name and p.date=:date")
		    .setParameter("name", aName).setParameter("date", aDate).getSingleResult();
	} catch (NoResultException e) {
	    return null;
	}

	return ptf;
    }
}