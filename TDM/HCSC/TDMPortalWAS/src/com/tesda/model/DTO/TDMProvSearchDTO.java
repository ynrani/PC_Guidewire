package com.tesda.model.DTO;

import java.util.List;

public class TDMProvSearchDTO
{

	private String envType;
	private String provType;
	private String provCatgType;
	private String provSpecType;
	private String provTypicalYn;
	private String provState;
	private String provContract;
	private String provZip;
	private String provEFTYn;
	private String searchRecordsNo;

	private String taxonomyCode;
	private String effectiveDate;
	private String termDate;
	private String tin;
	private String nip;
	private String medicareId;
	private String contractCode;
	private String gender;
	private String countryCode;

	private String testCaseId;
	private String testCaseName;

	private boolean showHideFlag;
	private boolean msgFlag;
	private int count;

	private String coverage;
	private List<TDMProvSearchResultListDTO> tDMProvSearchResultListDTOs;

	private List<TdmProviderTypeParentDTO> tdmProviderTypeParentDTOs;

	private List<TdmProviderCatParentDTO> tdmProviderCatParentDTOs;

	private List<TdmProviderSpecParentDTO> tdmProviderSpecParentDTOs;
	private List<TdmUsStateDTO> tdmUsStateDTOs;

	private List<String> specDropdown;

	private List<AutoEmailDTO> autoEmailDTOs;

	public int getCount()
	{
		return count;
	}

	public void setCount(int count)
	{
		this.count = count;
	}

	public String getSearchRecordsNo()
	{
		return searchRecordsNo;
	}

	public void setSearchRecordsNo(String searchRecordsNo)
	{
		this.searchRecordsNo = searchRecordsNo;
	}

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

	public String getProvTypicalYn()
	{
		return provTypicalYn;
	}

	public void setProvTypicalYn(String provTypicalYn)
	{
		this.provTypicalYn = provTypicalYn;
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

	public String getProvEFTYn()
	{
		return provEFTYn;
	}

	public void setProvEFTYn(String provEFTYn)
	{
		this.provEFTYn = provEFTYn;
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

	public String getTaxonomyCode()
	{
		return taxonomyCode;
	}

	public void setTaxonomyCode(String taxonomyCode)
	{
		this.taxonomyCode = taxonomyCode;
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

	public String getNip()
	{
		return nip;
	}

	public void setNip(String nip)
	{
		this.nip = nip;
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

	public boolean getShowHideFlag()
	{
		return showHideFlag;
	}

	public void setShowHideFlag(boolean showHideFlag)
	{
		this.showHideFlag = showHideFlag;
	}

	public String getCountryCode()
	{
		return countryCode;
	}

	public void setCountryCode(String countryCode)
	{
		this.countryCode = countryCode;
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

	public String getCoverage()
	{
		return coverage;
	}

	public void setCoverage(String coverage)
	{
		this.coverage = coverage;
	}

}
