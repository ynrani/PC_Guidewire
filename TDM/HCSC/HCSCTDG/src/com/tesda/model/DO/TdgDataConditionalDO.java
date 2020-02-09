/**
 * Object Name : TdgDataConditional.java
 * Modification Block
 * ---------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ---------------------------------------------------------------------
 * 	1.	  vkrish14		Jun 23, 2015			NA             Created
 * ---------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.tesda.model.DO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "TDG_DATA_CONDITIONAL_DETAILS")
@NamedQueries({
		@NamedQuery(name = "TdgDataConditionalDO.findAll", query = "SELECT t FROM TdgDataConditionalDO t"),
		@NamedQuery(name = "TdgDataConditionalDO.findByUrl", query = "SELECT t FROM TdgDataConditionalDO t WHERE t.url =:url"),
		@NamedQuery(name = "TdgDataConditionalDO.findById", query = "SELECT t FROM TdgDataConditionalDO t WHERE t.id =:id"),
		@NamedQuery(name = "TdgDataConditionalDO.findBytablename", query = "SELECT t FROM TdgDataConditionalDO t WHERE t.tablename =:tablename"),
		@NamedQuery(name = "TdgDataConditionalDO.findByUrlWithUserName", query = "SELECT t FROM TdgDataConditionalDO t WHERE t.url =:url AND t.username =:username") })
public class TdgDataConditionalDO extends BaseDO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private long id;
	private String url;
	private String username;
	private String password;
	private String tablename;
	private String userid;

	public long getId(){
		return id;
	}

	public void setId(long id){
		this.id = id;
	}

	public String getUrl(){
		return url;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUsername(){
		return username;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getTablename(){
		return tablename;
	}

	public void setTablename(String tablename){
		this.tablename = tablename;
	}

	public String getUserid(){
		return userid;
	}

	public void setUserid(String userid){
		this.userid = userid;
	}
}
