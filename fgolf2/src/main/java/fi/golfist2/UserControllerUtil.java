package fi.golfist2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class UserControllerUtil {

//	@Autowired
//	private static EmailAPI emailAPI; // = (EmailAPI) context.getBean("golfistEmail");
	
//	@Autowired
//	private static ApplicationContext context; 
	
    @SuppressWarnings("resource")
	public static void registerSubmit() {
        
     // Spring Bean file you specified in /src/main/resources folder
//     		String crunchifyConfFile = "crunchify-bean.xml";
//     		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(crunchifyConfFile);
     		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(MailConfig.class);
      
     		// @Service("GolfistEmail") <-- same annotation you specified in CrunchifyEmailAPI.java
//     		EmailAPI emailAPI = (EmailAPI) context.getBean("golfistEmail");
//     		EmailAPI emailAPI = (EmailAPI) context.getBean("");
     		EmailAPI emailAPI = (EmailAPI) context.getBean(EmailAPI.class);
     		

     		String toAddr = "";
     		String fromAddr = "";
      
     		// email subject
     		String subject = "TestMail";
      
     		// email body
     		String body = "This is it!!!";
     		emailAPI.readyToSendEmail(toAddr, fromAddr, subject, body);
        

	}
	
}
