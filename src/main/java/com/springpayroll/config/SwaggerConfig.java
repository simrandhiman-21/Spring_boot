package com.springpayroll.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SwaggerConfig {
    @EventListener(ApplicationReadyEvent.class)
    public void openSwaggerUi() {
        log.info("Swagger UI available at: http://localhost:8080/swagger-ui/index.html");
    }
}
