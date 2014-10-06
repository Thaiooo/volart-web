package com.ubp.volart.model.user;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.ubp.volart.model.common.Fund;

@Entity
@Table(name = "T_USER", uniqueConstraints = @UniqueConstraint(columnNames = { "USERNAME" }))
public class VolartUser implements Serializable {

    /**
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private int id;

    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<UserRole> userRole = new HashSet<UserRole>(0);

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "J_USER_FUND", joinColumns = @JoinColumn(name = "USER_ID", nullable = false), inverseJoinColumns = @JoinColumn(name = "FUND_ID", nullable = false))
    private Set<Fund> allowFunds = new HashSet<Fund>(0);

    public Set<Fund> getAllowFunds() {
	return allowFunds;
    }

    public void setAllowFunds(Set<Fund> allowFunds) {
	this.allowFunds = allowFunds;
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public Set<UserRole> getUserRole() {
	return userRole;
    }

    public void setUserRole(Set<UserRole> userRole) {
	this.userRole = userRole;
    }

}
