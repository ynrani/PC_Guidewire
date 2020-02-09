/*
 * Object Name : AbstractBaseDTO.java
 * Modification Block
 * ---------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ---------------------------------------------------------------------
 * 	1.	  vkrish14		Jun 15, 2015			NA             Created
 * ---------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.tesda.model.DTO;

import java.io.Serializable;
import java.util.List;

/**
 * @author vkrish14
 *
 */
abstract class AbstractBaseDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<String> errors;

	private String message;

	private String messageConstant;

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessageConstant() {
		return messageConstant;
	}

	public void setMessageConstant(String messageConstant) {
		this.messageConstant = messageConstant;
	}

}
