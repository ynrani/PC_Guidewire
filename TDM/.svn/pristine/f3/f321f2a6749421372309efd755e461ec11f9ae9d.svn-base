package com.tdm.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmailUtils
{
	public static void main(String[] args) {
		String to = "seshadri.chowdary@capgemini.com";// change accordingly

		sendMail(null, to, "", "test ", "Hi ");

	}

	public static void sendMail(String from1, String to, String cc, String sub, String body) {

		String from = "seshadri.chowdary@capgemini.com";// change accordingly
		String host = "Smtp-relay.fs.capgemini.com";// or IP address

		// Get the session object
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.auth", "false");
		Session session = Session.getDefaultInstance(properties);

		// compose the message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(sub);
			message.setText(body);

			// Send message
			Transport.send(message);
			System.out.println("message sent successfully....");

		} catch (MessagingException mex) {
			mex.printStackTrace();
		}

	}
}
