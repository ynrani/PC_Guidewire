/*
 * Object Name : TdgRequestListDO.java
 * Modification Block
 * ---------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ---------------------------------------------------------------------
 * 	1.	  vkrish14		Jun 15, 2015			NA             Created
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
@Table(name = "TDG_REQUEST_LIST")
@NamedQueries({
		@NamedQuery(name = "TdgRequestListDO.findAll", query = "SELECT r FROM TdgRequestListDO r"),
		@NamedQuery(name = "TdgRequestListDO.findById", query = "SELECT t FROM TdgRequestListDO t WHERE t.requestid =:requestid") })
public class TdgRequestListDO extends BaseDO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private long requestid;
	private long requestCount;
	private String userid;
	private long reqschemaid;
	private String conditions;
	private String schemaname;
	private String status;
	private String statusdescription;
	private String generationType;
	private String flatFilesPath;
	private String requiredcolumns;

	public long getRequestid(){
		return requestid;
	}

	public void setRequestid(long requestid){
		this.requestid = requestid;
	}

	public long getRequestCount(){
		return requestCount;
	}

	public void setRequestCount(long requestCount){
		this.requestCount = requestCount;
	}

	public String getUserid(){
		return userid;
	}

	public void setUserid(String userid){
		this.userid = userid;
	}

	public long getReqschemaid(){
		return reqschemaid;
	}

	public void setReqschemaid(long reqschemaid){
		this.reqschemaid = reqschemaid;
	}

	public String getConditions(){
		return conditions;
	}

	public void setConditions(String conditions){
		this.conditions = conditions;
	}

	public String getSchemaname(){
		return schemaname;
	}

	public void setSchemaname(String schemaname){
		this.schemaname = schemaname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusdescription() {
		return statusdescription;
	}

	public void setStatusdescription(String statusdescription) {
		this.statusdescription = statusdescription;
	}

	public String getGenerationType() {
		return generationType;
	}

	public void setGenerationType(String generationType) {
		this.generationType = generationType;
	}

	public String getFlatFilesPath() {
		return flatFilesPath;
	}

	public void setFlatFilesPath(String flatFilesPath) {
		this.flatFilesPath = flatFilesPath;
	}

	public String getRequiredcolumns() {
		return requiredcolumns;
	}

	public void setRequiredcolumns(String requiredcolumns) {
		this.requiredcolumns = requiredcolumns;
	}
}
