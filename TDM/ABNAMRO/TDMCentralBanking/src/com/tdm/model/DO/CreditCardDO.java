package com.tdm.model.DO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CREDITCARD")
@NamedQuery(name = "CreditCardDO.findAll", query = "SELECT r FROM CreditCardDO r")
public class CreditCardDO implements Serializable
{

	private static final long serialVersionUID = 1L;

	@Column(name = "CREDIT_NUM")
	private String creditNum;

	@Id
	@Column(name = "CUST_ID")
	private String custId;

	@Column(name = "CREDIT_CARD_TYPE")
	private String creditCardType;

	@Column(name = "EXP_DT")
	private String expDate;

	@Column(name = "CREDIT_LIMIT")
	private String creditLimit;

	@OneToOne
	@JoinColumn(name = "CUST_ID")
	private AccountDO accDo;

	public String getCreditNum()
	{
		return creditNum;
	}

	public void setCreditNum(String creditNum)
	{
		this.creditNum = creditNum;
	}

	public String getCustId()
	{
		return custId;
	}

	public void setCustId(String custId)
	{
		this.custId = custId;
	}

	public String getCreditCardType()
	{
		return creditCardType;
	}

	public void setCreditCardType(String creditCardType)
	{
		this.creditCardType = creditCardType;
	}

	public String getExpDate()
	{
		return expDate;
	}

	public void setExpDate(String expDate)
	{
		this.expDate = expDate;
	}

	public String getCreditLimit()
	{
		return creditLimit;
	}

	public void setCreditLimit(String creditLimit)
	{
		this.creditLimit = creditLimit;
	}

}
