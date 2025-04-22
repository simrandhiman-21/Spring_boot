package com.SpringIntro.Springintro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



//2ways make
// DemoLogger as main @SpringBootApplication
                        //main class name
//SpringApplication.run(SpringintroApplication.class, args);

public class DemoLogger {

    private  static final Logger logger= LoggerFactory.getLogger(DemoLogger.class);

    public static void main(String[] args) {

        logger.info("String Spring Boot Application ....");

        ApplicationContext context= SpringApplication.run(SpringintroApplication.class, args);
        SpringApplication.run(SpringintroApplication.class, args);
        EmployeeBean emp= context.getBean(EmployeeBean.class);
        emp.display();


        logger.info("EmployeeBean accessed and method executed.");

    }

}
