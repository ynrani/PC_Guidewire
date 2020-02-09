package com.tdm.model.DO;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the LM_USER database table.
 * 
 */
@Entity
@Table(name="LM_USER")
@NamedQuery(name="LmUserDO.findAll", query="SELECT l FROM LmUserDO l")
public class LmUserDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USER_ID")
	private String userId;

	@Column(name="ACTION_BY")
	private String actionBy;

	@Column(name="ACTION_DT")
	private Timestamp actionDt;

	@Column(name="EMAIL_ID")
	private String emailId;

	private String enabled;

	@Column(name="MOBILE_NO")
	private String mobileNo;

	private String password;

	@Column(name="USER_NAME")
	private String userName;

	//bi-directional many-to-one association to LmUserAuthDO
	@OneToOne(mappedBy="lmUser", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private LmUserAuthDO lmUserAuths;
		
	public LmUserDO() {
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getActionBy() {
		return this.actionBy;
	}

	public void setActionBy(String actionBy) {
		this.actionBy = actionBy;
	}

	public Timestamp getActionDt() {
		return this.actionDt;
	}

	public void setActionDt(Timestamp actionDt) {
		this.actionDt = actionDt;
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

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LmUserAuthDO getLmUserAuths() {
		return this.lmUserAuths;
	}

	public void setLmUserAuths(LmUserAuthDO lmUserAuths) {
		this.lmUserAuths = lmUserAuths;
	}
}