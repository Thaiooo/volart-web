package com.ubp.volart.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ubp.volart.dao.UserDAO;
import com.ubp.volart.model.user.UserRole;
import com.ubp.volart.model.user.VolartUser;

@Service
@Transactional(readOnly = true)
public class VolartUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	VolartUser user = userDAO.findByUserName(username);
	if (user == null) {
	    throw new UsernameNotFoundException("No user found");
	}
	List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());
	return buildUserForAuthentication(user, authorities);
    }

    private User buildUserForAuthentication(VolartUser user, List<GrantedAuthority> authorities) {
	return new User(user.getUsername(), user.getPassword(), true, true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
	Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

	// Build user's authorities
	for (UserRole userRole : userRoles) {
	    setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
	}

	List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

	return Result;
    }

}
