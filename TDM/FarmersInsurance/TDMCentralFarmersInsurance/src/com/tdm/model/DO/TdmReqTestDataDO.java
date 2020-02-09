package com.tdm.model.DO;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TDM_REQ_TEST_DATA")
public class TdmReqTestDataDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "RESERVATION_1_ID_SEQ", sequenceName = "ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RESERVATION_1_ID_SEQ")
	@Column(name = "REQ_ID")
	public int reqId;

	@Column(name = "POLICY_TYPE")
	public String policyType;

	@Column(name = "POLICY_STATECODE")
	public String policyStateCode;

	@Column(name = "SRC_SYS")
	public String srcSys;

	@Column(name = "ENV_TYPE")
	public String envType;

	@Column(name = "POLICY_REQ_DTL")
	public String policyReqDtl;

	@Column(name = "POLICY_STS")
	public String policySts;

	@Column(name = "REQ_TEAM")
	public String reqTeam;

	@Column(name = "REQ_NAME")
	public String reqName;

	@Column(name = "REQ_DATE")
	public Timestamp reqDate;

	@Column(name = "REQ_STS")
	public String reqSts;

	@Column(name = "REVIEWER_COMM")
	public String reviewerComm;

	@Column(name = "COMMENTS")
	public String comments;

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public String getPolicyStateCode() {
		return policyStateCode;
	}

	public void setPolicyStateCode(String policyStateCode) {
		this.policyStateCode = policyStateCode;
	}

	public String getSrcSys() {
		return srcSys;
	}

	public void setSrcSys(String srcSys) {
		this.srcSys = srcSys;
	}

	public String getEnvType() {
		return envType;
	}

	public void setEnvType(String envType) {
		this.envType = envType;
	}

	public String getPolicyReqDtl() {
		return policyReqDtl;
	}

	public void setPolicyReqDtl(String policyReqDtl) {
		this.policyReqDtl = policyReqDtl;
	}

	public String getPolicySts() {
		return policySts;
	}

	public void setPolicySts(String policySts) {
		this.policySts = policySts;
	}

	public String getReqTeam() {
		return reqTeam;
	}

	public void setReqTeam(String reqTeam) {
		this.reqTeam = reqTeam;
	}

	public String getReqName() {
		return reqName;
	}

	public void setReqName(String reqName) {
		this.reqName = reqName;
	}

	public Timestamp getReqDate() {
		return reqDate;
	}

	public void setReqDate(Timestamp reqDate) {
		this.reqDate = reqDate;
	}

	public String getReqSts() {
		return reqSts;
	}

	public void setReqSts(String reqSts) {
		this.reqSts = reqSts;
	}

	public String getReviewerComm() {
		return reviewerComm;
	}

	public void setReviewerComm(String reviewerComm) {
		this.reviewerComm = reviewerComm;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getReqId() {
		return reqId;
	}

	public void setReqId(int reqId) {
		this.reqId = reqId;
	}
}
