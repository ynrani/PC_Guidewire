package com.tesda.model.DO;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the AAAUNDERWRITINGQUESTIONS database table.
 * 
 */
@Entity
@Table(name = "AAAUNDERWRITINGQUESTIONS")
@NamedQuery(name = "AaaunderwritingquestionDO.findAll", query = "SELECT a FROM AaaunderwritingquestionDO a")
public class AaaunderwritingquestionDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String dtype;

	private BigDecimal entitystatus;

	private String oid;

	private String questioncd;

	// bi-directional many-to-one association to PolicysummaryDO
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POLICY_ID")
	private PolicysummaryDO policysummary;

	public AaaunderwritingquestionDO()
	{
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDtype() {
		return dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	public BigDecimal getEntitystatus() {
		return entitystatus;
	}

	public void setEntitystatus(BigDecimal entitystatus) {
		this.entitystatus = entitystatus;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getQuestioncd() {
		return questioncd;
	}

	public void setQuestioncd(String questioncd) {
		this.questioncd = questioncd;
	}

	public PolicysummaryDO getPolicysummary() {
		return policysummary;
	}

	public void setPolicysummary(PolicysummaryDO policysummary) {
		this.policysummary = policysummary;
	}

}