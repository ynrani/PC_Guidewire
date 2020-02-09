package com.tdm.model.DO;


import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TDM_US_STATES database table.
 * 
 */
@Entity
@Table(name="TDM_US_STATES")
@NamedQuery(name="TdmUsStateDO.findAll", query="SELECT t FROM TdmUsStateDO t")
public class TdmUsStateDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="REF_NAME")
	private String refName;

	@Column(name="STATE_NAME")
	private String stateName;

	public TdmUsStateDO() {
	}

	public String getRefName() {
		return this.refName;
	}

	public void setRefName(String refName) {
		this.refName = refName;
	}

	public String getStateName() {
		return this.stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

}