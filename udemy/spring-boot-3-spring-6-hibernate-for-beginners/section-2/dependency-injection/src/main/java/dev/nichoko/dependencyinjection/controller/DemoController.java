package dev.nichoko.dependencyinjection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.nichoko.secondaryproject.model.Coach;

@RestController
public class DemoController {

    private Coach coach;
    private Coach setterCoach;

    @Autowired
    public DemoController(@Qualifier("swimCoach") Coach newCoach) {
        coach = newCoach;
    }

    @Autowired
    private void setSetterCoach(Coach newCoach) {
        setterCoach = newCoach;
    }

    @GetMapping("/instructions")
    public String showInstructions() {
        return coach.getInstructions();
    }

    @GetMapping("/instructions-setter")
    public String showInstructionsSetter() {
        return setterCoach.getInstructions();
    }

    @GetMapping("/compare")
    public String compareCoach() {
        return "Comparing: " + (coach == setterCoach);
    }

}
