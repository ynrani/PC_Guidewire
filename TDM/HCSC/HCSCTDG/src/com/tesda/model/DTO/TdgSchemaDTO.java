/*
 * Object Name : TdgSchemaDTO.java
 * Modification Block
 * ---------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ---------------------------------------------------------------------
 * 	1.	  vkrish14		Jun 15, 2015			NA             Created
 * ---------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.tesda.model.DTO;

import java.util.HashSet;
import java.util.Set;

public class TdgSchemaDTO extends AbstractBaseDTO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long reqschemaid;
	private String url;
	private String username;
	private String password;
	private String seqtableprefix;
	private String columnsdepends;
	private String schemamastertables;
	private String userid;
	private String schemaname;
	private String manualdictionary;
	private String schemapasstabs;
	private String dateformate;
	private String businessrules;
	private String requiredcolumns;
	private Set<TdgGuiDetailsDTO> tdgGuiDetailsDTOs = new HashSet<TdgGuiDetailsDTO>();

	public long getReqschemaid(){
		return reqschemaid;
	}

	public void setReqschemaid(long reqschemaid){
		this.reqschemaid = reqschemaid;
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

	public String getSeqtableprefix(){
		return seqtableprefix;
	}

	public void setSeqtableprefix(String seqtableprefix){
		this.seqtableprefix = seqtableprefix;
	}

	public String getSchemamastertables(){
		return schemamastertables;
	}

	public void setSchemamastertables(String schemamastertables){
		this.schemamastertables = schemamastertables;
	}

	public Set<TdgGuiDetailsDTO> getTdgGuiDetailsDTOs(){
		return tdgGuiDetailsDTOs;
	}

	public void setTdgGuiDetailsDTOs(Set<TdgGuiDetailsDTO> tdgGuiDetailsDTOs){
		this.tdgGuiDetailsDTOs = tdgGuiDetailsDTOs;
	}

	public String getUserid(){
		return userid;
	}

	public void setUserid(String userid){
		this.userid = userid;
	}

	public String getSchemaname(){
		return schemaname;
	}

	public void setSchemaname(String schemaname){
		this.schemaname = schemaname;
	}

	public String getColumnsdepends(){
		return columnsdepends;
	}

	public void setColumnsdepends(String columnsdepends){
		this.columnsdepends = columnsdepends;
	}

	public String getManualdictionary(){
		return manualdictionary;
	}

	public void setManualdictionary(String manualdictionary){
		this.manualdictionary = manualdictionary;
	}

	public String getSchemapasstabs(){
		return schemapasstabs;
	}

	public void setSchemapasstabs(String schemapasstabs){
		this.schemapasstabs = schemapasstabs;
	}

	public String getDateformate(){
		return dateformate;
	}

	public void setDateformate(String dateformate){
		this.dateformate = dateformate;
	}

	public String getBusinessrules(){
		return businessrules;
	}

	public void setBusinessrules(String businessrules){
		this.businessrules = businessrules;
	}

	public String getRequiredcolumns() {
		return requiredcolumns;
	}

	public void setRequiredcolumns(String requiredcolumns) {
		this.requiredcolumns = requiredcolumns;
	}
}
