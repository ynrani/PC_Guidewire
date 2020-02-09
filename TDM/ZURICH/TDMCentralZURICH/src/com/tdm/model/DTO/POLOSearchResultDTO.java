package com.tdm.model.DTO;

public class POLOSearchResultDTO
{

	private String policyId;
	private String policyHolderId;
	private String firstName;
	private String lastName;
	private String address1;
	private String city;
	private String region;
	private String country;
	private String postalCode;
	private String address2;
	private String address3;
	private String reservedYN;
	private String insPolId;

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

	public String getPolicyHolderId()
	{
		return policyHolderId;
	}

	public void setPolicyHolderId(String policyHolderId)
	{
		this.policyHolderId = policyHolderId;
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

	public String getAddress1()
	{
		return address1;
	}

	public void setAddress1(String address1)
	{
		this.address1 = address1;
	}

	public String getAddress2()
	{
		return address2;
	}

	public void setAddress2(String address2)
	{
		this.address2 = address2;
	}

	public String getAddress3()
	{
		return address3;
	}

	public void setAddress3(String address3)
	{
		this.address3 = address3;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getRegion()
	{
		return region;
	}

	public void setRegion(String region)
	{
		this.region = region;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public String getPostalCode()
	{
		return postalCode;
	}

	public void setPostalCode(String postalCode)
	{
		this.postalCode = postalCode;
	}

	public String getReservedYN()
	{
		return reservedYN;
	}

	public void setReservedYN(String reservedYN)
	{
		this.reservedYN = reservedYN;
	}

}
