package com.ibaggarwal.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    // expose "/" that returns "Hello Word"
    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }

    // expose new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run a hard 5k!";
    }

    //expose a new endpoint for "fortune"
    @GetMapping("fortune")
    public String getFortune(){
        return "Today is your lucky day!";
    }
}
