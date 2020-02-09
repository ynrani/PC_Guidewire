package com.tesda.model.DO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the AAADWELLSCORE database table.
 * 
 */
@Entity
@Table(name = "AAADWELLSCORE")
@NamedQuery(name = "AaadwellscoreDO.findAll", query = "SELECT a FROM AaadwellscoreDO a")
public class AaadwellscoreDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String policynumber;

	private String postalcode;

	private String status;

	private String yearbuilt;

	// bi-directional many-to-one association to AddressentityDO
	@OneToMany(mappedBy = "aaadwellscore")
	private List<AddressentityDO> addressentities;

	public AaadwellscoreDO()
	{
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPolicynumber() {
		return policynumber;
	}

	public void setPolicynumber(String policynumber) {
		this.policynumber = policynumber;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getYearbuilt() {
		return yearbuilt;
	}

	public void setYearbuilt(String yearbuilt) {
		this.yearbuilt = yearbuilt;
	}

	public List<AddressentityDO> getAddressentities() {
		return addressentities;
	}

	public void setAddressentities(List<AddressentityDO> addressentities) {
		this.addressentities = addressentities;
	}

}