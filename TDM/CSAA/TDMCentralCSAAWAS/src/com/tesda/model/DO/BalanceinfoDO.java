package com.tesda.model.DO;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * The persistent class for the BALANCEINFO database table.
 * 
 */
@Entity
@Table(name = "BALANCEINFO")
@NamedQuery(name = "BalanceinfoDO.findAll", query = "SELECT b FROM BalanceinfoDO b")
public class BalanceinfoDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private BigDecimal balancedue;

	private BigDecimal minimumdue;

	// bi-directional many-to-one association to BalanceentryDO
	@OneToMany(mappedBy = "balanceinfo1", fetch = FetchType.LAZY)
	private List<BalanceentryDO> balanceentries1;

	// bi-directional many-to-one association to BalanceentryDO
	@OneToMany(mappedBy = "balanceinfo2", fetch = FetchType.LAZY)
	private List<BalanceentryDO> balanceentries2;

	// bi-directional many-to-one association to BalanceentryDO
	@OneToMany(mappedBy = "balanceinfo3", fetch = FetchType.LAZY)
	private List<BalanceentryDO> balanceentries3;

	// bi-directional many-to-one association to BalanceentryDO
	@OneToMany(mappedBy = "balanceinfo4", fetch = FetchType.LAZY)
	private List<BalanceentryDO> balanceentries4;

	// bi-directional many-to-one association to BalanceentryDO
	@OneToMany(mappedBy = "balanceinfo5", fetch = FetchType.LAZY)
	private List<BalanceentryDO> balanceentries5;

	// bi-directional many-to-one association to BillablepolicytermDO
	@OneToMany(mappedBy = "balanceinfo", fetch = FetchType.LAZY)
	private List<BillablepolicytermDO> billablepolicyterms;

	// bi-directional many-to-one association to BillingaccountDO
	@OneToMany(mappedBy = "balanceinfo", fetch = FetchType.LAZY)
	private List<BillingaccountDO> billingaccounts;

	// bi-directional many-to-one association to BillingtransactionDO
	@OneToMany(mappedBy = "balanceinfo", fetch = FetchType.LAZY)
	private List<BillingtransactionDO> billingtransactions;

	public BalanceinfoDO()
	{
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getBalancedue() {
		return this.balancedue;
	}

	public void setBalancedue(BigDecimal balancedue) {
		this.balancedue = balancedue;
	}

	public BigDecimal getMinimumdue() {
		return this.minimumdue;
	}

	public void setMinimumdue(BigDecimal minimumdue) {
		this.minimumdue = minimumdue;
	}

	public List<BalanceentryDO> getBalanceentries1() {
		return this.balanceentries1;
	}

	public void setBalanceentries1(List<BalanceentryDO> balanceentries1) {
		this.balanceentries1 = balanceentries1;
	}

	public BalanceentryDO addBalanceentries1(BalanceentryDO balanceentries1) {
		getBalanceentries1().add(balanceentries1);
		balanceentries1.setBalanceinfo1(this);

		return balanceentries1;
	}

	public BalanceentryDO removeBalanceentries1(BalanceentryDO balanceentries1) {
		getBalanceentries1().remove(balanceentries1);
		balanceentries1.setBalanceinfo1(null);

		return balanceentries1;
	}

	public List<BalanceentryDO> getBalanceentries2() {
		return this.balanceentries2;
	}

	public void setBalanceentries2(List<BalanceentryDO> balanceentries2) {
		this.balanceentries2 = balanceentries2;
	}

	public BalanceentryDO addBalanceentries2(BalanceentryDO balanceentries2) {
		getBalanceentries2().add(balanceentries2);
		balanceentries2.setBalanceinfo2(this);

		return balanceentries2;
	}

	public BalanceentryDO removeBalanceentries2(BalanceentryDO balanceentries2) {
		getBalanceentries2().remove(balanceentries2);
		balanceentries2.setBalanceinfo2(null);

		return balanceentries2;
	}

	public List<BalanceentryDO> getBalanceentries3() {
		return this.balanceentries3;
	}

	public void setBalanceentries3(List<BalanceentryDO> balanceentries3) {
		this.balanceentries3 = balanceentries3;
	}

	public BalanceentryDO addBalanceentries3(BalanceentryDO balanceentries3) {
		getBalanceentries3().add(balanceentries3);
		balanceentries3.setBalanceinfo3(this);

		return balanceentries3;
	}

	public BalanceentryDO removeBalanceentries3(BalanceentryDO balanceentries3) {
		getBalanceentries3().remove(balanceentries3);
		balanceentries3.setBalanceinfo3(null);

		return balanceentries3;
	}

	public List<BalanceentryDO> getBalanceentries4() {
		return this.balanceentries4;
	}

	public void setBalanceentries4(List<BalanceentryDO> balanceentries4) {
		this.balanceentries4 = balanceentries4;
	}

	public BalanceentryDO addBalanceentries4(BalanceentryDO balanceentries4) {
		getBalanceentries4().add(balanceentries4);
		balanceentries4.setBalanceinfo4(this);

		return balanceentries4;
	}

	public BalanceentryDO removeBalanceentries4(BalanceentryDO balanceentries4) {
		getBalanceentries4().remove(balanceentries4);
		balanceentries4.setBalanceinfo4(null);

		return balanceentries4;
	}

	public List<BalanceentryDO> getBalanceentries5() {
		return this.balanceentries5;
	}

	public void setBalanceentries5(List<BalanceentryDO> balanceentries5) {
		this.balanceentries5 = balanceentries5;
	}

	public BalanceentryDO addBalanceentries5(BalanceentryDO balanceentries5) {
		getBalanceentries5().add(balanceentries5);
		balanceentries5.setBalanceinfo5(this);

		return balanceentries5;
	}

	public BalanceentryDO removeBalanceentries5(BalanceentryDO balanceentries5) {
		getBalanceentries5().remove(balanceentries5);
		balanceentries5.setBalanceinfo5(null);

		return balanceentries5;
	}

	public List<BillablepolicytermDO> getBillablepolicyterms() {
		return this.billablepolicyterms;
	}

	public void setBillablepolicyterms(List<BillablepolicytermDO> billablepolicyterms) {
		this.billablepolicyterms = billablepolicyterms;
	}

	public BillablepolicytermDO addBillablepolicyterm(BillablepolicytermDO billablepolicyterm) {
		getBillablepolicyterms().add(billablepolicyterm);
		billablepolicyterm.setBalanceinfo(this);

		return billablepolicyterm;
	}

	public BillablepolicytermDO removeBillablepolicyterm(BillablepolicytermDO billablepolicyterm) {
		getBillablepolicyterms().remove(billablepolicyterm);
		billablepolicyterm.setBalanceinfo(null);

		return billablepolicyterm;
	}

	public List<BillingaccountDO> getBillingaccounts() {
		return this.billingaccounts;
	}

	public void setBillingaccounts(List<BillingaccountDO> billingaccounts) {
		this.billingaccounts = billingaccounts;
	}

	public BillingaccountDO addBillingaccount(BillingaccountDO billingaccount) {
		getBillingaccounts().add(billingaccount);
		billingaccount.setBalanceinfo(this);

		return billingaccount;
	}

	public BillingaccountDO removeBillingaccount(BillingaccountDO billingaccount) {
		getBillingaccounts().remove(billingaccount);
		billingaccount.setBalanceinfo(null);

		return billingaccount;
	}

	public List<BillingtransactionDO> getBillingtransactions() {
		return this.billingtransactions;
	}

	public void setBillingtransactions(List<BillingtransactionDO> billingtransactions) {
		this.billingtransactions = billingtransactions;
	}

	public BillingtransactionDO addBillingtransaction(BillingtransactionDO billingtransaction) {
		getBillingtransactions().add(billingtransaction);
		billingtransaction.setBalanceinfo(this);

		return billingtransaction;
	}

	public BillingtransactionDO removeBillingtransaction(BillingtransactionDO billingtransaction) {
		getBillingtransactions().remove(billingtransaction);
		billingtransaction.setBalanceinfo(null);

		return billingtransaction;
	}

}