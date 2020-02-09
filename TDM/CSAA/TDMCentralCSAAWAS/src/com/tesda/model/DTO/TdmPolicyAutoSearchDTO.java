package com.tesda.model.DTO;

import java.util.List;

public class TdmPolicyAutoSearchDTO {

	private String codeBranch;
	private String envType;
	private String policyType;
	private String policyStage;
	private String policyState;
	private String policyTerm;
	private String addproductType;

	private String policyCovge;
	private String riskCovge;
	private String noOfDrivers;
	private String noOfVehi;
	private String noOfNamedInsu;
	private String noOfViola;
	private String payMethod;
	private String assoPayReq;
	private String assoDocReq;
	private String assoDocType;
	private String assoBillPlanType;

	private String testCaseId;
	private String testCaseName;

	private boolean showHideFlag;
	private boolean showHideFlagDoc;
	private boolean msgFlag;
	private int count;

	private String searchCriti;
	private String searchRecordsNo;
	private List<TdmPolicyAutoSearchResultDTO> tdmPolicyAutoSearchResultDTOList;
	private List<AutoEmailDTO> autoEmailDTOs;

	private List<TdmPolicyAutoSearchResultDTO> tdmPolicyFullAutoSearchResultDTOList;

	public String getEnvType() {
		return envType;
	}

	public void setEnvType(String envType) {
		this.envType = envType;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public String getPolicyStage() {
		return policyStage;
	}

	public void setPolicyStage(String policyStage) {
		this.policyStage = policyStage;
	}

	public String getPolicyState() {
		return policyState;
	}

	public void setPolicyState(String policyState) {
		this.policyState = policyState;
	}

	public String getPolicyTerm() {
		return policyTerm;
	}

	public void setPolicyTerm(String policyTerm) {
		this.policyTerm = policyTerm;
	}

	public String getPolicyCovge() {
		return policyCovge;
	}

	public void setPolicyCovge(String policyCovge) {
		this.policyCovge = policyCovge;
	}

	public String getNoOfDrivers() {
		return noOfDrivers;
	}

	public void setNoOfDrivers(String noOfDrivers) {
		this.noOfDrivers = noOfDrivers;
	}

	public String getNoOfVehi() {
		return noOfVehi;
	}

	public void setNoOfVehi(String noOfVehi) {
		this.noOfVehi = noOfVehi;
	}

	public String getNoOfNamedInsu() {
		return noOfNamedInsu;
	}

	public void setNoOfNamedInsu(String noOfNamedInsu) {
		this.noOfNamedInsu = noOfNamedInsu;
	}

	public String getNoOfViola() {
		return noOfViola;
	}

	public void setNoOfViola(String noOfViola) {
		this.noOfViola = noOfViola;
	}

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public String getAssoPayReq() {
		return assoPayReq;
	}

	public void setAssoPayReq(String assoPayReq) {
		this.assoPayReq = assoPayReq;
	}

	public String getAssoDocReq() {
		return assoDocReq;
	}

	public void setAssoDocReq(String assoDocReq) {
		this.assoDocReq = assoDocReq;
	}

	public String getAssoDocType() {
		return assoDocType;
	}

	public void setAssoDocType(String assoDocType) {
		this.assoDocType = assoDocType;
	}

	public String getAssoBillPlanType() {
		return assoBillPlanType;
	}

	public void setAssoBillPlanType(String assoBillPlanType) {
		this.assoBillPlanType = assoBillPlanType;
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

	public List<TdmPolicyAutoSearchResultDTO> getTdmPolicyAutoSearchResultDTOList() {
		return tdmPolicyAutoSearchResultDTOList;
	}

	public void setTdmPolicyAutoSearchResultDTOList(
			List<TdmPolicyAutoSearchResultDTO> tdmPolicyAutoSearchResultDTOList) {
		this.tdmPolicyAutoSearchResultDTOList = tdmPolicyAutoSearchResultDTOList;
	}

	public List<AutoEmailDTO> getAutoEmailDTOs() {
		return autoEmailDTOs;
	}

	public void setAutoEmailDTOs(List<AutoEmailDTO> autoEmailDTOs) {
		this.autoEmailDTOs = autoEmailDTOs;
	}

	public String getSearchRecordsNo() {
		return searchRecordsNo;
	}

	public void setSearchRecordsNo(String searchRecordsNo) {
		this.searchRecordsNo = searchRecordsNo;
	}

	public String getCodeBranch() {
		return codeBranch;
	}

	public void setCodeBranch(String codeBranch) {
		this.codeBranch = codeBranch;
	}

	public boolean isShowHideFlagDoc() {
		return showHideFlagDoc;
	}

	public void setShowHideFlagDoc(boolean showHideFlagDoc) {
		this.showHideFlagDoc = showHideFlagDoc;
	}

	public String getSearchCriti() {
		return searchCriti;
	}

	public void setSearchCriti(String searchCriti) {
		this.searchCriti = searchCriti;
	}

	public void setFullTdmPolicyAutoSearchResultDTOList(
			List<TdmPolicyAutoSearchResultDTO> tdmPolicyAutoSearchResultDTOList) {
		this.tdmPolicyFullAutoSearchResultDTOList = tdmPolicyAutoSearchResultDTOList;
	}

	public List<TdmPolicyAutoSearchResultDTO> getFullTdmPolicyAutoSearchResultDTOList() {
		return tdmPolicyFullAutoSearchResultDTOList;
	}

	public List<TdmPolicyAutoSearchResultDTO> getTdmPolicyFullAutoSearchResultDTOList() {
		return tdmPolicyFullAutoSearchResultDTOList;
	}

	public void setTdmPolicyFullAutoSearchResultDTOList(
			List<TdmPolicyAutoSearchResultDTO> tdmPolicyFullAutoSearchResultDTOList) {
		this.tdmPolicyFullAutoSearchResultDTOList = tdmPolicyFullAutoSearchResultDTOList;
	}

	public String getRiskCovge() {
		return riskCovge;
	}

	public void setRiskCovge(String riskCovge) {
		this.riskCovge = riskCovge;
	}

	public String getAddproductType() {
		return addproductType;
	}

	public void setAddproductType(String addproductType) {
		this.addproductType = addproductType;
	}

}
