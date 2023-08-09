package dev.nichoko.firstproject.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyEndpoint {
    @Value("${custom.rest.custom-property}")
    private String myValue;

    @GetMapping("/test")
    public String testAPI(){
        return "Tested: " + myValue;
    } 
}
