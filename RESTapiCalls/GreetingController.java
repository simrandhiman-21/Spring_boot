package com.learning.RESTapiCalls;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apicall")

public class GreetingController {
    @GetMapping
    public String getsayhello(){
        return "Hello From GET";
    }

    //postman post body text (not json) simran
    @PostMapping
    public String psothello(@RequestBody String name){
        return "Hello "+ name+" from POST";
    }

    //put http://localhost:8080/httpmethods/java  body text new_simran
    @PutMapping("/{name}")
    public String puthello(@PathVariable String name, @RequestBody String newname){
        return "Hello "+ newname+" from PUT";
    }


    @DeleteMapping("/{name}")
    public String deletehello(@PathVariable String name) {
        return "GoodBye " + name + " from DELETE";
    }

}
