package com.tdm.model.DO;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "BNK_RESERVATION")
@NamedQuery(name = "ReservationDO.findAll", query = "SELECT t FROM ReservationDO t")
public class ReservationDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Column(name = "USER_ID")
	private String userId;

	@Temporal(TemporalType.DATE)
	@Column(name = "REC_CREATE_DATE")
	private Date recCreateDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "RESV_DATE")
	private Date reserveDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "UNRESV_DATE")
	private Date unreservDate;

	@Column(name = "TEST_CASE_ID")
	private String testCaseId;

	@Column(name = "TEST_CASE_NAME")
	private String testCaseName;

	@Column(name = "PROJECT_ID")
	private String projectID;

	@Column(name = "LOCKED")
	private String locked;

	@Id
	@Column(name = "ACCOUNT_NUM")
	private String accNum;

	@Column(name = "ACCOUNT_BALANCE")
	private int accBal;

	@Column(name = "BRANCH_CODE")
	private int branchCode;

	@Column(name = "ACC_STATUS")
	private String accStatus;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "Customer_Name")
	private String custName;

	@Column(name = "CUSTOMER_SURNAME")
	private String custSurName;

	@Column(name = "CUSTOMER_NUMBER")
	private String custNum;

	@Column(name = "BLDG_NUM")
	private int buildingNum;

	@Column(name = "ADDR_LN1")
	private String addrLn1;

	@Column(name = "ADDR_LN2")
	private String addrLn2;

	@Column(name = "CITY")
	private String city;

	@Column(name = "COUNTRY")
	private String country;

	@Column(name = "ZIP_CODE")
	private String zipCode;

	@Column(name = "CUSTOMER_TYPE")
	private String custType;

	@Column(name = "CREDIT_CARD_NUM")
	private int creditCardNum;

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public Date getRecCreateDate()
	{
		return recCreateDate;
	}

	public void setRecCreateDate(Date recCreateDate)
	{
		this.recCreateDate = recCreateDate;
	}

	public Date getReserveDate()
	{
		return reserveDate;
	}

	public void setReserveDate(Date reserveDate)
	{
		this.reserveDate = reserveDate;
	}

	public Date getUnreservDate()
	{
		return unreservDate;
	}

	public void setUnreservDate(Date unreservDate)
	{
		this.unreservDate = unreservDate;
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

	public String getLocked()
	{
		return locked;
	}

	public void setLocked(String locked)
	{
		this.locked = locked;
	}

	public String getAccNum()
	{
		return accNum;
	}

	public void setAccNum(String accNum)
	{
		this.accNum = accNum;
	}

	public int getAccBal()
	{
		return accBal;
	}

	public void setAccBal(int accBal)
	{
		this.accBal = accBal;
	}

	public int getBranchCode()
	{
		return branchCode;
	}

	public void setBranchCode(int branchCode)
	{
		this.branchCode = branchCode;
	}

	public String getAccStatus()
	{
		return accStatus;
	}

	public void setAccStatus(String accStatus)
	{
		this.accStatus = accStatus;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getCustName()
	{
		return custName;
	}

	public void setCustName(String custName)
	{
		this.custName = custName;
	}

	public String getCustSurName()
	{
		return custSurName;
	}

	public void setCustSurName(String custSurName)
	{
		this.custSurName = custSurName;
	}

	public String getCustNum()
	{
		return custNum;
	}

	public void setCustNum(String custNum)
	{
		this.custNum = custNum;
	}

	public int getBuildingNum()
	{
		return buildingNum;
	}

	public void setBuildingNum(int buildingNum)
	{
		this.buildingNum = buildingNum;
	}

	public String getAddrLn1()
	{
		return addrLn1;
	}

	public void setAddrLn1(String addrLn1)
	{
		this.addrLn1 = addrLn1;
	}

	public String getAddrLn2()
	{
		return addrLn2;
	}

	public void setAddrLn2(String addrLn2)
	{
		this.addrLn2 = addrLn2;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
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

	public String getCustType()
	{
		return custType;
	}

	public void setCustType(String custType)
	{
		this.custType = custType;
	}

	public int getCreditCardNum()
	{
		return creditCardNum;
	}

	public void setCreditCardNum(int creditCardNum)
	{
		this.creditCardNum = creditCardNum;
	}

	public String getProjectID()
	{
		return projectID;
	}

	public void setProjectID(String projectID)
	{
		this.projectID = projectID;
	}

}
