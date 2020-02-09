/*
 * Object Name : TdgGuiDetailsDO.java
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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "TDG_GUI_DETAILS")
@NamedQueries({
		@NamedQuery(name = "TdgGuiDetailsDO.findAll", query = "SELECT t FROM TdgSchemaDO t"),
		@NamedQuery(name = "TdgGuiDetailsDO.findBySchemaId", query = "SELECT t FROM TdgSchemaDO t"),
		@NamedQuery(name = "TdgGuiDetailsDO.deleteBySchemaId", query = "DELETE FROM TdgGuiDetailsDO t WHERE t.tdgSchemaDO.reqschemaid =:reqschemaid") })
public class TdgGuiDetailsDO extends BaseDO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private long reqguiid;

	private String columnValues;

	private String columnLabel;

	private String columnType;

	private String columnname;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reqschemaid")
	private TdgSchemaDO tdgSchemaDO;

	public long getReqguiid() {
		return reqguiid;
	}

	public void setReqguiid(long reqguiid) {
		this.reqguiid = reqguiid;
	}

	public String getColumnValues() {
		return columnValues;
	}

	public void setColumnValues(String columnValues) {
		this.columnValues = columnValues;
	}

	public String getColumnLabel() {
		return columnLabel;
	}

	public void setColumnLabel(String columnLabel) {
		this.columnLabel = columnLabel;
	}

	public String getColumnType() {
		return columnType;
	}

	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	public String getColumnname() {
		return columnname;
	}

	public void setColumnname(String columnname) {
		this.columnname = columnname;
	}

	public TdgSchemaDO getTdgSchemaDO() {
		return tdgSchemaDO;
	}

	public void setTdgSchemaDO(TdgSchemaDO tdgSchemaDO) {
		this.tdgSchemaDO = tdgSchemaDO;
	}

}
