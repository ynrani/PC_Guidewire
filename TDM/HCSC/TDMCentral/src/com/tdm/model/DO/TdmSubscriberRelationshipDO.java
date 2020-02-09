package com.tdm.model.DO;


import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the TDM_SUBSCRIBER_RELATIONSHIP database table.
 * 
 */
@Entity
@Table(name="TDM_SUBSCRIBER_RELATIONSHIP")
@NamedQuery(name="TdmSubscriberRelationshipDO.findAll", query="SELECT t FROM TdmSubscriberRelationshipDO t")
public class TdmSubscriberRelationshipDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="RELATIONSHIP_ID")
	private long relationshipId;

	@Column(name="CHANGED_BY")
	private BigDecimal changedBy;

	private BigDecimal creator;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_CHANGED")
	private Date dateChanged;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_CREATED")
	private Date dateCreated;

	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDate;

	@Column(name="RELATIONSHIP_TYPE")
	private String relationshipType;

	@Temporal(TemporalType.DATE)
	@Column(name="START_DATE")
	private Date startDate;

	//bi-directional many-to-one association to TdmSubscriberDO
	@ManyToOne
	@JoinColumn(name="SUBSCRIBER_ID", insertable = false, updatable = false)
	private TdmSubscriberDO tdmSubscriber;

	public TdmSubscriberRelationshipDO() {
	}

	public long getRelationshipId() {
		return this.relationshipId;
	}

	public void setRelationshipId(long relationshipId) {
		this.relationshipId = relationshipId;
	}

	public BigDecimal getChangedBy() {
		return this.changedBy;
	}

	public void setChangedBy(BigDecimal changedBy) {
		this.changedBy = changedBy;
	}

	public BigDecimal getCreator() {
		return this.creator;
	}

	public void setCreator(BigDecimal creator) {
		this.creator = creator;
	}

	public Date getDateChanged() {
		return this.dateChanged;
	}

	public void setDateChanged(Date dateChanged) {
		this.dateChanged = dateChanged;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getRelationshipType() {
		return this.relationshipType;
	}

	public void setRelationshipType(String relationshipType) {
		this.relationshipType = relationshipType;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public TdmSubscriberDO getTdmSubscriber() {
		return this.tdmSubscriber;
	}

	public void setTdmSubscriber(TdmSubscriberDO tdmSubscriber) {
		this.tdmSubscriber = tdmSubscriber;
	}

}