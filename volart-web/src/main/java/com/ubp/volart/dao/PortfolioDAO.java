package com.ubp.volart.dao;

import java.util.Date;

import com.ubp.volart.model.portfolio.Portfolio;

public interface PortfolioDAO {

    Portfolio findByNameAndDate(String aName, Date aDate);
}
