/*
 * Object Name : TdgDynamicPageContentDTO.java
 * Modification Block
 * ---------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ---------------------------------------------------------------------
 * 	1.	  vkrish14		Jun 15, 2015			NA             Created
 * ---------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.tesda.model.DTO;

import java.util.ArrayList;
import java.util.List;

public class TdgDynamicPageContentDTO extends AbstractBaseDTO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String url;
	private String password;
	private String name;
	private long schemaId;
	private String schemaname;
	private String columnsdepends;
	private String schemamastertables;
	private String seqtableprefix;
	private String dbType;
	private long Requestcount;
	private String manualdictionary;
	private String schemapasstabs;
	private String dateformate;
	private String businessrules;
	private String requiredcolumns;
	private List<TdgDynamicGuiDTO> listDynamicPojo = new ArrayList<TdgDynamicGuiDTO>();
	private String dependevalues;

	public String getUrl(){
		return url;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public long getRequestcount(){
		return Requestcount;
	}

	public void setRequestcount(long requestcount){
		Requestcount = requestcount;
	}

	public List<TdgDynamicGuiDTO> getListDynamicPojo(){
		return listDynamicPojo;
	}

	public void setListDynamicPojo(List<TdgDynamicGuiDTO> listDynamicPojo){
		this.listDynamicPojo = listDynamicPojo;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public long getSchemaId(){
		return schemaId;
	}

	public void setSchemaId(long schemaId){
		this.schemaId = schemaId;
	}

	public String getSchemaname(){
		return schemaname;
	}

	public void setSchemaname(String schemaname){
		this.schemaname = schemaname;
	}

	public String getDependevalues(){
		return dependevalues;
	}

	public void setDependevalues(String dependevalues){
		this.dependevalues = dependevalues;
	}

	public String getSchemamastertables(){
		return schemamastertables;
	}

	public void setSchemamastertables(String schemamastertables){
		this.schemamastertables = schemamastertables;
	}

	public String getSeqtableprefix(){
		return seqtableprefix;
	}

	public void setSeqtableprefix(String seqtableprefix){
		this.seqtableprefix = seqtableprefix;
	}

	public String getDbType(){
		return dbType;
	}

	public void setDbType(String dbType){
		this.dbType = dbType;
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
