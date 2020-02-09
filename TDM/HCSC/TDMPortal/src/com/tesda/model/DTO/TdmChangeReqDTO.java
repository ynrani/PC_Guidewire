/*---------------------------------------------------------------------------------------
* Object Name: TdmChangeReqDTO.Java
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

package com.tesda.model.DTO;

public class TdmChangeReqDTO
{

	private String reqId;
	private String userName;
	private String userId;
	private String emailId;
	private String phoneNo;
	private String deptName;
	private String appName;
	private String appDesc;
	private String envType;
	private String appPhase;
	private String noOfTabs;
	private String pageDtChMgmt1;
	private String pageDtChMgmt2;
	private String comments;
	private String showHideFlag;

	public String getReqId()
	{
		return reqId;
	}

	public void setReqId(String reqId)
	{
		this.reqId = reqId;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public String getEmailId()
	{
		return emailId;
	}

	public void setEmailId(String emailId)
	{
		this.emailId = emailId;
	}

	public String getPhoneNo()
	{
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo)
	{
		this.phoneNo = phoneNo;
	}

	public String getDeptName()
	{
		return deptName;
	}

	public void setDeptName(String deptName)
	{
		this.deptName = deptName;
	}

	public String getAppName()
	{
		return appName;
	}

	public void setAppName(String appName)
	{
		this.appName = appName;
	}

	public String getAppDesc()
	{
		return appDesc;
	}

	public void setAppDesc(String appDesc)
	{
		this.appDesc = appDesc;
	}

	public String getEnvType()
	{
		return envType;
	}

	public void setEnvType(String envType)
	{
		this.envType = envType;
	}

	public String getAppPhase()
	{
		return appPhase;
	}

	public void setAppPhase(String appPhase)
	{
		this.appPhase = appPhase;
	}

	public String getNoOfTabs()
	{
		return noOfTabs;
	}

	public void setNoOfTabs(String noOfTabs)
	{
		this.noOfTabs = noOfTabs;
	}

	public String getPageDtChMgmt1()
	{
		return pageDtChMgmt1;
	}

	public void setPageDtChMgmt1(String pageDtChMgmt1)
	{
		this.pageDtChMgmt1 = pageDtChMgmt1;
	}

	public String getPageDtChMgmt2()
	{
		return pageDtChMgmt2;
	}

	public void setPageDtChMgmt2(String pageDtChMgmt2)
	{
		this.pageDtChMgmt2 = pageDtChMgmt2;
	}

	public String getComments()
	{
		return comments;
	}

	public void setComments(String comments)
	{
		this.comments = comments;
	}

	public String getShowHideFlag()
	{
		return showHideFlag;
	}

	public void setShowHideFlag(String showHideFlag)
	{
		this.showHideFlag = showHideFlag;
	}

}
