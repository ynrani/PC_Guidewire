package com.tdm.model.DO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * The persistent class for the TDM_CLAIMS database table.
 * 
 */
@Entity
@Table(name = "TDM_CLAIMS")
@NamedQuery(name = "TdmClaimDO.findAll", query = "SELECT t FROM TdmClaimDO t")
public class TdmClaimDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CLAIM_ID")
	private String claimId;

	@Temporal(TemporalType.DATE)
	@Column(name = "ADMISSION_DATE")
	private Date admissionDate;

	@Column(name = "AUTH_CLAIM")
	private String authClaim;

	@Column(name = "CLAIM_SOURCE")
	private String claimSource;

	@Column(name = "CLAIM_STATUS")
	private String claimStatus;

	@Column(name = "CLAIM_TYPE")
	private String claimType;

	@Column(name = "CO_INS")
	private String coIns;

	@Column(name = "COB_CLAIM")
	private String cobClaim;

	private String copay;

	private String deductible;

	@Temporal(TemporalType.DATE)
	@Column(name = "DISCHARGE_DATE")
	private Date dischargeDate;

	private String gender;

	@Column(name = "GROUP_ID")
	private String groupId;

	@Column(name = "INT_CLAIM")
	private String intClaim;

	@Column(name = "PATIENT_FNAME")
	private String patientFname;

	@Column(name = "PATIENT_LNAME")
	private String patientLname;

	@Column(name = "POLICY_ID")
	private String policyId;

	private String pos;

	@Temporal(TemporalType.DATE)
	@Column(name = "RECEIPT_DATE")
	private Date receiptDate;

	@Column(name = "REF_CLAIM")
	private String refClaim;

	@Column(name = "SUB_ID")
	private String subId;

	@Column(name = "TOTAL_ALLOWED")
	private String totalAllowed;

	@Column(name = "TOTAL_BILL_CHARGED")
	private String totalBillCharged;

	@Column(name = "TOTAL_BILL_PAID")
	private String totalBillPaid;

	@Column(name = "TYPE_OF_BILL")
	private String typeOfBill;

	// bi-directional many-to-one association to TdmClaimLineDetailDO
	@OneToMany(mappedBy = "tdmClaim")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<TdmClaimLineDetailDO> tdmClaimLineDetails;

	public TdmClaimDO()
	{
	}

	public String getClaimId()
	{
		return this.claimId;
	}

	public void setClaimId(String claimId)
	{
		this.claimId = claimId;
	}

	public Date getAdmissionDate()
	{
		return this.admissionDate;
	}

	public void setAdmissionDate(Date admissionDate)
	{
		this.admissionDate = admissionDate;
	}

	public String getAuthClaim()
	{
		return this.authClaim;
	}

	public void setAuthClaim(String authClaim)
	{
		this.authClaim = authClaim;
	}

	public String getClaimSource()
	{
		return this.claimSource;
	}

	public void setClaimSource(String claimSource)
	{
		this.claimSource = claimSource;
	}

	public String getClaimStatus()
	{
		return this.claimStatus;
	}

	public void setClaimStatus(String claimStatus)
	{
		this.claimStatus = claimStatus;
	}

	public String getClaimType()
	{
		return this.claimType;
	}

	public void setClaimType(String claimType)
	{
		this.claimType = claimType;
	}

	public String getCoIns()
	{
		return this.coIns;
	}

	public void setCoIns(String coIns)
	{
		this.coIns = coIns;
	}

	public String getCobClaim()
	{
		return this.cobClaim;
	}

	public void setCobClaim(String cobClaim)
	{
		this.cobClaim = cobClaim;
	}

	public String getCopay()
	{
		return this.copay;
	}

	public void setCopay(String copay)
	{
		this.copay = copay;
	}

	public String getDeductible()
	{
		return this.deductible;
	}

	public void setDeductible(String deductible)
	{
		this.deductible = deductible;
	}

	public Date getDischargeDate()
	{
		return this.dischargeDate;
	}

	public void setDischargeDate(Date dischargeDate)
	{
		this.dischargeDate = dischargeDate;
	}

	public String getGender()
	{
		return this.gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public String getGroupId()
	{
		return this.groupId;
	}

	public void setGroupId(String groupId)
	{
		this.groupId = groupId;
	}

	public String getIntClaim()
	{
		return this.intClaim;
	}

	public void setIntClaim(String intClaim)
	{
		this.intClaim = intClaim;
	}

	public String getPatientFname()
	{
		return this.patientFname;
	}

	public void setPatientFname(String patientFname)
	{
		this.patientFname = patientFname;
	}

	public String getPatientLname()
	{
		return this.patientLname;
	}

	public void setPatientLname(String patientLname)
	{
		this.patientLname = patientLname;
	}

	public String getPolicyId()
	{
		return this.policyId;
	}

	public void setPolicyId(String policyId)
	{
		this.policyId = policyId;
	}

	public String getPos()
	{
		return this.pos;
	}

	public void setPos(String pos)
	{
		this.pos = pos;
	}

	public Date getReceiptDate()
	{
		return this.receiptDate;
	}

	public void setReceiptDate(Date receiptDate)
	{
		this.receiptDate = receiptDate;
	}

	public String getRefClaim()
	{
		return this.refClaim;
	}

	public void setRefClaim(String refClaim)
	{
		this.refClaim = refClaim;
	}

	public String getSubId()
	{
		return this.subId;
	}

	public void setSubId(String subId)
	{
		this.subId = subId;
	}

	public String getTotalAllowed()
	{
		return this.totalAllowed;
	}

	public void setTotalAllowed(String totalAllowed)
	{
		this.totalAllowed = totalAllowed;
	}

	public String getTotalBillCharged()
	{
		return this.totalBillCharged;
	}

	public void setTotalBillCharged(String totalBillCharged)
	{
		this.totalBillCharged = totalBillCharged;
	}

	public String getTotalBillPaid()
	{
		return this.totalBillPaid;
	}

	public void setTotalBillPaid(String totalBillPaid)
	{
		this.totalBillPaid = totalBillPaid;
	}

	public String getTypeOfBill()
	{
		return this.typeOfBill;
	}

	public void setTypeOfBill(String typeOfBill)
	{
		this.typeOfBill = typeOfBill;
	}

	public List<TdmClaimLineDetailDO> getTdmClaimLineDetails()
	{
		return this.tdmClaimLineDetails;
	}

	public void setTdmClaimLineDetails(List<TdmClaimLineDetailDO> tdmClaimLineDetails)
	{
		this.tdmClaimLineDetails = tdmClaimLineDetails;
	}

	public TdmClaimLineDetailDO addTdmClaimLineDetail(TdmClaimLineDetailDO tdmClaimLineDetail)
	{
		getTdmClaimLineDetails().add(tdmClaimLineDetail);
		tdmClaimLineDetail.setTdmClaim(this);

		return tdmClaimLineDetail;
	}

	public TdmClaimLineDetailDO removeTdmClaimLineDetail(TdmClaimLineDetailDO tdmClaimLineDetail)
	{
		getTdmClaimLineDetails().remove(tdmClaimLineDetail);
		tdmClaimLineDetail.setTdmClaim(null);

		return tdmClaimLineDetail;
	}

}