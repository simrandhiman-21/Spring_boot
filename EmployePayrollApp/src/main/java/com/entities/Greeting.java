package com.springmessageapp.entities;

    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.Id;

    import lombok.*;

    @Getter
    @Setter
    @Entity
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor

    public class Greeting {
        @Id
        @GeneratedValue
        private long id;
        private String message;
    }



