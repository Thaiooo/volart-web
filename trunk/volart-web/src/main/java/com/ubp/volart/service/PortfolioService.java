package com.ubp.volart.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ubp.volart.dao.PortfolioDAO;
import com.ubp.volart.model.Portfolio;

@Service
@Transactional(readOnly = true)
public class PortfolioService {

    @Autowired
    private PortfolioDAO ptfDAO;

    public Portfolio findByNameAndDate(String aName, Date aDate) {
	return ptfDAO.findByNameAndDate(aName, aDate);
    }
}
