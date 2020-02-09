package com.tesda.model.DO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the REQ_CH database table.
 * 
 */
@Entity
@Table(name = "REQ_CH")
@NamedQuery(name = "ReqChDO.findAll", query = "SELECT r FROM ReqChDO r")
public class ReqChDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_entity_seq_gen")
	@SequenceGenerator(name = "my_entity_seq_gen", sequenceName = "REQUESTOR_SEQ")
	@Column(name = "ID")
	private Long id;

	@Column(name = "APP_NAME")
	private String appName;

	@Column(name = "DB_NAME")
	private String dbName;

	@Column(name = "NO_OF_TABLE")
	private String noOfTable;

	@Column(name = "P_ID")
	private String pId;

	// bi-directional many-to-one association to RequestorDO
	@ManyToOne
	@JoinColumn(name = "P_ID", insertable = false, updatable = false)
	private RequestorDO requestor;

	public ReqChDO()
	{
	}

	public String getAppName()
	{
		return this.appName;
	}

	public void setAppName(String appName)
	{
		this.appName = appName;
	}

	public String getDbName()
	{
		return this.dbName;
	}

	public void setDbName(String dbName)
	{
		this.dbName = dbName;
	}

	public Long getId()
	{
		return this.id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getNoOfTable()
	{
		return this.noOfTable;
	}

	public void setNoOfTable(String noOfTable)
	{
		this.noOfTable = noOfTable;
	}

	public RequestorDO getRequestor()
	{
		return this.requestor;
	}

	public void setRequestor(RequestorDO requestor)
	{
		this.requestor = requestor;
	}

	public String getPId()
	{
		return this.pId;
	}

	public void setPId(String pId)
	{
		this.pId = pId;
	}

}