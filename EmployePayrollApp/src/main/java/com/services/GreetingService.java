package com.springmessageapp.services;


import org.springframework.stereotype.Service;
import com.springmessageapp.entities.Greeting;
import com.springmessageapp.repositories.IGreetingRepository;

import java.util.List;

@Service
public class GreetingService {
    private final IGreetingRepository greetingRepository;

    public GreetingService(IGreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }


    public Greeting getSimpleGreeting(){
        return Greeting.builder().message("Hello World!").build();
    }



    public Greeting getGreeting(long id) {
        return greetingRepository.findById(id).get();
    }

    public List<Greeting> getGreeting() {
        return greetingRepository.findAll();
    }


    public Greeting addGreeting(String firstName, String lastName) {
        Greeting greeting = Greeting.builder().message(("Hello " + firstName + " " + lastName).trim()).build();
        greetingRepository.save(greeting);
        return greeting;
    }

    public boolean deleteGreeting(long id) {
        if (!greetingRepository.existsById(id)) {
            return false;
        }
        greetingRepository.deleteById(id);
        greetingRepository.flush();
        return !greetingRepository.existsById(id);
    }

    public Greeting updateGreeting(long id, String firstName, String lastName) {
        if (!greetingRepository.existsById(id)) {
            return null;
        }
        Greeting greeting = Greeting.builder().message(("Hello " + firstName + " " + lastName).trim()).build();
        greeting.setId(id);
        greetingRepository.save(greeting);
        return greeting;
    }
}

