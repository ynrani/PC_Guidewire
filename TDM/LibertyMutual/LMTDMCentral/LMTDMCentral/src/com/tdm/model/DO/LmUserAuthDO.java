package com.tdm.model.DO;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the LM_USER_AUTH database table.
 * 
 */
@Entity
@Table(name="LM_USER_AUTH")
@NamedQuery(name="LmUserAuthDO.findAll", query="SELECT l FROM LmUserAuthDO l")
public class LmUserAuthDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USER_ROLE_ID")
	private long userRoleId;

	@Column(name="\"ROLE\"")
	private String role;

	@Column(name="USER_ID")
	private String userId;

	

	//bi-directional many-to-one association to LmUserDO
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="USER_ID", insertable = false, updatable = false)
	private LmUserDO lmUser;
	
	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public LmUserAuthDO() {
	}

	public long getUserRoleId() {
		return this.userRoleId;
	}

	public void setUserRoleId(long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public LmUserDO getLmUser() {
		return this.lmUser;
	}

	public void setLmUser(LmUserDO lmUser) {
		this.lmUser = lmUser;
	}

}