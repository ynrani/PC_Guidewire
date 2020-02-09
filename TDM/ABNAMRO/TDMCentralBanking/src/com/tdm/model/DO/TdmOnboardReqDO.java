package com.tdm.model.DO;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the TDM_ONBOARD_REQ database table.
 * 
 */
@Entity
@Table(name = "TDM_ONBOARD_REQ")
@NamedQuery(name = "TdmOnboardReqDO.findAll", query = "SELECT t FROM TdmOnboardReqDO t")
public class TdmOnboardReqDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ONBOARD_REQ_ID")
	private String onboardReqId;

	@Column(name = "ACTION_BY")
	private String actionBy;

	@Column(name = "ACTION_DT")
	private Timestamp actionDt;

	@Column(name = "APP_NAME")
	private String appName;

	@Column(name = "APP_PHASE")
	private String appPhase;

	private String dept;

	@Column(name = "EMAIL_ID")
	private String emailId;

	@Column(name = "ENV_NAME")
	private String envName;

	@Column(name = "PHONE_NO")
	private String phoneNo;

	@Column(name = "U_NAME")
	private String uName;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "APP_DESC")
	private String appDesc;

	@Column(name = "CHNG_REQ_CMMT")
	private String chngReqCmmt;

	private String status;

	@Column(name = "VNO")
	private int vno;

	// bi-directional many-to-one association to TdmOnboadReqNoTabDO
	@OneToMany(mappedBy = "tdmOnboardReq", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<TdmOnboadReqNoTabDO> tdmOnboadReqNoTabs;

	public TdmOnboardReqDO()
	{
	}

	public String getOnboardReqId()
	{
		return this.onboardReqId;
	}

	public void setOnboardReqId(String onboardReqId)
	{
		this.onboardReqId = onboardReqId;
	}

	public String getActionBy()
	{
		return this.actionBy;
	}

	public void setActionBy(String actionBy)
	{
		this.actionBy = actionBy;
	}

	public Timestamp getActionDt()
	{
		return this.actionDt;
	}

	public void setActionDt(Timestamp actionDt)
	{
		this.actionDt = actionDt;
	}

	public String getAppName()
	{
		return this.appName;
	}

	public void setAppName(String appName)
	{
		this.appName = appName;
	}

	public String getAppPhase()
	{
		return this.appPhase;
	}

	public void setAppPhase(String appPhase)
	{
		this.appPhase = appPhase;
	}

	public String getDept()
	{
		return this.dept;
	}

	public void setDept(String dept)
	{
		this.dept = dept;
	}

	public String getEmailId()
	{
		return this.emailId;
	}

	public void setEmailId(String emailId)
	{
		this.emailId = emailId;
	}

	public String getEnvName()
	{
		return this.envName;
	}

	public void setEnvName(String envName)
	{
		this.envName = envName;
	}

	public String getPhoneNo()
	{
		return this.phoneNo;
	}

	public void setPhoneNo(String phoneNo)
	{
		this.phoneNo = phoneNo;
	}

	public String getUName()
	{
		return this.uName;
	}

	public void setUName(String uName)
	{
		this.uName = uName;
	}

	public String getUserName()
	{
		return this.userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public List<TdmOnboadReqNoTabDO> getTdmOnboadReqNoTabs()
	{
		return this.tdmOnboadReqNoTabs;
	}

	public void setTdmOnboadReqNoTabs(List<TdmOnboadReqNoTabDO> tdmOnboadReqNoTabs)
	{
		this.tdmOnboadReqNoTabs = tdmOnboadReqNoTabs;
	}

	public TdmOnboadReqNoTabDO addTdmOnboadReqNoTab(TdmOnboadReqNoTabDO tdmOnboadReqNoTab)
	{
		getTdmOnboadReqNoTabs().add(tdmOnboadReqNoTab);
		tdmOnboadReqNoTab.setTdmOnboardReq(this);

		return tdmOnboadReqNoTab;
	}

	public TdmOnboadReqNoTabDO removeTdmOnboadReqNoTab(TdmOnboadReqNoTabDO tdmOnboadReqNoTab)
	{
		getTdmOnboadReqNoTabs().remove(tdmOnboadReqNoTab);
		tdmOnboadReqNoTab.setTdmOnboardReq(null);

		return tdmOnboadReqNoTab;
	}

	public String getuName()
	{
		return uName;
	}

	public void setuName(String uName)
	{
		this.uName = uName;
	}

	public String getAppDesc()
	{
		return appDesc;
	}

	public void setAppDesc(String appDesc)
	{
		this.appDesc = appDesc;
	}

	public String getChngReqCmmt()
	{
		return chngReqCmmt;
	}

	public void setChngReqCmmt(String chngReqCmmt)
	{
		this.chngReqCmmt = chngReqCmmt;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public int getVno()
	{
		return vno;
	}

	public void setVno(int vno)
	{
		this.vno = vno;
	}

}