package dev.nichoko.secondaryproject.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach{

    public FootballCoach(){
        System.out.println("Initializing " + getClass().getSimpleName());
    }

    @Override
    @Primary
    public String getInstructions() {
        return "Shoot 5 goals";
    }
}
