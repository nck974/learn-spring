package dev.nichoko.secondaryproject.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Primary
@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) // Same as default
public class BaseballCoach implements Coach {
    public BaseballCoach(){
        System.out.println("Initializing " + getClass().getSimpleName());
    }

    @Override
    public String getInstructions() {
        return "Throw the ball 5 times";
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("Called after construction");
    }
    @PreDestroy
    public void preDestroy(){
        System.out.println("Called before destruction");
    }
}

