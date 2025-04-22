package com.learning.RESTapiCalls;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class GreetingMessageController {

    @GetMapping("/param")
    public  String sayhello(@RequestParam(required = false) String firstname, @RequestParam(required = false) String secondname) {

        //http://localhost:9090/message/param?firstname=simran&secondname=dhiman
        String fullname="";
        if(firstname!=null)fullname+=firstname;
        if(secondname!=null) fullname+=secondname;

        return "Heelllooo "+fullname ;
    }

}
