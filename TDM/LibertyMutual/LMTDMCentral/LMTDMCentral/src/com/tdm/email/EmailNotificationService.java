package com.tdm.email;

import com.tdm.exception.ServiceException;
import com.tdm.model.DTO.ForgotPassword;

public interface EmailNotificationService
{
	public void sendEmailNotification(ForgotPassword forgotPasswordDTO) throws ServiceException;
}
