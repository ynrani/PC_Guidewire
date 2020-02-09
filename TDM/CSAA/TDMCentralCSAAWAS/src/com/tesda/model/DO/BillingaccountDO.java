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
 * The persistent class for the BILLINGACCOUNT database table.
 * 
 */
@Entity
@Table(name = "BILLINGACCOUNT")
@NamedQuery(name = "BillingaccountDO.findAll", query = "SELECT b FROM BillingaccountDO b")
public class BillingaccountDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String accountnumber;

	@Column(name = "BILLINGINFO_ID")
	private BigDecimal billinginfoId;

	@Column(name = "CUSTOMPAYMENTPLAN_ID")
	private BigDecimal custompaymentplanId;

	private String status;

	@Column(name = "\"VERSION\"")
	private BigDecimal version;

	// bi-directional many-to-one association to BalanceinfoDO
	@ManyToOne(fetch = FetchType.LAZY)
	private BalanceinfoDO balanceinfo;

	// bi-directional many-to-one association to HoldinfoDO
	@ManyToOne(fetch = FetchType.LAZY)
	private HoldinfoDO holdinfo;

	public BillingaccountDO()
	{
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccountnumber() {
		return this.accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	public BigDecimal getBillinginfoId() {
		return this.billinginfoId;
	}

	public void setBillinginfoId(BigDecimal billinginfoId) {
		this.billinginfoId = billinginfoId;
	}

	public BigDecimal getCustompaymentplanId() {
		return this.custompaymentplanId;
	}

	public void setCustompaymentplanId(BigDecimal custompaymentplanId) {
		this.custompaymentplanId = custompaymentplanId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public HoldinfoDO getHoldinfo() {
		return this.holdinfo;
	}

	public void setHoldinfo(HoldinfoDO holdinfo) {
		this.holdinfo = holdinfo;
	}

}