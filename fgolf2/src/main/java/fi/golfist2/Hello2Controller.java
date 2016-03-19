package fi.golfist2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello2Controller 
{
	@RequestMapping("/sepi")
	public String sepi()
	{
		return "sepi";
	}
}