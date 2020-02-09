/*---------------------------------------------------------------------------------------
* Object Name: TdmUsersAuthDOPK.Java
* 
 * Modification Block:
* --------------------------------------------------------------------------------------
* S.No. Name                Date      Bug Fix no. 		Desc
* --------------------------------------------------------------------------------------
* 1     Seshadri Chowdary   11/04/15  NA          		Created* 
* --------------------------------------------------------------------------------------
*
* Copyright: 2015 <CapGemini>
*---------------------------------------------------------------------------------------*/

package com.tesda.model.DO;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the TDM_USERS_AUTH database table.
 * 
 */
@Embeddable
public class TdmUsersAuthDOPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="USER_ROLE_ID")
	private String userRoleId;

	@Column(name="USER_ID", insertable=false, updatable=false)
	private String userId;

	public TdmUsersAuthDOPK() {
	}
	public String getUserRoleId() {
		return this.userRoleId;
	}
	public void setUserRoleId(String userRoleId) {
		this.userRoleId = userRoleId;
	}
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TdmUsersAuthDOPK)) {
			return false;
		}
		TdmUsersAuthDOPK castOther = (TdmUsersAuthDOPK)other;
		return 
			this.userRoleId.equals(castOther.userRoleId)
			&& this.userId.equals(castOther.userId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.userRoleId.hashCode();
		hash = hash * prime + this.userId.hashCode();
		
		return hash;
	}
}