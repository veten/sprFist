package fi.golfist2;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "This is where it starts! Check: '/underdog' ";
    }

    @RequestMapping("/underdog")
    public String underdog() {
        return "Put some stuff here!";
    }

    
}
