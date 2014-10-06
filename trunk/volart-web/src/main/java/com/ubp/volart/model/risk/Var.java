package com.ubp.volart.model.risk;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.ubp.volart.model.common.Fund;

@Entity
@Table(name = "T_VAR", uniqueConstraints = @UniqueConstraint(columnNames = { "FUND_ID", "VAR_DATE" }))
public class Var implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FUND_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_VAR_FUND"))
    private Fund fund;

    @Column(name = "VAR_DATE", nullable = false)
    private Date date;

    @Column(name = "IS_MONITORING", nullable = false)
    private boolean isMonitoring;

    @Column(nullable = false)
    private String depth;

    @Column(nullable = false)
    private double level;

    @Column(nullable = false)
    private double var;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private double min;

    @Column(nullable = false)
    private double max;

    public String getDepth() {
	return depth;
    }

    public void setDepth(String depth) {
	this.depth = depth;
    }

    public double getLevel() {
	return level;
    }

    public void setLevel(double level) {
	this.level = level;
    }

    public double getVar() {
	return var;
    }

    public void setVar(double var) {
	this.var = var;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Fund getFund() {
	return fund;
    }

    public void setFund(Fund fund) {
	this.fund = fund;
    }

    public double getAmount() {
	return amount;
    }

    public void setAmount(double amount) {
	this.amount = amount;
    }

    public Date getDate() {
	return date;
    }

    public void setDate(Date date) {
	this.date = date;
    }

    public boolean isMonitoring() {
	return isMonitoring;
    }

    public void setMonitoring(boolean isMonitoring) {
	this.isMonitoring = isMonitoring;
    }

    public double getMin() {
	return min;
    }

    public void setMin(double min) {
	this.min = min;
    }

    public double getMax() {
	return max;
    }

    public void setMax(double max) {
	this.max = max;
    }

}
