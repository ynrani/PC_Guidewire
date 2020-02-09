package com.tdm.model.DO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT_DETAILS")
@NamedQuery(name = "AccountDO.findAll", query = "SELECT r FROM AccountDO r")
public class AccountDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CUST_ID")
	private String custmerId;

	@Column(name = "ACCOUNT_NUM")
	private String accountNum;

	@Column(name = "OVER_DFT_IND")
	private String overDftInd;

	@Column(name = "ACCOUNT_BALANCE")
	private int balance;

	@Column(name = "ACCOUNT_TYPE")
	private String accoutnType;

	@Column(name = "ACC_OPN_DT")
	private String acOpenDate;

	@Column(name = "BRANCH_CODE")
	private String branchCode;

	@Column(name = "ACC_STATUS")
	private String accountStatus;

	@OneToOne(mappedBy = "accountDo")
	private CustomerDO custmerDetails;
	
	@OneToOne(mappedBy = "accDo")
	private CreditCardDO creditCardDetails;

	public CreditCardDO getCreditCardDetails() {
		return creditCardDetails;
	}

	public void setCreditCardDetails(CreditCardDO creditCardDetails) {
		this.creditCardDetails = creditCardDetails;
	}

	public String getAccountNum()
	{
		return accountNum;
	}

	public void setAccountNum(String accountNum)
	{
		this.accountNum = accountNum;
	}

	public int getBalance()
	{
		return balance;
	}

	public void setBalance(int balance)
	{
		this.balance = balance;
	}

	public String getAccoutnType()
	{
		return accoutnType;
	}

	public void setAccoutnType(String accoutnType)
	{
		this.accoutnType = accoutnType;
	}

	public String getBranchCode()
	{
		return branchCode;
	}

	public void setBranchCode(String branchCode)
	{
		this.branchCode = branchCode;
	}

	public String getAccountStatus()
	{
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus)
	{
		this.accountStatus = accountStatus;
	}

	public String getOverDftInd()
	{
		return overDftInd;
	}

	public void setOverDftInd(String overDftInd)
	{
		this.overDftInd = overDftInd;
	}

	public String getAcOpenDate()
	{
		return acOpenDate;
	}

	public void setAcOpenDate(String acOpenDate)
	{
		this.acOpenDate = acOpenDate;
	}

	public String getCustmerId()
	{
		return custmerId;
	}

	public void setCustmerId(String custmerId)
	{
		this.custmerId = custmerId;
	}

	public CustomerDO getCustmerDetails()
	{
		return custmerDetails;
	}

	public void setCustmerDetails(CustomerDO custmerDetails)
	{
		this.custmerDetails = custmerDetails;
	}
}
