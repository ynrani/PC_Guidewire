package com.tdm.model.DO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "zurich_reservation")
@NamedQuery(name = "ZurichReservationDO.findAll", query = "SELECT t FROM ZurichReservationDO t")
public class ZurichReservationDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Column(name = "Userid")
	private String userId;

	@Id
	@Column(name = "Ins_Pol_ID")
	private String insPolId;

	@Column(name = "Pol_ID")
	private String policyId;

	@Column(name = "Fst_Name")
	private String firstName;

	@Column(name = "lst_Name")
	private String lastName;

	@Column(name = "Add_1")
	private String add1;

	@Column(name = "Add_2")
	private String add2;

	@Column(name = "Add_3")
	private String add3;

	@Column(name = "City")
	private String city;

	@Column(name = "Country")
	private String country;

	@Column(name = "Pol_Hol_Reg")
	private String policyHolderRegion;

	@Column(name = "Post_Code")
	private String postalCode;

	@Column(name = "locked")
	private String locked;

	@Column(name = "testcaseId")
	private String testCaseId;

	@Column(name = "testcasename")
	private String testCaseName;

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public String getInsPolId()
	{
		return insPolId;
	}

	public void setInsPolId(String insPolId)
	{
		this.insPolId = insPolId;
	}

	public String getPolicyId()
	{
		return policyId;
	}

	public void setPolicyId(String policyId)
	{
		this.policyId = policyId;
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

	public String getAdd1()
	{
		return add1;
	}

	public void setAdd1(String add1)
	{
		this.add1 = add1;
	}

	public String getAdd2()
	{
		return add2;
	}

	public void setAdd2(String add2)
	{
		this.add2 = add2;
	}

	public String getAdd3()
	{
		return add3;
	}

	public void setAdd3(String add3)
	{
		this.add3 = add3;
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

	public String getPolicyHolderRegion()
	{
		return policyHolderRegion;
	}

	public void setPolicyHolderRegion(String policyHolderRegion)
	{
		this.policyHolderRegion = policyHolderRegion;
	}

	public String getPostalCode()
	{
		return postalCode;
	}

	public void setPostalCode(String postalCode)
	{
		this.postalCode = postalCode;
	}

	public String getLocked()
	{
		return locked;
	}

	public void setLocked(String locked)
	{
		this.locked = locked;
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
}
