package com.datacon.model.DO;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the DATA_CON_CONNECTIONS database table.
 * 
 */
@Entity
@Table(name = "DATA_CON_CONNECTIONS")
@NamedQueries({
		@NamedQuery(name = "DataConConnectionsDO.findAll", query = "SELECT t FROM DataConConnectionsDO t"),
		@NamedQuery(name = "DataConConnectionsDO.findByUserId", query = "SELECT t FROM DataConConnectionsDO t WHERE t.actionBy =:actionBy") })
public class DataConConnectionsDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "DATA_CON_CONNECTIONS_ID_SEQ", sequenceName = "DATA_CON_CONN_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DATA_CON_CONNECTIONS_ID_SEQ")
	@Column(name = "DATA_CON_CONN_ID")
	private long dataConConnId;

	@Column(name = "DB_TYPE")
	private String dbType;

	@Column(name = "HOST_NAME")
	private String hostName;

	@Column(name = "PORT_NO")
	private long portNo;

	@Column(name = "SID")
	private String sid;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "PASS_WORD")
	private String passWord;

	@Column(name = "ACTIVE")
	private String active;

	@Column(name = "ACTION_BY")
	private String actionBy;

	@Column(name = "ACTION_DT")
	private Timestamp actionDt;

	public long getDataConConnId() {
		return dataConConnId;
	}

	public void setDataConConnId(long dataConConnId) {
		this.dataConConnId = dataConConnId;
	}

	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public long getPortNo() {
		return portNo;
	}

	public void setPortNo(long portNo) {
		this.portNo = portNo;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getActionBy() {
		return actionBy;
	}

	public void setActionBy(String actionBy) {
		this.actionBy = actionBy;
	}

	public Timestamp getActionDt() {
		return actionDt;
	}

	public void setActionDt(Timestamp actionDt) {
		this.actionDt = actionDt;
	}

}