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
 * The persistent class for the BILLINGTRANSACTION database table.
 * 
 */
@Entity
@Table(name = "BILLINGTRANSACTION")
@NamedQuery(name = "BillingtransactionDO.findAll", query = "SELECT b FROM BillingtransactionDO b")
public class BillingtransactionDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "ACCOUNT_ID")
	private BigDecimal accountId;

	private BigDecimal amount;

	private String paymentnumber;

	private String policyid;

	private String status;

	private String subtype;

	private String transactionnumber;

	@Column(name = "\"TYPE\"")
	private String type;

	@Column(name = "\"VERSION\"")
	private BigDecimal version;

	// bi-directional many-to-one association to BalanceinfoDO
	@ManyToOne(fetch = FetchType.LAZY)
	private BalanceinfoDO balanceinfo;

	public BillingtransactionDO()
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

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getPaymentnumber() {
		return this.paymentnumber;
	}

	public void setPaymentnumber(String paymentnumber) {
		this.paymentnumber = paymentnumber;
	}

	public String getPolicyid() {
		return this.policyid;
	}

	public void setPolicyid(String policyid) {
		this.policyid = policyid;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSubtype() {
		return this.subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	public String getTransactionnumber() {
		return this.transactionnumber;
	}

	public void setTransactionnumber(String transactionnumber) {
		this.transactionnumber = transactionnumber;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getVersion() {
		return this.version;
	}

	public void setVersion(BigDecimal version) {
		this.version = version;
	}

	public BalanceinfoDO getBalanceinfo() {
		return this.balanceinfo;
	}

	public void setBalanceinfo(BalanceinfoDO balanceinfo) {
		this.balanceinfo = balanceinfo;
	}

}