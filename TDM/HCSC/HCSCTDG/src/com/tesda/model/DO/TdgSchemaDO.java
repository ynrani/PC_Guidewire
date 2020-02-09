/*
 * Object Name : TdgSchemaDO.java
 * Modification Block
 * ---------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ---------------------------------------------------------------------
 * 	1.	  vkrish14		Jun 15, 2015			NA             Created
 * ---------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.tesda.model.DO;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "TDG_SCHEMA_DETAILS")
@NamedQueries({
		@NamedQuery(name = "TdgSchemaDO.findAll", query = "SELECT t FROM TdgSchemaDO t"),
		@NamedQuery(name = "TdgSchemaDO.findByUrl", query = "SELECT t FROM TdgSchemaDO t WHERE t.url =:url"),
		@NamedQuery(name = "TdgSchemaDO.findBySchemaId", query = "SELECT t FROM TdgSchemaDO t WHERE t.reqschemaid =:reqschemaid"),
		@NamedQuery(name = "TdgSchemaDO.deleteBySchemaId", query = "DELETE FROM TdgSchemaDO t WHERE t.reqschemaid =:reqschemaid"),
		@NamedQuery(name = "TdgSchemaDO.findBySchemaName", query = "SELECT t FROM TdgSchemaDO t WHERE t.schemaname =:schemaname"),
		@NamedQuery(name = "TdgSchemaDO.findByUrlWithUserName", query = "SELECT t FROM TdgSchemaDO t WHERE t.url =:url AND t.username =:username") })
public class TdgSchemaDO extends BaseDO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private long reqschemaid;
	private String url;
	private String username;
	private String password;
	private String seqtableprefix;
	private String schemamastertables;
	private String userid;
	private String schemaname;
	private String columnsdepends;
	private String manualdictionary;
	private String schemapasstabs;
	private String dateformate;
	private String businessrules;
	private String requiredcolumns;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tdgSchemaDO")
	@Cascade({ CascadeType.ALL })
	private Set<TdgGuiDetailsDO> tdgGuiDetailsDOs = new HashSet<TdgGuiDetailsDO>();

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

	public Set<TdgGuiDetailsDO> getTdgGuiDetailsDOs(){
		return tdgGuiDetailsDOs;
	}

	public void setTdgGuiDetailsDOs(Set<TdgGuiDetailsDO> tdgGuiDetailsDOs){
		this.tdgGuiDetailsDOs = tdgGuiDetailsDOs;
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
