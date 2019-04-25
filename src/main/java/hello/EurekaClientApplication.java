package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String write(@RequestBody String data) {
         System.out.println(data);
        return "Hello from Eureka Client";
    }
}
