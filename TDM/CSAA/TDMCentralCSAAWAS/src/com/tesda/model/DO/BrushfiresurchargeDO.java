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
 * The persistent class for the BRUSHFIRESURCHARGE database table.
 * 
 */
@Entity
@Table(name = "BRUSHFIRESURCHARGE")
@NamedQuery(name = "BrushfiresurchargeDO.findAll", query = "SELECT b FROM BrushfiresurchargeDO b")
public class BrushfiresurchargeDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	// bi-directional many-to-one association to DwelldetailDO
	@OneToMany(mappedBy = "brushfiresurcharge", fetch = FetchType.LAZY)
	private List<DwelldetailDO> dwelldetails;

	public BrushfiresurchargeDO()
	{
	}

	public List<DwelldetailDO> getDwelldetails() {
		return this.dwelldetails;
	}

	public void setDwelldetails(List<DwelldetailDO> dwelldetails) {
		this.dwelldetails = dwelldetails;
	}

	public DwelldetailDO addDwelldetail(DwelldetailDO dwelldetail) {
		getDwelldetails().add(dwelldetail);
		dwelldetail.setBrushfiresurcharge(this);

		return dwelldetail;
	}

	public DwelldetailDO removeDwelldetail(DwelldetailDO dwelldetail) {
		getDwelldetails().remove(dwelldetail);
		dwelldetail.setBrushfiresurcharge(null);

		return dwelldetail;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}