package com.ubp.volart.model.portfolio;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ubp.volart.model.common.Fund;

/**
 * Entity implementation class for Entity: Portfolio
 */
@Entity
@Table(name = "T_PORTFOLIO")
public class Portfolio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(nullable = false)
    private Double asset;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FUND_ID")
    private Fund fund;

    @Column(name = "PNL_D")
    private Double pnlD;

    @Column(name = "PNL_D1")
    private Double pnlD1;

    @Column(name = "PNL_MTD")
    private Double pnlMtD;

    @Column(name = "PNL_MTD_D1")
    private Double pnlMtDD1;

    private Double delta;

    private Double theta;

    private Double vega;

    @Column(name = "INV_PREM")
    private Double invPrem;

    @OneToMany(fetch = FetchType.EAGER)
    @OrderBy("ORDER_NUM ASC")
    @JoinColumn(name = "PTF_ID", referencedColumnName = "ID")
    private Set<PortfolioLine> lines = new HashSet<PortfolioLine>(0);

    public Portfolio() {
	super();
    }

    public Set<PortfolioLine> getLines() {
	return lines;
    }

    public void setLines(Set<PortfolioLine> lines) {
	this.lines = lines;
    }

    public Double getAsset() {
	return this.asset;
    }

    public void setAsset(Double asset) {
	this.asset = asset;
    }

    public Long getId() {
	return this.id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Date getDate() {
	return this.date;
    }

    public void setDate(Date date) {
	this.date = date;
    }

    public Double getDelta() {
	return this.delta;
    }

    public void setDelta(Double delta) {
	this.delta = delta;
    }

    public Double getInvPrem() {
	return this.invPrem;
    }

    public void setInvPrem(Double invPrem) {
	this.invPrem = invPrem;
    }

    public Fund getFund() {
	return fund;
    }

    public void setFund(Fund fund) {
	this.fund = fund;
    }

    public Double getPnlD() {
	return this.pnlD;
    }

    public void setPnlD(Double pnlD) {
	this.pnlD = pnlD;
    }

    public Double getPnlD1() {
	return this.pnlD1;
    }

    public void setPnlD1(Double pnlD1) {
	this.pnlD1 = pnlD1;
    }

    public Double getPnlMtD() {
	return this.pnlMtD;
    }

    public void setPnlMtD(Double pnlMtD) {
	this.pnlMtD = pnlMtD;
    }

    public Double getPnlMtDD1() {
	return pnlMtDD1;
    }

    public void setPnlMtDD1(Double pnlMtDD1) {
	this.pnlMtDD1 = pnlMtDD1;
    }

    public Double getTheta() {
	return this.theta;
    }

    public void setTheta(Double theta) {
	this.theta = theta;
    }

    public Double getVega() {
	return this.vega;
    }

    public void setVega(Double vega) {
	this.vega = vega;
    }

}
