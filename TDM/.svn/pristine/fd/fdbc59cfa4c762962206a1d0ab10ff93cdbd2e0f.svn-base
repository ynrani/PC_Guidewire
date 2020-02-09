package com.tdm.model.DO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the REQUESTOR database table.
 * 
 */
@Entity
@Table(name = "REQUESTOR")
@NamedQuery(name = "RequestorDO.findAll", query = "SELECT r FROM RequestorDO r")
public class RequestorDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name = "COUNT_DATABASE")
	private String countDatabase;

	@Column(name = "DATA_MASK_DEV")
	private String dataMaskDev;

	@Column(name = "DATA_MASK_ONGOING_SUPPORT")
	private String dataMaskOngoingSupport;

	private String department;

	private String dfdchart;

	@Column(name = "DS_A_D_U")
	private String dsADU;

	@Column(name = "DS_SCHEMA_CHNAGE")
	private String dsSchemaChnage;

	private String dsmech;

	private String emailid;

	private String environment;

	private String hlfd;

	@Column(name = "MASK_NON_PROD")
	private String maskNonProd;

	private String name;

	private String neededby;

	@Column(name = "NO_OF_APPS")
	private String noOfApps;

	@Column(name = "NO_OF_DATABASE")
	private BigDecimal noOfDatabase;

	@Column(name = "NO_OF_TABLE")
	private String noOfTable;

	@Column(name = "NON_ENG_LANG")
	private String nonEngLang;

	@Column(name = "NON_ENGLISH_CHAR")
	private String nonEnglishChar;

	@Column(name = "NON_PROD_MASK")
	private String nonProdMask;

	private String oatpsource;

	private String odsmech;

	private String phoneno;

	@Column(name = "PII_MNPI")
	private String piiMnpi;

	@Column(name = "PLACE_MASKING_STG")
	private String placeMaskingStg;

	@Column(name = "PROD_SENS_ELEM")
	private String prodSensElem;

	@Column(name = "PRODNONPROD_UPSTEAM")
	private String prodnonprodUpsteam;

	@Column(name = "PROJECT_NAME")
	private String projectName;

	@Column(name = "PROJECT_PHASE")
	private String projectPhase;

	@Column(name = "REQUEST_TIME")
	private Timestamp requestTime;

	@Column(name = "SLA_DATA_MASKING")
	private String slaDataMasking;

	private String status;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "VAL_MASK_DATA")
	private String valMaskData;

	@Column(name = "VOL_DATA_DATA_MASK")
	private String volDataDataMask;

	@Column(name = "CHNG_REQ_CMMT")
	private String chngReqCmmt;

	@Column(name = "VNO")
	private int vno;

	@Column(name = "PROJECT_ID")
	private String projectId;

	@Column(name = "MR_IND")
	private String maskingReqInd;

	@Column(name = "SUBSETTING_IND")
	private String subSetReqInd;

	@Column(name = "DR_IND")
	private String dataRfreshReqInd;

	@Column(name = "SUBSETTING_REQ")
	private String SubSettingReqQ1;

	@Column(name = "SUBSETTING_CRITERIA")
	private String SubSettingCritQ2;

	@Column(name = "SUBSETTING_FOR_ALL_ENV")
	private String subSettingEnvQ3;

	@Column(name = "DR_FREQUENCY")
	private String drFreqQ1;

	@Column(name = "DR_FOR_NON_PROD_ENV")
	private String drNonProdEnvQ2;

	@Column(name = "DR_SLA_FOR_MASKING")
	private String drMaskingQ3;

	@Column(name = "ASSIGN_TO")
	private String assignTo;

	@Column(name = "REASON")
	private String reason;

	@OneToMany(mappedBy = "requestor", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<ReqChDO> reqChDOs;

	public RequestorDO()
	{
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCountDatabase() {
		return this.countDatabase;
	}

	public void setCountDatabase(String countDatabase) {
		this.countDatabase = countDatabase;
	}

	public String getDataMaskDev() {
		return this.dataMaskDev;
	}

	public void setDataMaskDev(String dataMaskDev) {
		this.dataMaskDev = dataMaskDev;
	}

	public String getDataMaskOngoingSupport() {
		return this.dataMaskOngoingSupport;
	}

	public void setDataMaskOngoingSupport(String dataMaskOngoingSupport) {
		this.dataMaskOngoingSupport = dataMaskOngoingSupport;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDfdchart() {
		return this.dfdchart;
	}

	public void setDfdchart(String dfdchart) {
		this.dfdchart = dfdchart;
	}

	public String getDsADU() {
		return this.dsADU;
	}

	public void setDsADU(String dsADU) {
		this.dsADU = dsADU;
	}

	public String getDsSchemaChnage() {
		return this.dsSchemaChnage;
	}

	public void setDsSchemaChnage(String dsSchemaChnage) {
		this.dsSchemaChnage = dsSchemaChnage;
	}

	public String getDsmech() {
		return this.dsmech;
	}

	public void setDsmech(String dsmech) {
		this.dsmech = dsmech;
	}

	public String getEmailid() {
		return this.emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getEnvironment() {
		return this.environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getHlfd() {
		return this.hlfd;
	}

	public void setHlfd(String hlfd) {
		this.hlfd = hlfd;
	}

	public String getMaskNonProd() {
		return this.maskNonProd;
	}

	public void setMaskNonProd(String maskNonProd) {
		this.maskNonProd = maskNonProd;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNeededby() {
		return this.neededby;
	}

	public void setNeededby(String neededby) {
		this.neededby = neededby;
	}

	public BigDecimal getNoOfDatabase() {
		return this.noOfDatabase;
	}

	public void setNoOfDatabase(BigDecimal noOfDatabase) {
		this.noOfDatabase = noOfDatabase;
	}

	public String getNoOfTable() {
		return this.noOfTable;
	}

	public void setNoOfTable(String noOfTable) {
		this.noOfTable = noOfTable;
	}

	public String getNonEngLang() {
		return this.nonEngLang;
	}

	public void setNonEngLang(String nonEngLang) {
		this.nonEngLang = nonEngLang;
	}

	public String getNonEnglishChar() {
		return this.nonEnglishChar;
	}

	public void setNonEnglishChar(String nonEnglishChar) {
		this.nonEnglishChar = nonEnglishChar;
	}

	public String getNonProdMask() {
		return this.nonProdMask;
	}

	public void setNonProdMask(String nonProdMask) {
		this.nonProdMask = nonProdMask;
	}

	public String getOatpsource() {
		return this.oatpsource;
	}

	public void setOatpsource(String oatpsource) {
		this.oatpsource = oatpsource;
	}

	public String getOdsmech() {
		return this.odsmech;
	}

	public void setOdsmech(String odsmech) {
		this.odsmech = odsmech;
	}

	public String getPhoneno() {
		return this.phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getPiiMnpi() {
		return this.piiMnpi;
	}

	public void setPiiMnpi(String piiMnpi) {
		this.piiMnpi = piiMnpi;
	}

	public String getPlaceMaskingStg() {
		return this.placeMaskingStg;
	}

	public void setPlaceMaskingStg(String placeMaskingStg) {
		this.placeMaskingStg = placeMaskingStg;
	}

	public String getProdSensElem() {
		return this.prodSensElem;
	}

	public void setProdSensElem(String prodSensElem) {
		this.prodSensElem = prodSensElem;
	}

	public String getProdnonprodUpsteam() {
		return this.prodnonprodUpsteam;
	}

	public void setProdnonprodUpsteam(String prodnonprodUpsteam) {
		this.prodnonprodUpsteam = prodnonprodUpsteam;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectPhase() {
		return this.projectPhase;
	}

	public void setProjectPhase(String projectPhase) {
		this.projectPhase = projectPhase;
	}

	public Timestamp getRequestTime() {
		return this.requestTime;
	}

	public void setRequestTime(Timestamp requestTime) {
		this.requestTime = requestTime;
	}

	public String getSlaDataMasking() {
		return this.slaDataMasking;
	}

	public void setSlaDataMasking(String slaDataMasking) {
		this.slaDataMasking = slaDataMasking;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getValMaskData() {
		return this.valMaskData;
	}

	public void setValMaskData(String valMaskData) {
		this.valMaskData = valMaskData;
	}

	public String getVolDataDataMask() {
		return this.volDataDataMask;
	}

	public void setVolDataDataMask(String volDataDataMask) {
		this.volDataDataMask = volDataDataMask;
	}

	public String getNoOfApps() {
		return noOfApps;
	}

	public void setNoOfApps(String noOfApps) {
		this.noOfApps = noOfApps;
	}

	public List<ReqChDO> getReqChDOs() {
		return reqChDOs;
	}

	public void setReqChDOs(List<ReqChDO> reqChDOs) {
		this.reqChDOs = reqChDOs;
	}

	public String getChngReqCmmt() {
		return chngReqCmmt;
	}

	public void setChngReqCmmt(String chngReqCmmt) {
		this.chngReqCmmt = chngReqCmmt;
	}

	public int getVno() {
		return vno;
	}

	public void setVno(int vno) {
		this.vno = vno;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getMaskingReqInd() {
		return maskingReqInd;
	}

	public void setMaskingReqInd(String maskingReqInd) {
		this.maskingReqInd = maskingReqInd;
	}

	public String getSubSetReqInd() {
		return subSetReqInd;
	}

	public void setSubSetReqInd(String subSetReqInd) {
		this.subSetReqInd = subSetReqInd;
	}

	public String getDataRfreshReqInd() {
		return dataRfreshReqInd;
	}

	public void setDataRfreshReqInd(String dataRfreshReqInd) {
		this.dataRfreshReqInd = dataRfreshReqInd;
	}

	public String getSubSettingReqQ1() {
		return SubSettingReqQ1;
	}

	public void setSubSettingReqQ1(String subSettingReqQ1) {
		SubSettingReqQ1 = subSettingReqQ1;
	}

	public String getSubSettingCritQ2() {
		return SubSettingCritQ2;
	}

	public void setSubSettingCritQ2(String subSettingCritQ2) {
		SubSettingCritQ2 = subSettingCritQ2;
	}

	public String getSubSettingEnvQ3() {
		return subSettingEnvQ3;
	}

	public void setSubSettingEnvQ3(String subSettingEnvQ3) {
		this.subSettingEnvQ3 = subSettingEnvQ3;
	}

	public String getDrFreqQ1() {
		return drFreqQ1;
	}

	public void setDrFreqQ1(String drFreqQ1) {
		this.drFreqQ1 = drFreqQ1;
	}

	public String getDrNonProdEnvQ2() {
		return drNonProdEnvQ2;
	}

	public void setDrNonProdEnvQ2(String drNonProdEnvQ2) {
		this.drNonProdEnvQ2 = drNonProdEnvQ2;
	}

	public String getDrMaskingQ3() {
		return drMaskingQ3;
	}

	public void setDrMaskingQ3(String drMaskingQ3) {
		this.drMaskingQ3 = drMaskingQ3;
	}

	public String getAssignTo() {
		return assignTo;
	}

	public void setAssignTo(String assignTo) {
		this.assignTo = assignTo;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}