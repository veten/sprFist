package fi.golfist2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
 
 
//@Service("myEmailAPI")		//See HelloController method formSubmit for explanation
public class EmailAPI {
 
	@Autowired
	private MailSender mailSender; // MailSender interface defines a strategy
										// for sending simple mails
 
	public void readyToSendEmail(String toAddress, String fromAddress, String subject, String msgBody) {
 
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom(fromAddress);
		msg.setTo(toAddress);
		msg.setSubject(subject);
		msg.setText(msgBody);
		mailSender.send(msg);
	}
}