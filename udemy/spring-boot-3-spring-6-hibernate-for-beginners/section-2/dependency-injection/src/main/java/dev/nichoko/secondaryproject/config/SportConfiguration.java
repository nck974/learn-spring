package dev.nichoko.secondaryproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.nichoko.secondaryproject.model.Coach;
import dev.nichoko.secondaryproject.model.SwimmingCoach;

@Configuration
public class SportConfiguration {
    @Bean("swimCoach")
    public Coach swimmingCoach(){
        return new SwimmingCoach();
    }
}
