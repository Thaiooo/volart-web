package com.ubp.volart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ubp.volart.dao.UserDAO;
import com.ubp.volart.model.Fund;

@Service
@Transactional(readOnly = true)
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public List<Fund> loadAllowFundsByUsername(String anUsername) {
	return userDAO.findAllowFundByUsername(anUsername);
    }
}
