package dev.nichoko.aop.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService {

    @Override
    public String getFortune() throws InterruptedException{
        TimeUnit.SECONDS.sleep(2);
        return "Something";
    }
    
}
