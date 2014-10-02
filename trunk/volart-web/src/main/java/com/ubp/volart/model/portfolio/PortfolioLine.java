package com.ubp.volart.model.portfolio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_PTF_LINE")
public class PortfolioLine implements Serializable {

    /**
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private PortfolioLineType type;

    @Column(nullable = false)
    private int level;

    @Column(name = "ORDER_NUM", nullable = false)
    private int order;

    @Column(nullable = false)
    private String name;

    @Column(name = "QT_1")
    private Double quantity1;

    @Column(name = "QT_2")
    private Double quantity2;

    private Double nav;

    @Column(name = "NAV_FUND_PERCENT")
    private Double navFundPercent;

    private String instrument;

    @Column(name = "INST_TYPE")
    private String instrumentType;

    private Date maturity;

    private Double strike;

    private Double vol;

    @Column(name = "VOL_D1")
    private Double volD1;

    @Column(name = "PNL_PERCENT")
    private Double pnlPercent;

    @Column(name = "PNL_MTD_PERCENT")
    private Double pnlMtDPercent;

    private Double pnl;

    private Double price;

    @Column(name = "PRICE_D1")
    private Double priceD1;

    @Column(name = "TRADE_PRICE")
    private Double tradePrice;

    public Double getQuantity1() {
	return quantity1;
    }

    public void setQuantity1(Double quantity1) {
	this.quantity1 = quantity1;
    }

    public Double getQuantity2() {
	return quantity2;
    }

    public void setQuantity2(Double quantity2) {
	this.quantity2 = quantity2;
    }

    public Double getNav() {
	return nav;
    }

    public void setNav(Double nav) {
	this.nav = nav;
    }

    public Double getNavFundPercent() {
	return navFundPercent;
    }

    public void setNavFundPercent(Double navFundPercent) {
	this.navFundPercent = navFundPercent;
    }

    public String getInstrument() {
	return instrument;
    }

    public void setInstrument(String instrument) {
	this.instrument = instrument;
    }

    public String getInstrumentType() {
	return instrumentType;
    }

    public void setInstrumentType(String instrumentType) {
	this.instrumentType = instrumentType;
    }

    public Date getMaturity() {
	return maturity;
    }

    public void setMaturity(Date maturity) {
	this.maturity = maturity;
    }

    public Double getStrike() {
	return strike;
    }

    public void setStrike(Double strike) {
	this.strike = strike;
    }

    public Double getVol() {
	return vol;
    }

    public void setVol(Double vol) {
	this.vol = vol;
    }

    public Double getVolD1() {
	return volD1;
    }

    public void setVolD1(Double volD1) {
	this.volD1 = volD1;
    }

    public Double getPnlPercent() {
	return pnlPercent;
    }

    public void setPnlPercent(Double pnlPercent) {
	this.pnlPercent = pnlPercent;
    }

    public Double getPnlMtDPercent() {
	return pnlMtDPercent;
    }

    public void setPnlMtDPercent(Double pnlMtDPercent) {
	this.pnlMtDPercent = pnlMtDPercent;
    }

    public Double getPnl() {
	return pnl;
    }

    public void setPnl(Double pnl) {
	this.pnl = pnl;
    }

    public Double getPrice() {
	return price;
    }

    public void setPrice(Double price) {
	this.price = price;
    }

    public Double getPriceD1() {
	return priceD1;
    }

    public void setPriceD1(Double priceD1) {
	this.priceD1 = priceD1;
    }

    public Double getTradePrice() {
	return tradePrice;
    }

    public void setTradePrice(Double tradePrice) {
	this.tradePrice = tradePrice;
    }

    public PortfolioLineType getType() {
	return type;
    }

    public void setType(PortfolioLineType type) {
	this.type = type;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public int getLevel() {
	return level;
    }

    public void setLevel(int level) {
	this.level = level;
    }

    public int getOrder() {
	return order;
    }

    public void setOrder(int order) {
	this.order = order;
    }

}
