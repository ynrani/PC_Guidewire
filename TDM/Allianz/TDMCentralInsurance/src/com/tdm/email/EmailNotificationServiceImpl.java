package com.tdm.email;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.tdm.constant.AppConstant;
import com.tdm.constant.MessageConstant;
import com.tdm.controller.EmailController;
import com.tdm.exception.ServiceException;
import com.tdm.model.DTO.ForgotPassword;

public class EmailNotificationServiceImpl implements EmailNotificationService
{
	private static Logger logger = Logger.getLogger(EmailController.class);

	@Autowired
	private JavaMailSender mailSender;

	public JavaMailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public VelocityEngine getVelocityEngine() {
		return velocityEngine;
	}

	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

	private VelocityEngine velocityEngine;

	@Override
	public void sendEmailNotification(final ForgotPassword forgotPasswordDTO)
			throws ServiceException {
		logger.info(MessageConstant.TDM_EMAIL_SERVICE + MessageConstant.TDM_EMAIL_SEND
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			MimeMessagePreparator preparator = new MimeMessagePreparator()
			{
				@Override
				@SuppressWarnings({ AppConstant.RAW_TYPES, AppConstant.UNCHECKED })
				public void prepare(MimeMessage mimeMessage) throws Exception {
					MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
					message.setTo(forgotPasswordDTO.getEmailId());
					message.setFrom(AppConstant.FROM);
					message.setSubject(AppConstant.SUBJECT_FORGOTPASS
							+ forgotPasswordDTO.getPassword());
					message.setSentDate(new Date());
					Map model = new HashMap();
					model.put(AppConstant.NEW_MSG, forgotPasswordDTO);
					String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
							AppConstant.PROP_FORGOTPASS_VM, AppConstant.UTF_8, model);
					message.setText(text, true);
				}
			};
			logger.info(MessageConstant.TDM_EMAIL_SERVICE + MessageConstant.TDM_EMAIL_SEND
					+ MessageConstant.LOG_INFO_RETURN);
			mailSender.send(preparator);
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_EMAIL_SERVICE + MessageConstant.TDM_EMAIL_SEND
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_EMAIL_SERVICE + MessageConstant.TDM_EMAIL_SEND
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

}