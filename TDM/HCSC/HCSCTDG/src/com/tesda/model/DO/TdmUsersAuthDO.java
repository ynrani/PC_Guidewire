/*
 * Object Name : TdmUsersAuthDO.java
 * Modification Block
 * ---------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ---------------------------------------------------------------------
 * 	1.	  vkrish14		Jun 15, 2015			NA             Created
 * ---------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.tesda.model.DO;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the TDM_USERS_AUTH database table.
 * 
 */
@Entity
@Table(name = "TDM_USERS_AUTH")
@NamedQueries({
		@NamedQuery(name = "TdmUsersAuthDO.findAll", query = "SELECT t FROM TdmUsersAuthDO t"),
		@NamedQuery(name = "TdmUsersAuthDO.findByUserId", query = "SELECT t FROM TdmUsersAuthDO t WHERE t.id.userId =:userId") })
public class TdmUsersAuthDO extends BaseDO{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TdmUsersAuthDOPK id;

	@Column(name = "ROLE")
	private String role;

	// bi-directional many-to-one association to TdmUserDO
	@OneToOne
	@JoinColumn(name = "USER_ID", insertable = false, updatable = false)
	private TdmUserDO tdmUser;

	public TdmUsersAuthDO() {
	}

	public TdmUsersAuthDOPK getId() {
		return this.id;
	}

	public void setId(TdmUsersAuthDOPK id) {
		this.id = id;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public TdmUserDO getTdmUser() {
		return this.tdmUser;
	}

	public void setTdmUser(TdmUserDO tdmUser) {
		this.tdmUser = tdmUser;
	}

}