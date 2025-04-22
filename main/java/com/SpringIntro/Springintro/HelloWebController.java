package com.SpringIntro.Springintro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//src/main/resources/templates/hello.html
//Use @Controller (not @RestController) when returning views.

@Controller
public class HelloWebController {

        @GetMapping("/greet")
        public String sayhello(){
            return "hello";//hello.html
        }
}
