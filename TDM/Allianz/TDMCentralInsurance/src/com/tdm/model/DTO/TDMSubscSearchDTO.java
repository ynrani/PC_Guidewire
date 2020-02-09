package com.tdm.model.DTO;

import java.util.List;

public class TDMSubscSearchDTO
{

	private String envType;
	private String subscGender;
	private String subscType;
	private String subscStatus;
	private String subscState;
	private String subscLOB;
	private String subscZip;
	private String subscAgeStart;
	private String subscAgeEnd;
	private String subscWithCOB;

	private String searchRecordsNo;

	private String userId;

	private String subscriberId;
	private String ssn;
	private String dob;
	private String planID;
	private String planName;
	private String termDate;
	private String contractCode;

	private String testCaseId;
	private String testCaseName;

	private boolean showHideFlag;
	private boolean msgFlag;
	private String pcp;

	private int count;
	private List<TDMSubscSearchResultListDTO> tDMSubscSearchResultListDTOs;
	private List<TdmSubscTypeMastDTO> tdmSubscTypeMastDTOs = null;
	private List<TdmSubscStatusMastDTO> tdmSubscStatusMastDTOs = null;
	private List<TdmUsStateDTO> tdmUsStateDTOs = null;
	private List<TdmSubscLobMastDTO> tdmSubscLobMastDTOs = null;

	private List<AutoEmailDTO> autoEmailDTOs;

	public String getEnvType()
	{
		return envType;
	}

	public void setEnvType(String envType)
	{
		this.envType = envType;
	}

	public String getSubscGender()
	{
		return subscGender;
	}

	public void setSubscGender(String subscGender)
	{
		this.subscGender = subscGender;
	}

	public String getSubscType()
	{
		return subscType;
	}

	public void setSubscType(String subscType)
	{
		this.subscType = subscType;
	}

	public String getSubscStatus()
	{
		return subscStatus;
	}

	public void setSubscStatus(String subscStatus)
	{
		this.subscStatus = subscStatus;
	}

	public String getSubscState()
	{
		return subscState;
	}

	public void setSubscState(String subscState)
	{
		this.subscState = subscState;
	}

	public String getSubscLOB()
	{
		return subscLOB;
	}

	public void setSubscLOB(String subscLOB)
	{
		this.subscLOB = subscLOB;
	}

	public String getSubscZip()
	{
		return subscZip;
	}

	public void setSubscZip(String subscZip)
	{
		this.subscZip = subscZip;
	}

	public String getSubscAgeStart()
	{
		return subscAgeStart;
	}

	public void setSubscAgeStart(String subscAgeStart)
	{
		this.subscAgeStart = subscAgeStart;
	}

	public String getSubscAgeEnd()
	{
		return subscAgeEnd;
	}

	public void setSubscAgeEnd(String subscAgeEnd)
	{
		this.subscAgeEnd = subscAgeEnd;
	}

	public String getSubscWithCOB()
	{
		return subscWithCOB;
	}

	public void setSubscWithCOB(String subscWithCOB)
	{
		this.subscWithCOB = subscWithCOB;
	}

	public String getSearchRecordsNo()
	{
		return searchRecordsNo;
	}

	public void setSearchRecordsNo(String searchRecordsNo)
	{
		this.searchRecordsNo = searchRecordsNo;
	}

	public int getCount()
	{
		return count;
	}

	public void setCount(int count)
	{
		this.count = count;
	}

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public List<TDMSubscSearchResultListDTO> gettDMSubscSearchResultListDTOs()
	{
		return tDMSubscSearchResultListDTOs;
	}

	public void settDMSubscSearchResultListDTOs(
			List<TDMSubscSearchResultListDTO> tDMSubscSearchResultListDTOs)
	{
		this.tDMSubscSearchResultListDTOs = tDMSubscSearchResultListDTOs;
	}

	public String getSubscriberId()
	{
		return subscriberId;
	}

	public void setSubscriberId(String subscriberId)
	{
		this.subscriberId = subscriberId;
	}

	public String getSsn()
	{
		return ssn;
	}

	public void setSsn(String ssn)
	{
		this.ssn = ssn;
	}

	public String getDob()
	{
		return dob;
	}

	public void setDob(String dob)
	{
		this.dob = dob;
	}

	public String getPlanID()
	{
		return planID;
	}

	public void setPlanID(String planID)
	{
		this.planID = planID;
	}

	public String getPlanName()
	{
		return planName;
	}

	public void setPlanName(String planName)
	{
		this.planName = planName;
	}

	public String getTermDate()
	{
		return termDate;
	}

	public void setTermDate(String termDate)
	{
		this.termDate = termDate;
	}

	public String getContractCode()
	{
		return contractCode;
	}

	public void setContractCode(String contractCode)
	{
		this.contractCode = contractCode;
	}

	public boolean isShowHideFlag()
	{
		return showHideFlag;
	}

	public void setShowHideFlag(boolean showHideFlag)
	{
		this.showHideFlag = showHideFlag;
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

	public List<TdmSubscTypeMastDTO> getTdmSubscTypeMastDTOs()
	{
		return tdmSubscTypeMastDTOs;
	}

	public void setTdmSubscTypeMastDTOs(List<TdmSubscTypeMastDTO> tdmSubscTypeMastDTOs)
	{
		this.tdmSubscTypeMastDTOs = tdmSubscTypeMastDTOs;
	}

	public List<TdmSubscStatusMastDTO> getTdmSubscStatusMastDTOs()
	{
		return tdmSubscStatusMastDTOs;
	}

	public void setTdmSubscStatusMastDTOs(List<TdmSubscStatusMastDTO> tdmSubscStatusMastDTOs)
	{
		this.tdmSubscStatusMastDTOs = tdmSubscStatusMastDTOs;
	}

	public List<TdmUsStateDTO> getTdmUsStateDTOs()
	{
		return tdmUsStateDTOs;
	}

	public void setTdmUsStateDTOs(List<TdmUsStateDTO> tdmUsStateDTOs)
	{
		this.tdmUsStateDTOs = tdmUsStateDTOs;
	}

	public List<TdmSubscLobMastDTO> getTdmSubscLobMastDTOs()
	{
		return tdmSubscLobMastDTOs;
	}

	public void setTdmSubscLobMastDTOs(List<TdmSubscLobMastDTO> tdmSubscLobMastDTOs)
	{
		this.tdmSubscLobMastDTOs = tdmSubscLobMastDTOs;
	}

	public String getPcp()
	{
		return pcp;
	}

	public void setPcp(String pcp)
	{
		this.pcp = pcp;
	}

	public List<AutoEmailDTO> getAutoEmailDTOs()
	{
		return autoEmailDTOs;
	}

	public void setAutoEmailDTOs(List<AutoEmailDTO> autoEmailDTOs)
	{
		this.autoEmailDTOs = autoEmailDTOs;
	}

	public boolean isMsgFlag()
	{
		return msgFlag;
	}

	public void setMsgFlag(boolean msgFlag)
	{
		this.msgFlag = msgFlag;
	}

}
