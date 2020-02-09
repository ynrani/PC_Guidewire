package com.tdm.model.DTO;

import java.util.List;

public class TdmPolicyClaimSearchDTO
{

	private String envType;
	private String dataSource;
	private String sourceSystem;
	private String lob;
	private String claimStatus;
	private String claimState;

	private String namedInsu;
	private String policyNo;
	private String lossDt;

	private String searchRecordsNo;
	private String userId;
	private String testCaseId;
	private String testCaseName;

	private boolean showHideFlag;
	private boolean msgFlag;
	private int count;

	private List<TdmClaimSearchResultDTO> tdmClaimSearchResultDTOs;

	private List<AutoEmailDTO> autoEmailDTOs;

	public String getEnvType() {
		return envType;
	}

	public void setEnvType(String envType) {
		this.envType = envType;
	}

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getSourceSystem() {
		return sourceSystem;
	}

	public void setSourceSystem(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}

	public String getLob() {
		return lob;
	}

	public void setLob(String lob) {
		this.lob = lob;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public String getClaimState() {
		return claimState;
	}

	public void setClaimState(String claimState) {
		this.claimState = claimState;
	}

	public String getNamedInsu() {
		return namedInsu;
	}

	public void setNamedInsu(String namedInsu) {
		this.namedInsu = namedInsu;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getLossDt() {
		return lossDt;
	}

	public void setLossDt(String lossDt) {
		this.lossDt = lossDt;
	}

	public String getSearchRecordsNo() {
		return searchRecordsNo;
	}

	public void setSearchRecordsNo(String searchRecordsNo) {
		this.searchRecordsNo = searchRecordsNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTestCaseId() {
		return testCaseId;
	}

	public void setTestCaseId(String testCaseId) {
		this.testCaseId = testCaseId;
	}

	public String getTestCaseName() {
		return testCaseName;
	}

	public void setTestCaseName(String testCaseName) {
		this.testCaseName = testCaseName;
	}

	public boolean isShowHideFlag() {
		return showHideFlag;
	}

	public void setShowHideFlag(boolean showHideFlag) {
		this.showHideFlag = showHideFlag;
	}

	public boolean isMsgFlag() {
		return msgFlag;
	}

	public void setMsgFlag(boolean msgFlag) {
		this.msgFlag = msgFlag;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<AutoEmailDTO> getAutoEmailDTOs() {
		return autoEmailDTOs;
	}

	public void setAutoEmailDTOs(List<AutoEmailDTO> autoEmailDTOs) {
		this.autoEmailDTOs = autoEmailDTOs;
	}

	public List<TdmClaimSearchResultDTO> getTdmClaimSearchResultDTOs() {
		return tdmClaimSearchResultDTOs;
	}

	public void setTdmClaimSearchResultDTOs(List<TdmClaimSearchResultDTO> tdmClaimSearchResultDTOs) {
		this.tdmClaimSearchResultDTOs = tdmClaimSearchResultDTOs;
	}

}
