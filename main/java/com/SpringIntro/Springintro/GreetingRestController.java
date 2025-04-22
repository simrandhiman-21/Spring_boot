package com.SpringIntro.Springintro;

import com.SpringIntro.Springintro.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingRestController {

    @GetMapping
    public String rootHello() {
        return "Welcome to the Greeting API!";
    }

    @RequestMapping("/java")
    public String sayhello(){
        return "Hello From BridgeLabs";
    }
//    @RequestMapping(value = {"/query"},method= RequestMethod.GET)
//    public String sayhello(@RequestParam(value = "name") String name){
//        return "Hello "+name;
//    }

    @GetMapping("/param/{name}")
    public String sayhello(@PathVariable String name){
        return "Hello "+name;
    }

   // Use tools like Postman or cURL for POST and PUT methods
    @PostMapping("/post")
    public String sayhello(@RequestBody User user){
        return "Hello "+user.getFirstName()+ user.getLastName();
    }
    @PutMapping("/put/{firstName}")
    public String sayhello(@PathVariable String firstName,@RequestParam(value = "lastName")String lastName){
        return "Hello "+firstName+lastName;
    }




}
