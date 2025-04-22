package com.SpringIntro.Springintro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoggerController {

    private static final Logger logger= LoggerFactory.getLogger(LoggerController.class);

    @GetMapping("/hi")
    public String sayhello(){
        logger.info("sayHello() called");
        logger.debug("Debug log from /hi");
        logger.warn("Warn log from /hi");
        logger.error("Error log from /hi");
        return "Hello from BridgeLabz";
    }
}
//use case
//@GetMapping("/login")
//public String login(@RequestParam String username, @RequestParam String password) {
//    logger.info("Login attempt for user: {}", username);
//
//    if (username == null || username.isEmpty()) {
//        logger.warn("Login failed: Username is empty");
//        return "Username cannot be empty";
//    }
//
//    if ("admin".equals(username) && "admin123".equals(password)) {
//        logger.debug("Login success for user: {}", username);
//        return "Login Successful!";
//    } else {
//        logger.error("Login failed for user: {}", username);
//        return "Invalid credentials";
//    }
//}
//2025-04-22 10:32:00 INFO  Login attempt for user: admin
//2025-04-22 10:32:00 DEBUG Login success for user: admin
//---
//2025-04-22 10:33:15 INFO  Login attempt for user: root
//2025-04-22 10:33:15 ERROR Login failed for user: root