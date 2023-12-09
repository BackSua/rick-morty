package com.rickandmortyapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RickMortyDoubleApplication {

    public static void main(String[] args) {
        SpringApplication.run(RickMortyDoubleApplication.class, args);
    }

}
