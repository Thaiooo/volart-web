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
@Table(name = "T_DSTAT", uniqueConstraints = @UniqueConstraint(columnNames = { "GROUP_NAME", "UNDERLYING", "DATE" }))
public class DStat implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "GROUP_NAME",nullable = false)
    private String group;

    @Column(nullable = false)
    private String underlying;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "DOWN_SPOT")
    private Double downSpot;

    @Column(name = "DOWN_DSTAT")
    private Double downDStat;

    @Column(name = "UP_SPOT")
    private Double upSpot;

    @Column(name = "UP_DSTAT")
    private Double upDStat;

    @Column(name = "TODAY_VALUE")
    private Double todayValue;

    @Column(name = "YESTERDAY_VALUE")
    private Double yesterdayValue;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getGroup() {
	return group;
    }

    public void setGroup(String group) {
	this.group = group;
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

    public Double getDownSpot() {
	return downSpot;
    }

    public void setDownSpot(Double downSpot) {
	this.downSpot = downSpot;
    }

    public Double getDownDStat() {
	return downDStat;
    }

    public void setDownDStat(Double downDStat) {
	this.downDStat = downDStat;
    }

    public Double getUpSpot() {
	return upSpot;
    }

    public void setUpSpot(Double upSpot) {
	this.upSpot = upSpot;
    }

    public Double getUpDStat() {
	return upDStat;
    }

    public void setUpDStat(Double upDStat) {
	this.upDStat = upDStat;
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

}
