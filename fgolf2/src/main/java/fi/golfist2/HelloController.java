package fi.golfist2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Controller
public class HelloController {

	@RequestMapping("/")
    public String index() {
        return "index";
    }

	@RequestMapping("/login")
    public String login() {
        return "login";
    }
	
	@RequestMapping("/secret")
    public String secret() {
        return "secretStuff";
    }
	
    @RequestMapping(value="/register", method=RequestMethod.GET)
    public String registerForm(Model model) {
        model.addAttribute("user", new NewUser());
        return "register";
    }
    
    @SuppressWarnings("resource")
    @RequestMapping(value="/register", method=RequestMethod.POST)
    public String formSubmit(@ModelAttribute NewUser user, Model model) {
    	ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(EmailAPI.class, MailConfig.class);
// 		EmailAPI emailAPI = (EmailAPI) context.getBean("myEmailAPI");	//This works if named @Service definition done in EmailAPI.java
    	EmailAPI emailAPI = (EmailAPI) context.getBean(EmailAPI.class);
 		String toAddr = "";
 		String fromAddr = "";      
 		// email subject
 		String subject = "TestMail";      
 		// email body
 		String body = "This is it!!!";
 		
 		emailAPI.readyToSendEmail(toAddr, fromAddr, subject, body);
        System.out.println(user.getName());
        System.out.println(user.getEmail());
        model.addAttribute("user", user);
        return "result";
    }

    
}


