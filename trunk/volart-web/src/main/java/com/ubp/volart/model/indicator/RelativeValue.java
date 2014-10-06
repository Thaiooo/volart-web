package com.ubp.volart.model.indicator;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "T_RELATIVE_VALUE", uniqueConstraints = @UniqueConstraint(columnNames = { "UNDERLYING", "DATE" }))
public class RelativeValue implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String underlying;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "TODAY_VALUE")
    private Double todayValue;

    @Column(name = "YESTERDAY_VALUE")
    private Double yesterdayValue;

    @Column(name = "LAST_MONTH_VALUE")
    private Double lastMonthValue;

    @Column(name = "LAST_MONTH_DATE")
    @Temporal(TemporalType.DATE)
    private Date lastMonthDate;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getUnderlying() {
	return underlying;
    }

    public void setUnderlying(String underlying) {
	this.underlying = underlying;
    }

    public Date getDate() {
	return date;
    }

    public void setDate(Date date) {
	this.date = date;
    }

    public Double getTodayValue() {
	return todayValue;
    }

    public void setTodayValue(Double todayValue) {
	this.todayValue = todayValue;
    }

    public Double getYesterdayValue() {
	return yesterdayValue;
    }

    public void setYesterdayValue(Double yesterdayValue) {
	this.yesterdayValue = yesterdayValue;
    }

    public Double getLastMonthValue() {
	return lastMonthValue;
    }

    public void setLastMonthValue(Double lastMonthValue) {
	this.lastMonthValue = lastMonthValue;
    }

    public Date getLastMonthDate() {
	return lastMonthDate;
    }

    public void setLastMonthDate(Date lastMonthDate) {
	this.lastMonthDate = lastMonthDate;
    }

}
