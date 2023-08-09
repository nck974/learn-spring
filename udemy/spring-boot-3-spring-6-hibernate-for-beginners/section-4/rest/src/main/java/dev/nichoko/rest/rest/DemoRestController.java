package dev.nichoko.rest.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("path")
public class DemoRestController {
    
    @GetMapping("test")
    String testEndpoint(){
        return "API is working!";
    }
    
}
