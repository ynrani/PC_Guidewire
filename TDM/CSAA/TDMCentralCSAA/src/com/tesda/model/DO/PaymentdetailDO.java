package com.tesda.model.DO;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the PAYMENTDETAILS database table.
 * 
 */
@Entity
@Table(name = "PAYMENTDETAILS")
@NamedQuery(name = "PaymentdetailDO.findAll", query = "SELECT p FROM PaymentdetailDO p")
public class PaymentdetailDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String accountnumber;

	private String accounttype;

	private String accounttypecd;

	private String bankaccountnumber;

	@Column(name = "CARRIER_ID")
	private BigDecimal carrierId;

	private String dtype;

	private String status;

	// bi-directional many-to-one association to BillingaccountDO
	@ManyToOne
	@JoinColumn(name = "ACCOUNT_ID")
	private BillingaccountDO billingaccount;

	public PaymentdetailDO()
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

	public String getAccounttype() {
		return this.accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	public String getAccounttypecd() {
		return this.accounttypecd;
	}

	public void setAccounttypecd(String accounttypecd) {
		this.accounttypecd = accounttypecd;
	}

	public String getBankaccountnumber() {
		return this.bankaccountnumber;
	}

	public void setBankaccountnumber(String bankaccountnumber) {
		this.bankaccountnumber = bankaccountnumber;
	}

	public BigDecimal getCarrierId() {
		return this.carrierId;
	}

	public void setCarrierId(BigDecimal carrierId) {
		this.carrierId = carrierId;
	}

	public String getDtype() {
		return this.dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BillingaccountDO getBillingaccount() {
		return this.billingaccount;
	}

	public void setBillingaccount(BillingaccountDO billingaccount) {
		this.billingaccount = billingaccount;
	}

}