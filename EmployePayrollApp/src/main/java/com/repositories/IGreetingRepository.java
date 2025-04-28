package com.springmessageapp.repositories;


import com.springmessageapp.entities.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGreetingRepository extends JpaRepository<Greeting, Long> {
}
