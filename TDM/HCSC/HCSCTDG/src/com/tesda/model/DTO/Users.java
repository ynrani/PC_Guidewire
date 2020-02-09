/*
 * Object Name : Users.java
 * Modification Block
 * ---------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ---------------------------------------------------------------------
 * 	1.	  vkrish14		Jun 15, 2015			NA             Created
 * ---------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.tesda.model.DTO;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.FactoryUtils;
import org.apache.commons.collections.list.LazyList;

public class Users{
	private String name;
	private String dob;
	private String email;
	private String phone;
	@SuppressWarnings("unchecked")
	private List<OperationParameters> operationParameterses = LazyList.decorate(
			new ArrayList<OperationParameters>(),
			FactoryUtils.instantiateFactory(OperationParameters.class));

	public Users(String name, String dob, String email, String phone, String address, Long pincode,
			String country) {
		super();
		this.name = name;
		this.dob = dob;
		this.email = email;
		this.phone = phone;
	}

	public Users() {
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getDob(){
		return dob;
	}

	public void setDob(String dob){
		this.dob = dob;
	}

	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getPhone(){
		return phone;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public List<OperationParameters> getOperationParameterses(){
		return operationParameterses;
	}

	public void setOperationParameterses(List<OperationParameters> operationParameterses){
		this.operationParameterses = operationParameterses;
	}
}