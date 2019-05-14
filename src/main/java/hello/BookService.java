/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author VenkPi
 */
@Service
public class BookService {

    RestTemplate restTemplate;

    public BookService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

    }

    @HystrixCommand(fallbackMethod = "teachMe")
    public String getMe(int index) {
        String URL = "https://sitarampv.blogspot.com";
        switch (index) {
            case 1:
                URL = "https://sitarampv.blogspot.com";
                break;
            case 2:
                URL = "https://ramaffiliate.blogspot.com";
                break;
            case 3:
                URL = "https://springframe.blogspot.com";
                break;
            case 4:
                URL = "https://vedicastrology-prognosis.blogspot.com";
                break;
            case 5:
                URL = "https://blogtracer.blogspot.com";
                break;
            case 6:
                URL = "https://bitcoinwikis.blogspot.com";
                break;

        }
        try {
            return restTemplate.exchange(new RequestEntity<>(HttpMethod.GET, new URI(URL)), String.class).getBody();
        } catch (URISyntaxException ex) {
            Logger.getLogger(BookService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "DIDn't work";
    }

    public String teachMe(int i) {
        try {
            return restTemplate.exchange(new RequestEntity<>(HttpMethod.GET, new URI("https://blogtracer.blogspot.com")), String.class).getBody();
        } catch (URISyntaxException ex) {
            Logger.getLogger(BookService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "TeachMe";
    }

}
