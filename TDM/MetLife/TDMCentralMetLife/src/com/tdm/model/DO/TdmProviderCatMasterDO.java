package com.tdm.model.DO;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TDM_PROVIDER_CAT_MASTER database table.
 * 
 */
@Entity
@Table(name="TDM_PROVIDER_CAT_MASTER")
@NamedQuery(name="TdmProviderCatMasterDO.findAll", query="SELECT t FROM TdmProviderCatMasterDO t")
public class TdmProviderCatMasterDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PROVIDER_CATEGORY_ID")
	private long providerCategoryId;

	@Column(name="PROVIDER_CATEGORY_NAME")
	private String providerCategoryName;

	//bi-directional many-to-one association to TdmProviderSpecMasterDO
	@OneToMany(mappedBy="tdmProviderCatMaster")
	private List<TdmProviderSpecMasterDO> tdmProviderSpecMasters;

	public TdmProviderCatMasterDO() {
	}

	public long getProviderCategoryId() {
		return this.providerCategoryId;
	}

	public void setProviderCategoryId(long providerCategoryId) {
		this.providerCategoryId = providerCategoryId;
	}

	public String getProviderCategoryName() {
		return this.providerCategoryName;
	}

	public void setProviderCategoryName(String providerCategoryName) {
		this.providerCategoryName = providerCategoryName;
	}

	public List<TdmProviderSpecMasterDO> getTdmProviderSpecMasters() {
		return this.tdmProviderSpecMasters;
	}

	public void setTdmProviderSpecMasters(List<TdmProviderSpecMasterDO> tdmProviderSpecMasters) {
		this.tdmProviderSpecMasters = tdmProviderSpecMasters;
	}

	public TdmProviderSpecMasterDO addTdmProviderSpecMaster(TdmProviderSpecMasterDO tdmProviderSpecMaster) {
		getTdmProviderSpecMasters().add(tdmProviderSpecMaster);
		tdmProviderSpecMaster.setTdmProviderCatMaster(this);

		return tdmProviderSpecMaster;
	}

	public TdmProviderSpecMasterDO removeTdmProviderSpecMaster(TdmProviderSpecMasterDO tdmProviderSpecMaster) {
		getTdmProviderSpecMasters().remove(tdmProviderSpecMaster);
		tdmProviderSpecMaster.setTdmProviderCatMaster(null);

		return tdmProviderSpecMaster;
	}

}