package com.tdm.model.DO;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TDM_PROVIDER_TYPE_MASTER database table.
 * 
 */
@Entity
@Table(name="TDM_PROVIDER_TYPE_MASTER")
@NamedQuery(name="TdmProviderTypeMasterDO.findAll", query="SELECT t FROM TdmProviderTypeMasterDO t")
public class TdmProviderTypeMasterDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PROVIDER_TYPE_ID")
	private String providerTypeId;

	@Column(name="PROVIDER_TYPE_NAME")
	private String providerTypeName;

	public TdmProviderTypeMasterDO() {
	}

	public String getProviderTypeId() {
		return this.providerTypeId;
	}

	public void setProviderTypeId(String providerTypeId) {
		this.providerTypeId = providerTypeId;
	}

	public String getProviderTypeName() {
		return this.providerTypeName;
	}

	public void setProviderTypeName(String providerTypeName) {
		this.providerTypeName = providerTypeName;
	}

}