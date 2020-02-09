package com.tdm.model.DTO;

import java.util.List;

public class AccountDTO
{
	private String accountNum;

	private String customerName;

	private String balance;

	private String accoutnType;

	private String custmerId;

	private String branchCode;

	private String accountStatus;

	private String acOpendate;

	private String reservedYN;

	private String custmerType;

	private String balFrom;

	private String balTo;

	private String havCreditCard;

	private String numOfRecords;

	private String crditCardType;

	private String ccExpdateTo;

	private String title;

	private String ccExpdateFrom;

	private String dobFrom;

	private String dobTo;

	private String ccAvailablelimit;

	private String custSurName;;

	private String addrLane1;

	private String addrLane2;

	private String city;

	private String creditCardNum;

	private String country;

	private String zipCode;

	private String customerEmail;

	private boolean overDraftEnabled;

	private boolean gender;

	private String testCaseId;

	private boolean creditCard;

	private String testCaseName;
	private String searchRecordsNo;
	private List<AccountDTO> accountDTosList;

	private List<TDMBankReservationDTO> resrvationDTOsList;

	public String getAccountNum()
	{
		return accountNum;
	}

	public void setAccountNum(String accountNum)
	{
		this.accountNum = accountNum;
	}

	public String getCustomerName()
	{
		return customerName;
	}

	public void setCustomerName(String customerName)
	{
		this.customerName = customerName;
	}

	public String getBalance()
	{
		return balance;
	}

	public void setBalance(String balance)
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

	public String getCustmerId()
	{
		return custmerId;
	}

	public void setCustmerId(String custmerId)
	{
		this.custmerId = custmerId;
	}

	public String getAcOpendate()
	{
		return acOpendate;
	}

	public void setAcOpendate(String acOpendate)
	{
		this.acOpendate = acOpendate;
	}

	public List<AccountDTO> getAccountDTosList()
	{
		return accountDTosList;
	}

	public void setAccountDTosList(List<AccountDTO> accountDTosList)
	{
		this.accountDTosList = accountDTosList;
	}

	public String getReservedYN()
	{
		return reservedYN;
	}

	public void setReservedYN(String reservedYN)
	{
		this.reservedYN = reservedYN;
	}

	public String getCustmerType()
	{
		return custmerType;
	}

	public void setCustmerType(String custmerType)
	{
		this.custmerType = custmerType;
	}

	public String getBalFrom()
	{
		return balFrom;
	}

	public void setBalFrom(String balFrom)
	{
		this.balFrom = balFrom;
	}

	public String getBalTo()
	{
		return balTo;
	}

	public void setBalTo(String balTo)
	{
		this.balTo = balTo;
	}

	public String getHavCreditCard()
	{
		return havCreditCard;
	}

	public void setHavCreditCard(String havCreditCard)
	{
		this.havCreditCard = havCreditCard;
	}

	public String getNumOfRecords()
	{
		return numOfRecords;
	}

	public void setNumOfRecords(String numOfRecords)
	{
		this.numOfRecords = numOfRecords;
	}

	public String getCrditCardType()
	{
		return crditCardType;
	}

	public void setCrditCardType(String crditCardType)
	{
		this.crditCardType = crditCardType;
	}

	public String getCcExpdateTo()
	{
		return ccExpdateTo;
	}

	public void setCcExpdateTo(String ccExpdateTo)
	{
		this.ccExpdateTo = ccExpdateTo;
	}

	public String getCcExpdateFrom()
	{
		return ccExpdateFrom;
	}

	public void setCcExpdateFrom(String ccExpdateFrom)
	{
		this.ccExpdateFrom = ccExpdateFrom;
	}

	public String getCcAvailablelimit()
	{
		return ccAvailablelimit;
	}

	public void setCcAvailablelimit(String ccAvailablelimit)
	{
		this.ccAvailablelimit = ccAvailablelimit;
	}

	public String getDobFrom()
	{
		return dobFrom;
	}

	public void setDobFrom(String dobFrom)
	{
		this.dobFrom = dobFrom;
	}

	public String getDobTo()
	{
		return dobTo;
	}

	public void setDobTo(String dobTo)
	{
		this.dobTo = dobTo;
	}

	public boolean isOverDraftEnabled()
	{
		return overDraftEnabled;
	}

	public void setOverDraftEnabled(boolean overDraftEnabled)
	{
		this.overDraftEnabled = overDraftEnabled;
	}

	public boolean isGender()
	{
		return gender;
	}

	public void setGender(boolean gender)
	{
		this.gender = gender;
	}

	public boolean isCreditCard()
	{
		return creditCard;
	}

	public void setCreditCard(boolean creditCard)
	{
		this.creditCard = creditCard;
	}

	public String getCustSurName()
	{
		return custSurName;
	}

	public void setCustSurName(String custSurName)
	{
		this.custSurName = custSurName;
	}

	public String getAddrLane1()
	{
		return addrLane1;
	}

	public void setAddrLane1(String addrLane1)
	{
		this.addrLane1 = addrLane1;
	}

	public String getAddrLane2()
	{
		return addrLane2;
	}

	public void setAddrLane2(String addrLane2)
	{
		this.addrLane2 = addrLane2;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getCreditCardNum()
	{
		return creditCardNum;
	}

	public void setCreditCardNum(String creditCardNum)
	{
		this.creditCardNum = creditCardNum;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public String getZipCode()
	{
		return zipCode;
	}

	public void setZipCode(String zipCode)
	{
		this.zipCode = zipCode;
	}

	public String getTestCaseId()
	{
		return testCaseId;
	}

	public void setTestCaseId(String testCaseId)
	{
		this.testCaseId = testCaseId;
	}

	public String getTestCaseName()
	{
		return testCaseName;
	}

	public void setTestCaseName(String testCaseName)
	{
		this.testCaseName = testCaseName;
	}

	public List<TDMBankReservationDTO> getResrvationDTOsList()
	{
		return resrvationDTOsList;
	}

	public void setResrvationDTOsList(List<TDMBankReservationDTO> resrvationDTOsList)
	{
		this.resrvationDTOsList = resrvationDTOsList;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getSearchRecordsNo()
	{
		return searchRecordsNo;
	}

	public void setSearchRecordsNo(String searchRecordsNo)
	{
		this.searchRecordsNo = searchRecordsNo;
	}

	public String getCustomerEmail()
	{
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail)
	{
		this.customerEmail = customerEmail;
	}
}
