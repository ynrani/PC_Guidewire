package com.tesda.model.DO;

import java.io.Serializable;

import javax.persistence.Column;
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
 * The persistent class for the BALANCEENTRY database table.
 * 
 */
@Entity
@Table(name = "BALANCEENTRY")
@NamedQuery(name = "BalanceentryDO.findAll", query = "SELECT b FROM BalanceentryDO b")
public class BalanceentryDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String code;

	@Column(name = "\"TYPE\"")
	private String type;

	// bi-directional many-to-one association to BalanceinfoDO
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "WRITEOFF_ID")
	private BalanceinfoDO balanceinfo1;

	// bi-directional many-to-one association to BalanceinfoDO
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PASTDUE_ID")
	private BalanceinfoDO balanceinfo2;

	// bi-directional many-to-one association to BalanceinfoDO
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BALANCEDUE_ID")
	private BalanceinfoDO balanceinfo3;

	// bi-directional many-to-one association to BalanceinfoDO
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MINIMUMDUE_ID")
	private BalanceinfoDO balanceinfo4;

	// bi-directional many-to-one association to BalanceinfoDO
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PAID_ID")
	private BalanceinfoDO balanceinfo5;

	public BalanceentryDO()
	{
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BalanceinfoDO getBalanceinfo1() {
		return this.balanceinfo1;
	}

	public void setBalanceinfo1(BalanceinfoDO balanceinfo1) {
		this.balanceinfo1 = balanceinfo1;
	}

	public BalanceinfoDO getBalanceinfo2() {
		return this.balanceinfo2;
	}

	public void setBalanceinfo2(BalanceinfoDO balanceinfo2) {
		this.balanceinfo2 = balanceinfo2;
	}

	public BalanceinfoDO getBalanceinfo3() {
		return this.balanceinfo3;
	}

	public void setBalanceinfo3(BalanceinfoDO balanceinfo3) {
		this.balanceinfo3 = balanceinfo3;
	}

	public BalanceinfoDO getBalanceinfo4() {
		return this.balanceinfo4;
	}

	public void setBalanceinfo4(BalanceinfoDO balanceinfo4) {
		this.balanceinfo4 = balanceinfo4;
	}

	public BalanceinfoDO getBalanceinfo5() {
		return this.balanceinfo5;
	}

	public void setBalanceinfo5(BalanceinfoDO balanceinfo5) {
		this.balanceinfo5 = balanceinfo5;
	}

}