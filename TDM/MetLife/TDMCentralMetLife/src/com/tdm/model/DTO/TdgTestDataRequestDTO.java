package com.tdm.model.DTO;

import java.util.List;

public class TdgTestDataRequestDTO
{
	private String testCaseNo;
	private String reqDesc;
	private String functionality;
	private String noOfRec;
	private String reqType;
	private String priority;
	private String etc;
	private List<TdgTestDataRequestDTO> tdgTestDataRequestDTOList = null;

	public String getTestCaseNo()
	{
		return testCaseNo;
	}

	public void setTestCaseNo(String testCaseNo)
	{
		this.testCaseNo = testCaseNo;
	}

	public String getReqDesc()
	{
		return reqDesc;
	}

	public void setReqDesc(String reqDesc)
	{
		this.reqDesc = reqDesc;
	}

	public String getFunctionality()
	{
		return functionality;
	}

	public void setFunctionality(String functionality)
	{
		this.functionality = functionality;
	}

	public String getNoOfRec()
	{
		return noOfRec;
	}

	public void setNoOfRec(String noOfRec)
	{
		this.noOfRec = noOfRec;
	}

	public String getReqType()
	{
		return reqType;
	}

	public void setReqType(String reqType)
	{
		this.reqType = reqType;
	}

	public String getPriority()
	{
		return priority;
	}

	public void setPriority(String priority)
	{
		this.priority = priority;
	}

	public String getEtc()
	{
		return etc;
	}

	public void setEtc(String etc)
	{
		this.etc = etc;
	}

	public List<TdgTestDataRequestDTO> getTdgTestDataRequestDTOList()
	{
		return tdgTestDataRequestDTOList;
	}

	public void setTdgTestDataRequestDTOList(List<TdgTestDataRequestDTO> tdgTestDataRequestDTOList)
	{
		this.tdgTestDataRequestDTOList = tdgTestDataRequestDTOList;
	}

}
