package fi.golfist2;

import java.net.URL;
import java.net.URLClassLoader;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.*;

@Controller
public class Hello2Controller 
{
	@RequestMapping("/sepi2")
	public String sepi(Model model) throws IOException
	{
//		return "sepi";
		printClasspath();
		System.out.println(new java.io.File( "." ).getCanonicalPath());
		return "sepi";
	}
	
	private static void printClasspath () {

        ClassLoader cl = ClassLoader.getSystemClassLoader();

        URL[] urls = ((URLClassLoader)cl).getURLs();

        for(URL url: urls){
        	System.out.println(url.getFile());
        }
         
   }
}