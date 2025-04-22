package com.learning.RESTapiCalls;


import org.springframework.stereotype.Service;

@Service
public class ServiceLayer {

    String sayhello(){
        return "Hello from Service Layer ";
    }

}
