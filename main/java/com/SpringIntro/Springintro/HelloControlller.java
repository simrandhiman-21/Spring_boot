package com.SpringIntro.Springintro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControlller {

    @GetMapping("/hello")
    public String sayhello(){
        return "Hello From BridgeLabs";
    }
}
