/*
 * Object Name : EmailNotificationServiceImpl.java
 * Modification Block
 * ---------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ---------------------------------------------------------------------
 * 	1.	  vkrish14		Jun 15, 2015			NA             Created
 * ---------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.tesda.email;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.tesda.model.DTO.ForgotPassword;

public class EmailNotificationServiceImpl implements EmailNotificationService{

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
	public void sendEmailNotification(final ForgotPassword forgotPasswordDTO) {
		MimeMessagePreparator preparator = new MimeMessagePreparator(){
			@Override
			@SuppressWarnings({ "rawtypes", "unchecked" })
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(forgotPasswordDTO.getEmailId());
				message.setFrom("abc@abc.com");
				message.setSubject("Password Sent Your new password"
						+ forgotPasswordDTO.getPassword());
				message.setSentDate(new Date());
				Map model = new HashMap();
				model.put("newMessage", forgotPasswordDTO);
				String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
						"properties/forgotPassword.vm", "UTF-8", model);
				message.setText(text, true);
			}
		};
		mailSender.send(preparator);
	}

}