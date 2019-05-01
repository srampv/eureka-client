package hello;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//@EnableDiscoveryClient
@SpringBootApplication
@EnableEurekaClient
public class EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }
}

@RestController
class ServiceInstanceRestController {

//    @Autowired
//    private DiscoveryClient discoveryClient;
    @RequestMapping(value = "/seo/write", method = RequestMethod.GET)
    public String greeting() {
        return "Hello from Eureka Client";
    }

    @RequestMapping(value = "/seo/write", method = RequestMethod.POST)
    public String write(@RequestBody String data,@RequestParam String name) throws IOException {
        System.out.println(data);
        try (FileOutputStream fos = new FileOutputStream(new File("C:\\cygwin64\\home\\venkpi\\"+name+"\\data-" + System.currentTimeMillis() + ".html"))) {
            PrintStream ps = new PrintStream(fos);
            ps.println(data);
            ps.close();
        }
        return "<----POSTED--->"+data;
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String email(HttpServletRequest request,HttpServletResponse response,Model model) throws IOException {
        model.addAttribute("greeting", request.getLocalAddr());
        System.out.println("IP:--->"+request.getLocalAddr());
        Runtime.getRuntime().exec("C:\\Users\\VenkPi\\Documents\\send-email.exe sitaram.venkata.blogtracer7716@blogger.com "+System.currentTimeMillis()+"∫visited-Your-Site"+request.getLocalAddr()+" Visited false");
        return "greeting-view";
    }
}
