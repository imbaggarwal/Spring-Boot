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
}
