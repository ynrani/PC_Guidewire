/*
 * Object Name : TdgUsersDO.java
 * Modification Block
 * ---------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ---------------------------------------------------------------------
 * 	1.	  vkrish14		Jun 15, 2015			NA             Created
 * ---------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.tesda.model.DO;

import java.sql.Clob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "TDG_USERS")
@NamedQueries({
		@NamedQuery(name = "TdgUsersDO.findAll", query = "SELECT t FROM TdgUsersDO t"),
		@NamedQuery(name = "TdgUsersDO.findByUserid", query = "SELECT t FROM TdgUsersDO t WHERE t.userid=:userid") })
public class TdgUsersDO extends BaseDO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private long id;
	@Column(name = "USER_ID")
	private String userid;
	@Column(name = "DBURL")
	private String url;
	@Column(name = "DBUSERNAME")
	private String username;
	@Column(name = "DBPASSWORD")
	private String password;
	@Column(name = "MASTERDATA")
	private Clob clob;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Clob getClob() {
		return clob;
	}

	public void setClob(Clob clob) {
		this.clob = clob;
	}

}
