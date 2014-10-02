package com.ubp.volart.dao;

import java.util.List;

import com.ubp.volart.model.common.Fund;
import com.ubp.volart.model.user.VolartUser;

public interface UserDAO {
    void insertUser(VolartUser user);

    List<VolartUser> findAllUsers();

    VolartUser findByUserName(String username);

    List<Fund> findAllowFundByUsername(String anUsername);
}
