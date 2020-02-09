package com.tesda.model.DO;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the ORDERCLUEENTITY database table.
 * 
 */
@Entity
@Table(name = "ORDERCLUEENTITY")
@NamedQuery(name = "OrderclueentityDO.findAll", query = "SELECT o FROM OrderclueentityDO o")
public class OrderclueentityDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String componentinstancename;

	private String connectedtoinstancename;

	private String dtype;

	private BigDecimal entitystatus;

	private String instancename;

	// bi-directional many-to-one association to PolicysummaryDO
	@ManyToOne(fetch = FetchType.LAZY)
	private PolicysummaryDO policysummary;

	public OrderclueentityDO()
	{
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getComponentinstancename() {
		return this.componentinstancename;
	}

	public void setComponentinstancename(String componentinstancename) {
		this.componentinstancename = componentinstancename;
	}

	public String getConnectedtoinstancename() {
		return this.connectedtoinstancename;
	}

	public void setConnectedtoinstancename(String connectedtoinstancename) {
		this.connectedtoinstancename = connectedtoinstancename;
	}

	public String getDtype() {
		return this.dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	public BigDecimal getEntitystatus() {
		return this.entitystatus;
	}

	public void setEntitystatus(BigDecimal entitystatus) {
		this.entitystatus = entitystatus;
	}

	public String getInstancename() {
		return this.instancename;
	}

	public void setInstancename(String instancename) {
		this.instancename = instancename;
	}

	public PolicysummaryDO getPolicysummary() {
		return this.policysummary;
	}

	public void setPolicysummary(PolicysummaryDO policysummary) {
		this.policysummary = policysummary;
	}

}