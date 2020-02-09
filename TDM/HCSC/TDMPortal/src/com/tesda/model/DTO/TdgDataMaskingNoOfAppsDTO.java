/*---------------------------------------------------------------------------------------
* Object Name: TdgDataMaskingNoOfAppsDTO.Java
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

public class TdgDataMaskingNoOfAppsDTO
{

	private String appName;
	private String dbName;
	private String noOfTables;
	private String id;

	public String getAppName()
	{
		return appName;
	}

	public void setAppName(String appName)
	{
		this.appName = appName;
	}

	public String getDbName()
	{
		return dbName;
	}

	public void setDbName(String dbName)
	{
		this.dbName = dbName;
	}

	public String getNoOfTables()
	{
		return noOfTables;
	}

	public void setNoOfTables(String noOfTables)
	{
		this.noOfTables = noOfTables;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

}
