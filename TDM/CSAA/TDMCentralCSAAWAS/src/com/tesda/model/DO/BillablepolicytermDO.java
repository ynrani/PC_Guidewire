package com.tesda.model.DO;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the BILLABLEPOLICYTERM database table.
 * 
 */
@Entity
@Table(name = "BILLABLEPOLICYTERM")
@NamedQuery(name = "BillablepolicytermDO.findAll", query = "SELECT b FROM BillablepolicytermDO b")
public class BillablepolicytermDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "ACCOUNT_ID")
	private BigDecimal accountId;

	@Column(name = "HOLDINFO_ID")
	private BigDecimal holdinfoId;

	private String status;

	// bi-directional many-to-one association to BalanceinfoDO
	@ManyToOne(fetch = FetchType.LAZY)
	private BalanceinfoDO balanceinfo;

	public BillablepolicytermDO()
	{
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getAccountId() {
		return this.accountId;
	}

	public void setAccountId(BigDecimal accountId) {
		this.accountId = accountId;
	}

	public BigDecimal getHoldinfoId() {
		return this.holdinfoId;
	}

	public void setHoldinfoId(BigDecimal holdinfoId) {
		this.holdinfoId = holdinfoId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BalanceinfoDO getBalanceinfo() {
		return this.balanceinfo;
	}

	public void setBalanceinfo(BalanceinfoDO balanceinfo) {
		this.balanceinfo = balanceinfo;
	}

}