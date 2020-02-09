/*---------------------------------------------------------------------------------------
* Object Name: TdmNonStandSearchDTO.Java
* 
 * Modification Block:
* --------------------------------------------------------------------------------------
* S.No. Name                Date      Bug Fix no. 		Desc
* --------------------------------------------------------------------------------------
* 1     Seshadri Chowdary   11/04/15  NA          		Created* 
* --------------------------------------------------------------------------------------
*
* Copyright: 2015 <CapGemini>
*---------------------------------------------------------------------------------------*/

package com.tesda.model.DTO;

import java.util.List;

public class TdmNonStandSearchDTO
{

	private String envType;
	private String provType;
	private String providerId;
	private String provCatgType;
	private String provSpecType;
	private String provState;
	private String provContract;
	private String provZip;
	private String searchRecordsNo;

	private String effectiveDate;
	private String termDate;
	private String tin;
	private String medicareId;
	private String contractCode;
	private String gender;

	private String testCaseId;
	private String testCaseName;

	private boolean showHideFlag;

	private String subscType;
	private String subscStatus;
	private String subscriberId;
	private String ssn;
	private String dob;
	private String subscLOB;

	private int count;

	private String claimGrpNum;
	private String claimDXCode;
	private String claimProcCode;

	private String rcptdt;
	private String claimId;
	private String claimSource;
	private String claimPOS;
	private String claimStatus;
	private String claimType;

	private List<TDMClaimTypeMastDTO> tdmClaimTypeMastDTOs;
	private List<TDMClaimStatusMastDTO> tdmClaimStatusMastDTOs;
	private List<TDMClaimPOSMastDTO> tdmClaimPOSMastDTOs;
	private List<TDMClaimSrcDTO> tdmClaimSrcDTOs;

	private List<TdmNonStandardResultListDTO> tdmNonStandardResultListDTOs;

	private List<TDMProvSearchResultListDTO> tDMProvSearchResultListDTOs;

	private List<TdmProviderTypeParentDTO> tdmProviderTypeParentDTOs;
	private List<TdmProviderCatParentDTO> tdmProviderCatParentDTOs;
	private List<TdmProviderSpecParentDTO> tdmProviderSpecParentDTOs;
	private List<TdmUsStateDTO> tdmUsStateDTOs;
	private List<String> specDropdown;

	private List<TdmSubscTypeMastDTO> tdmSubscTypeMastDTOs;
	private List<TdmSubscStatusMastDTO> tdmSubscStatusMastDTOs;
	private List<TdmSubscLobMastDTO> tdmSubscLobMastDTOs;

	public String getEnvType()
	{
		return envType;
	}

	public void setEnvType(String envType)
	{
		this.envType = envType;
	}

	public String getProvType()
	{
		return provType;
	}

	public void setProvType(String provType)
	{
		this.provType = provType;
	}

	public String getProviderId()
	{
		return providerId;
	}

	public void setProviderId(String providerId)
	{
		this.providerId = providerId;
	}

	public String getProvCatgType()
	{
		return provCatgType;
	}

	public void setProvCatgType(String provCatgType)
	{
		this.provCatgType = provCatgType;
	}

	public String getProvSpecType()
	{
		return provSpecType;
	}

	public void setProvSpecType(String provSpecType)
	{
		this.provSpecType = provSpecType;
	}

	public String getProvState()
	{
		return provState;
	}

	public void setProvState(String provState)
	{
		this.provState = provState;
	}

	public String getProvContract()
	{
		return provContract;
	}

	public void setProvContract(String provContract)
	{
		this.provContract = provContract;
	}

	public String getProvZip()
	{
		return provZip;
	}

	public void setProvZip(String provZip)
	{
		this.provZip = provZip;
	}

	public String getSearchRecordsNo()
	{
		return searchRecordsNo;
	}

	public void setSearchRecordsNo(String searchRecordsNo)
	{
		this.searchRecordsNo = searchRecordsNo;
	}

	public String getEffectiveDate()
	{
		return effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate)
	{
		this.effectiveDate = effectiveDate;
	}

	public String getTermDate()
	{
		return termDate;
	}

	public void setTermDate(String termDate)
	{
		this.termDate = termDate;
	}

	public String getTin()
	{
		return tin;
	}

	public void setTin(String tin)
	{
		this.tin = tin;
	}

	public String getMedicareId()
	{
		return medicareId;
	}

	public void setMedicareId(String medicareId)
	{
		this.medicareId = medicareId;
	}

	public String getContractCode()
	{
		return contractCode;
	}

	public void setContractCode(String contractCode)
	{
		this.contractCode = contractCode;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
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

	public boolean isShowHideFlag()
	{
		return showHideFlag;
	}

	public void setShowHideFlag(boolean showHideFlag)
	{
		this.showHideFlag = showHideFlag;
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

	public int getCount()
	{
		return count;
	}

	public void setCount(int count)
	{
		this.count = count;
	}

	public List<TDMProvSearchResultListDTO> gettDMProvSearchResultListDTOs()
	{
		return tDMProvSearchResultListDTOs;
	}

	public void settDMProvSearchResultListDTOs(
			List<TDMProvSearchResultListDTO> tDMProvSearchResultListDTOs)
	{
		this.tDMProvSearchResultListDTOs = tDMProvSearchResultListDTOs;
	}

	public List<TdmProviderTypeParentDTO> getTdmProviderTypeParentDTOs()
	{
		return tdmProviderTypeParentDTOs;
	}

	public void setTdmProviderTypeParentDTOs(
			List<TdmProviderTypeParentDTO> tdmProviderTypeParentDTOs)
	{
		this.tdmProviderTypeParentDTOs = tdmProviderTypeParentDTOs;
	}

	public List<TdmProviderCatParentDTO> getTdmProviderCatParentDTOs()
	{
		return tdmProviderCatParentDTOs;
	}

	public void setTdmProviderCatParentDTOs(List<TdmProviderCatParentDTO> tdmProviderCatParentDTOs)
	{
		this.tdmProviderCatParentDTOs = tdmProviderCatParentDTOs;
	}

	public List<TdmProviderSpecParentDTO> getTdmProviderSpecParentDTOs()
	{
		return tdmProviderSpecParentDTOs;
	}

	public void setTdmProviderSpecParentDTOs(
			List<TdmProviderSpecParentDTO> tdmProviderSpecParentDTOs)
	{
		this.tdmProviderSpecParentDTOs = tdmProviderSpecParentDTOs;
	}

	public List<TdmUsStateDTO> getTdmUsStateDTOs()
	{
		return tdmUsStateDTOs;
	}

	public void setTdmUsStateDTOs(List<TdmUsStateDTO> tdmUsStateDTOs)
	{
		this.tdmUsStateDTOs = tdmUsStateDTOs;
	}

	public List<String> getSpecDropdown()
	{
		return specDropdown;
	}

	public void setSpecDropdown(List<String> specDropdown)
	{
		this.specDropdown = specDropdown;
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

	public List<TdmSubscLobMastDTO> getTdmSubscLobMastDTOs()
	{
		return tdmSubscLobMastDTOs;
	}

	public void setTdmSubscLobMastDTOs(List<TdmSubscLobMastDTO> tdmSubscLobMastDTOs)
	{
		this.tdmSubscLobMastDTOs = tdmSubscLobMastDTOs;
	}

	public String getSubscLOB()
	{
		return subscLOB;
	}

	public void setSubscLOB(String subscLOB)
	{
		this.subscLOB = subscLOB;
	}

	public List<TdmNonStandardResultListDTO> getTdmNonStandardResultListDTOs()
	{
		return tdmNonStandardResultListDTOs;
	}

	public void setTdmNonStandardResultListDTOs(
			List<TdmNonStandardResultListDTO> tdmNonStandardResultListDTOs)
	{
		this.tdmNonStandardResultListDTOs = tdmNonStandardResultListDTOs;
	}

	public String getRcptdt()
	{
		return rcptdt;
	}

	public void setRcptdt(String rcptdt)
	{
		this.rcptdt = rcptdt;
	}

	public String getClaimId()
	{
		return claimId;
	}

	public void setClaimId(String claimId)
	{
		this.claimId = claimId;
	}

	public String getClaimSource()
	{
		return claimSource;
	}

	public void setClaimSource(String claimSource)
	{
		this.claimSource = claimSource;
	}

	public String getClaimPOS()
	{
		return claimPOS;
	}

	public void setClaimPOS(String claimPOS)
	{
		this.claimPOS = claimPOS;
	}

	public String getClaimStatus()
	{
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus)
	{
		this.claimStatus = claimStatus;
	}

	public String getClaimType()
	{
		return claimType;
	}

	public void setClaimType(String claimType)
	{
		this.claimType = claimType;
	}

	public List<TDMClaimTypeMastDTO> getTdmClaimTypeMastDTOs()
	{
		return tdmClaimTypeMastDTOs;
	}

	public void setTdmClaimTypeMastDTOs(List<TDMClaimTypeMastDTO> tdmClaimTypeMastDTOs)
	{
		this.tdmClaimTypeMastDTOs = tdmClaimTypeMastDTOs;
	}

	public List<TDMClaimStatusMastDTO> getTdmClaimStatusMastDTOs()
	{
		return tdmClaimStatusMastDTOs;
	}

	public void setTdmClaimStatusMastDTOs(List<TDMClaimStatusMastDTO> tdmClaimStatusMastDTOs)
	{
		this.tdmClaimStatusMastDTOs = tdmClaimStatusMastDTOs;
	}

	public List<TDMClaimPOSMastDTO> getTdmClaimPOSMastDTOs()
	{
		return tdmClaimPOSMastDTOs;
	}

	public void setTdmClaimPOSMastDTOs(List<TDMClaimPOSMastDTO> tdmClaimPOSMastDTOs)
	{
		this.tdmClaimPOSMastDTOs = tdmClaimPOSMastDTOs;
	}

	public List<TDMClaimSrcDTO> getTdmClaimSrcDTOs()
	{
		return tdmClaimSrcDTOs;
	}

	public void setTdmClaimSrcDTOs(List<TDMClaimSrcDTO> tdmClaimSrcDTOs)
	{
		this.tdmClaimSrcDTOs = tdmClaimSrcDTOs;
	}

	public String getClaimGrpNum()
	{
		return claimGrpNum;
	}

	public void setClaimGrpNum(String claimGrpNum)
	{
		this.claimGrpNum = claimGrpNum;
	}

	public String getClaimDXCode()
	{
		return claimDXCode;
	}

	public void setClaimDXCode(String claimDXCode)
	{
		this.claimDXCode = claimDXCode;
	}

	public String getClaimProcCode()
	{
		return claimProcCode;
	}

	public void setClaimProcCode(String claimProcCode)
	{
		this.claimProcCode = claimProcCode;
	}

}
