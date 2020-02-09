package com.tesda.model.DO.fastlaneMapping;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the FASTLANE_ACAAU_TAB database table.
 * 
 */
@Entity
@Table(name = "FASTLANE_ACAAU_TAB")
@NamedQuery(name = "FastlaneAcaauTab.findAll", query = "SELECT f FROM FastlaneAcaauTab f")
public class FastlaneAcaauTab implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Column(name = "CATEGORY")
	private String category;

	@Column(name = "COMP_NM")
	private String compNm;

	@Column(name = "DOC_DESC")
	private String docDesc;

	@Column(name = "DOC_TYPE")
	private String docType;

	@Column(name = "EFF_DT")
	private Timestamp effDt;

	@Column(name = "IMPORT_UID")
	private String importUid;

	@Column(name = "NS_DATE")
	private Timestamp nsDate;

	@Column(name = "POL_NUM")
	private String polNum;

	@Column(name = "POL_STATE")
	private String polState;

	@Column(name = "REVNUM")
	private int revnum;

	@Id
	@Column(name = "VS_RECID")
	private int vsRecid;

	public FastlaneAcaauTab()
	{
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCompNm() {
		return compNm;
	}

	public void setCompNm(String compNm) {
		this.compNm = compNm;
	}

	public String getDocDesc() {
		return docDesc;
	}

	public void setDocDesc(String docDesc) {
		this.docDesc = docDesc;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public Timestamp getEffDt() {
		return effDt;
	}

	public void setEffDt(Timestamp effDt) {
		this.effDt = effDt;
	}

	public String getImportUid() {
		return importUid;
	}

	public void setImportUid(String importUid) {
		this.importUid = importUid;
	}

	public Timestamp getNsDate() {
		return nsDate;
	}

	public void setNsDate(Timestamp nsDate) {
		this.nsDate = nsDate;
	}

	public String getPolNum() {
		return polNum;
	}

	public void setPolNum(String polNum) {
		this.polNum = polNum;
	}

	public String getPolState() {
		return polState;
	}

	public void setPolState(String polState) {
		this.polState = polState;
	}

	public int getRevnum() {
		return revnum;
	}

	public void setRevnum(int revnum) {
		this.revnum = revnum;
	}

	public int getVsRecid() {
		return vsRecid;
	}

	public void setVsRecid(int vsRecid) {
		this.vsRecid = vsRecid;
	}

}