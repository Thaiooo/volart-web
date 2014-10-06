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
@Table(name = "T_DRAW_DOWN", uniqueConstraints = @UniqueConstraint(columnNames = { "FUND_ID", "DRAW_DOWN_DATE" }))
public class DrawDown implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FUND_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_DD_FUND"))
    private Fund fund;

    @Column(name = "DRAW_DOWN_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(nullable = false)
    private double value;

    @Column(name = "START_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "END_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column(nullable = false)
    private double max;

    public Date getStartDate() {
	return startDate;
    }

    public void setStartDate(Date startDate) {
	this.startDate = startDate;
    }

    public Date getEndDate() {
	return endDate;
    }

    public void setEndDate(Date endDate) {
	this.endDate = endDate;
    }

    public double getValue() {
	return value;
    }

    public void setValue(double value) {
	this.value = value;
    }

    public double getMax() {
	return max;
    }

    public void setMax(double max) {
	this.max = max;
    }

}
