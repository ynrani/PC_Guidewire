package com.tdm.model.DO;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the TDM_RESERVATION database table.
 * 
 */
@Entity
@Table(name = "TDM_RESERVATION")
@NamedQuery(name = "TdmReservationDO.findAll", query = "SELECT t FROM TdmReservationDO t")
public class TdmReservationDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "RESERVATION_1_ID_SEQ", sequenceName = "ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RESERVATION_1_ID_SEQ")
	@Column(name = "RECORD_ID")
	private long recordId;

	@Column(name = "USER_ID")
	private String userId;

	@Column(name = "RESERVE_DATA_ID")
	private String reserveDataId;

	private String locked;

	@Column(name = "RESERVE_DATA")
	private String reserveData;

	@Column(name = "RESERVE_DATA_TYPE")
	private String reserveDataType;

	@Column(name = "ROW_DATA")
	private String rowData;

	@Column(name = "UNLOCK_TIME")
	private Timestamp unlockTime;

	private String unreserve;

	@Column(name = "TEST_CASE_NAME")
	private String testCaseName;

	@Column(name = "TEST_CASE_ID")
	private String testCaseId;

	public TdmReservationDO()
	{
	}

	public String getLocked()
	{
		return this.locked;
	}

	public void setLocked(String locked)
	{
		this.locked = locked;
	}

	public String getReserveData()
	{
		return this.reserveData;
	}

	public void setReserveData(String reserveData)
	{
		this.reserveData = reserveData;
	}

	public String getReserveDataType()
	{
		return this.reserveDataType;
	}

	public void setReserveDataType(String reserveDataType)
	{
		this.reserveDataType = reserveDataType;
	}

	public String getRowData()
	{
		return this.rowData;
	}

	public void setRowData(String rowData)
	{
		this.rowData = rowData;
	}

	public Timestamp getUnlockTime()
	{
		return this.unlockTime;
	}

	public void setUnlockTime(Timestamp unlockTime)
	{
		this.unlockTime = unlockTime;
	}

	public String getUnreserve()
	{
		return this.unreserve;
	}

	public void setUnreserve(String unreserve)
	{
		this.unreserve = unreserve;
	}

	public long getRecordId()
	{
		return recordId;
	}

	public void setRecordId(long recordId)
	{
		this.recordId = recordId;
	}

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public String getReserveDataId()
	{
		return reserveDataId;
	}

	public void setReserveDataId(String reserveDataId)
	{
		this.reserveDataId = reserveDataId;
	}

	public String getTestCaseName()
	{
		return testCaseName;
	}

	public void setTestCaseName(String testCaseName)
	{
		this.testCaseName = testCaseName;
	}

	public String getTestCaseId()
	{
		return testCaseId;
	}

	public void setTestCaseId(String testCaseId)
	{
		this.testCaseId = testCaseId;
	}

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}

}