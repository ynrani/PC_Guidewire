/**
 * 
 */
package com.tesda.model.DTO;

/**
 * @author vkrish14
 *
 */
public class TdmUserDTO
{

	private String userId;
	private String emailId;
	private String mobileNo;
	private String password;
	private String username;
	private boolean created;
	private String enabled;
	private TdmUserAuthDTO tdmUserAuthDTO;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public TdmUserAuthDTO getTdmUserAuthDTO() {
		return tdmUserAuthDTO;
	}

	public void setTdmUserAuthDTO(TdmUserAuthDTO tdmUserAuthDTO) {
		this.tdmUserAuthDTO = tdmUserAuthDTO;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public boolean isCreated() {
		return created;
	}

	public void setCreated(boolean created) {
		this.created = created;
	}

}
