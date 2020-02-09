package com.tesda.model.DO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the HOLDINFO database table.
 * 
 */
@Entity
@Table(name = "HOLDINFO")
@NamedQuery(name = "HoldinfoDO.findAll", query = "SELECT h FROM HoldinfoDO h")
public class HoldinfoDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	// bi-directional many-to-one association to BillingaccountDO
	@OneToMany(mappedBy = "holdinfo", fetch = FetchType.LAZY)
	private List<BillingaccountDO> billingaccounts;

	public HoldinfoDO()
	{
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<BillingaccountDO> getBillingaccounts() {
		return this.billingaccounts;
	}

	public void setBillingaccounts(List<BillingaccountDO> billingaccounts) {
		this.billingaccounts = billingaccounts;
	}

	public BillingaccountDO addBillingaccount(BillingaccountDO billingaccount) {
		getBillingaccounts().add(billingaccount);
		billingaccount.setHoldinfo(this);

		return billingaccount;
	}

	public BillingaccountDO removeBillingaccount(BillingaccountDO billingaccount) {
		getBillingaccounts().remove(billingaccount);
		billingaccount.setHoldinfo(null);

		return billingaccount;
	}

}