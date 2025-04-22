package com.learning.RESTapiCalls;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;

@RestController
@RequestMapping("/reposave")
public class GreetingrRepository {

    HashMap<Integer,Greeting> map=new HashMap<>();

    @PostMapping
    public String saveGreeting(@RequestBody Greeting greet){
        map.put(greet.getId(),greet);
        return " Done !";
    }

    @GetMapping
    public Collection<Greeting> getALlGreeting(){
        return map.values();
    }

    @GetMapping("/param/{id}")
    public String getmessage(@PathVariable int id){
        Greeting greet=map.get(id);
        return greet!=null ? greet.getMessage():"Greeting not Found !";
    }

    @PutMapping("/param/{id}")
    public String editbyid(@PathVariable int id,@RequestBody Greeting newGreeting){
        if(map.containsKey(id)){
            map.put(id,newGreeting);
            return "Greeting Updated";
        }
        return "Greeting not found!";
    }

    @DeleteMapping("/param/{id}")
    public String deletebyid(@PathVariable int id){
        Greeting removedGreeting = map.remove(id); // Remove the greeting by ID
        return removedGreeting != null ? "Greeting deleted!" : "Greeting not found!";
    }

}
