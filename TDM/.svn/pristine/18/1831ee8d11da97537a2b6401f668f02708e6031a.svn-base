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
@Table(name = "CUSTOMER")
@NamedQuery(name = "CustomerDO.findAll", query = "SELECT r FROM CustomerDO r")
public class CustomerDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "BUILDING_NO")
	private String buildingNum;

	@Id
	@Column(name = "CUST_ID")
	private String customerId;

	@Column(name = "ZIP_CODE")
	private String zipCode;

	@Column(name = "PHONE_NUMBER")
	private String mobileNum;

	@Column(name = "MAIL_ID")
	private String email;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "ACCT_NUM")
	private String accountNum;

	@Column(name = "CREDIT_CARD_IND")
	private String creditCardInd;

	@Column(name = "PRODUCT_CODE")
	private String productCode;

	@Column(name = "CONTACT_POINT")
	private String contactPoint;

	@Column(name = "COUNTRY")
	private String country;

	@Column(name = "ADDR_LN1")
	private String addrLane1;

	@Column(name = "ADDR_LN2")
	private String addrLane2;

	@Column(name = "CITY")
	private String city;

	@Column(name = "DOB")
	private String dob;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "CUSTOMER_TYPE")
	private String custmerType;

	@OneToOne
	@JoinColumn(name = "CUST_ID")
	private AccountDO accountDo;

	public String getCustomerType()
	{
		return custmerType;
	}

	public void setCustomerType(String customerType)
	{
		this.custmerType = customerType;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getBuildingNum()
	{
		return buildingNum;
	}

	public void setBuildingNum(String buildingNum)
	{
		this.buildingNum = buildingNum;
	}

	public String getCustomerId()
	{
		return customerId;
	}

	public void setCustomerId(String customerId)
	{
		this.customerId = customerId;
	}

	public String getZipCode()
	{
		return zipCode;
	}

	public void setZipCode(String zipCode)
	{
		this.zipCode = zipCode;
	}

	public String getMobileNum()
	{
		return mobileNum;
	}

	public void setMobileNum(String mobileNum)
	{
		this.mobileNum = mobileNum;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public String getAccountNum()
	{
		return accountNum;
	}

	public void setAccountNum(String accountNum)
	{
		this.accountNum = accountNum;
	}

	public String getCreditCardInd()
	{
		return creditCardInd;
	}

	public void setCreditCardInd(String creditCardInd)
	{
		this.creditCardInd = creditCardInd;
	}

	public String getProductCode()
	{
		return productCode;
	}

	public void setProductCode(String productCode)
	{
		this.productCode = productCode;
	}

	public String getContactPoint()
	{
		return contactPoint;
	}

	public void setContactPoint(String contactPoint)
	{
		this.contactPoint = contactPoint;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
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

	public String getDob()
	{
		return dob;
	}

	public void setDob(String dob)
	{
		this.dob = dob;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getCustmerType()
	{
		return custmerType;
	}

	public void setCustmerType(String custmerType)
	{
		this.custmerType = custmerType;
	}

	public AccountDO getAccountDo()
	{
		return accountDo;
	}

	public void setAccountDo(AccountDO accountDo)
	{
		this.accountDo = accountDo;
	}
}
