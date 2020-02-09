/*
 * Object Name : TdmUserDO.java
 * Modification Block
 * ---------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ---------------------------------------------------------------------
 * 	1.	  vkrish14		Jun 15, 2015			NA             Created
 * ---------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.tesda.model.DO;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the TDM_USERS database table.
 * 
 */
@Entity
@Table(name = "TDM_USERS")
@NamedQueries({
		@NamedQuery(name = "TdmUserDO.findAll", query = "SELECT t FROM TdmUserDO t"),
		@NamedQuery(name = "TdmUserDO.findByUserId", query = "SELECT t FROM TdmUserDO t WHERE t.userId =:userId") })
public class TdmUserDO extends BaseDO{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "USER_ID")
	private String userId;

	@Column(name = "EMAIL_ID")
	private String emailId;

	private String enabled;

	@Column(name = "MOBILE_NO")
	private String mobileNo;

	private String password;

	private String username;

	// bi-directional many-to-one association to TdmUsersAuthDO
	@OneToOne(mappedBy = "tdmUser", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private TdmUsersAuthDO tdmUsersAuths;

	public TdmUserDO() {
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public TdmUsersAuthDO getTdmUsersAuths() {
		return this.tdmUsersAuths;
	}

	public void setTdmUsersAuths(TdmUsersAuthDO tdmUsersAuths) {
		this.tdmUsersAuths = tdmUsersAuths;
	}

}