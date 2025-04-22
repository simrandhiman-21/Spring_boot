package com.learning.RESTapiCalls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/greeting")

public class GrettingserviceController {

    private final ServiceLayer greetingservice;

    @Autowired
    GrettingserviceController(ServiceLayer greetingservice){
        this.greetingservice=greetingservice;
    }

    @GetMapping
    public String getgreeting(){
        return greetingservice.sayhello();
    }
}
