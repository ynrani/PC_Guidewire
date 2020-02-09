/*---------------------------------------------------------------------------------------
* Object Name: TdmOnboadReqNoTabDO.Java
* 
 * Modification Block:
* --------------------------------------------------------------------------------------
* S.No. Name                Date      Bug Fix no. 		Desc
* --------------------------------------------------------------------------------------
* 1     Seshadri Chowdary   11/04/15  NA          		Created* 
* --------------------------------------------------------------------------------------
*
* Copyright: 2015 <CapGemini>
*---------------------------------------------------------------------------------------*/

package com.tesda.model.DO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the TDM_ONBOAD_REQ_NO_TABS database table.
 * 
 */
@Entity
@Table(name = "TDM_ONBOAD_REQ_NO_TABS")
@NamedQuery(name = "TdmOnboadReqNoTabDO.findAll", query = "SELECT t FROM TdmOnboadReqNoTabDO t")
public class TdmOnboadReqNoTabDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(name = "APP_NAME")
	private String appName;

	@Column(name = "DB_NAME")
	private String dbName;

	@Column(name = "NO_OF_TABLE")
	private String noOfTable;

	@Column(name = "ONBOARD_REQ_ID")
	private String onboardReqId;

	// bi-directional many-to-one association to TdmOnboardReqDO
	@ManyToOne
	@JoinColumn(name = "ONBOARD_REQ_ID", insertable = false, updatable = false)
	private TdmOnboardReqDO tdmOnboardReq;

	public TdmOnboadReqNoTabDO()
	{
	}

	public long getId()
	{
		return this.id;
	}

	public void setId(long id)
	{
		this.id = id;
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

	public String getNoOfTable()
	{
		return this.noOfTable;
	}

	public void setNoOfTable(String noOfTable)
	{
		this.noOfTable = noOfTable;
	}

	public TdmOnboardReqDO getTdmOnboardReq()
	{
		return this.tdmOnboardReq;
	}

	public void setTdmOnboardReq(TdmOnboardReqDO tdmOnboardReq)
	{
		this.tdmOnboardReq = tdmOnboardReq;
	}

	public String getOnboardReqId()
	{
		return onboardReqId;
	}

	public void setOnboardReqId(String onboardReqId)
	{
		this.onboardReqId = onboardReqId;
	}

}