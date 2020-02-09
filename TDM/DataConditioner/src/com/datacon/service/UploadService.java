package com.datacon.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.datacon.exception.ServiceException;
import com.datacon.model.DTO.UploadDTO;

public interface UploadService
{

	public List<Object[]> convertFileToData(CommonsMultipartFile multipartFile)
			throws ServiceException;

	public String insertDataToDB(CommonsMultipartFile multipartFile, String tabName,
			UploadDTO uploadDTO, List<Object[]> selectedColumns) throws ServiceException;

	public Map<String, String> getAvilableDBs(String userId) throws ServiceException;

	public Map<String, List<String>> getAllTableDetails(String dataConConnIds)
			throws ServiceException;

	public String createTab(CommonsMultipartFile multipartFile1, List<Object[]> selectedColumns)
			throws ServiceException;

}
