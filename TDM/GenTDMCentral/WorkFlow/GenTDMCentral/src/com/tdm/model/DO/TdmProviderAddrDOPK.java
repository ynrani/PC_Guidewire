package com.tdm.model.DO;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the TDM_PROVIDER_ADDR database table.
 * 
 */
@Embeddable
public class TdmProviderAddrDOPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="PROVIDER_ADDR_ID")
	private long providerAddrId;

	@Column(name="PROVIDER_ID", insertable=false, updatable=false)
	private long providerId;

	public TdmProviderAddrDOPK() {
	}
	public long getProviderAddrId() {
		return this.providerAddrId;
	}
	public void setProviderAddrId(long providerAddrId) {
		this.providerAddrId = providerAddrId;
	}
	public long getProviderId() {
		return this.providerId;
	}
	public void setProviderId(long providerId) {
		this.providerId = providerId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TdmProviderAddrDOPK)) {
			return false;
		}
		TdmProviderAddrDOPK castOther = (TdmProviderAddrDOPK)other;
		return 
			(this.providerAddrId == castOther.providerAddrId)
			&& (this.providerId == castOther.providerId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.providerAddrId ^ (this.providerAddrId >>> 32)));
		hash = hash * prime + ((int) (this.providerId ^ (this.providerId >>> 32)));
		
		return hash;
	}
}