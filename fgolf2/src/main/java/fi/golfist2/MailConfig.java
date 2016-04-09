package fi.golfist2;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
	
	@Bean
	public JavaMailSenderImpl mailSender() {
		JavaMailSenderImpl jmsi = new JavaMailSenderImpl();
		Properties jmp = new Properties();
		jmp.setProperty("mail.smtp.auth", "true");
		jmp.setProperty("mail.transport.protocol", "smtp");
		jmp.setProperty("mail.smtp.starttls.enable", "true");
		jmp.setProperty("mail.smtp.starttls.required", "true");
		
		jmsi.setHost("smtp.gmail.com");
		jmsi.setUsername("");
		jmsi.setPassword("");
		jmsi.setPort(587);
		jmsi.setJavaMailProperties(jmp);
		
		
		return jmsi;		
	}
	
	
}
