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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.ubp.volart.model.common.Fund;

@Entity
@Table(name = "T_GREEK", uniqueConstraints = @UniqueConstraint(columnNames = { "FUND_ID", "GREEK_DATE", "NAME" }))
public class Greek implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FUND_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_GREEK_FUND"))
    private Fund fund;

    @Column(nullable = false)
    private String name;

    @Column(name = "GREEK_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(nullable = false)
    private double value;

    @Column(nullable = false)
    private double min;

    @Column(nullable = false)
    private double max;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Date getDate() {
	return date;
    }

    public void setDate(Date date) {
	this.date = date;
    }

    public double getValue() {
	return value;
    }

    public void setValue(double value) {
	this.value = value;
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

    public Fund getFund() {
	return fund;
    }

    public void setFund(Fund fund) {
	this.fund = fund;
    }

}
