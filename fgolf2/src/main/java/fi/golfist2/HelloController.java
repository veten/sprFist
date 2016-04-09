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
    
    
    @RequestMapping(value="/register", method=RequestMethod.POST)
    public String formSubmit(@ModelAttribute NewUser user, Model model) {
    	UserControllerUtil.registerSubmit();
        System.out.println(user.getName());
        System.out.println(user.getEmail());
        model.addAttribute("user", user);
        return "result";
    }

    
}


