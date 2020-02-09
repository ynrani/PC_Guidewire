/*
 * Object Name : PageNationMainDTO.java
 * Modification Block
 * ---------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ---------------------------------------------------------------------
 * 	1.	  vkrish14		Jun 15, 2015			NA             Created
 * ---------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.tesda.model.DTO;

import java.util.List;

public class PageNationMainDTO{
	int iTotalRecords;
	int iTotalDisplayRecords;
	String sEcho;
	String sColumns;
	List<PageNationDTO> aaData;

	public int getiTotalRecords(){
		return iTotalRecords;
	}

	public void setiTotalRecords(int iTotalRecords){
		this.iTotalRecords = iTotalRecords;
	}

	public int getiTotalDisplayRecords(){
		return iTotalDisplayRecords;
	}

	public void setiTotalDisplayRecords(int iTotalDisplayRecords){
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}

	public String getsEcho(){
		return sEcho;
	}

	public void setsEcho(String sEcho){
		this.sEcho = sEcho;
	}

	public String getsColumns(){
		return sColumns;
	}

	public void setsColumns(String sColumns){
		this.sColumns = sColumns;
	}

	public List<PageNationDTO> getAaData(){
		return aaData;
	}

	public void setAaData(List<PageNationDTO> aaData){
		this.aaData = aaData;
	}
}
