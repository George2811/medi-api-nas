package com.example.mediapinas;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MediApiNasApplication {

    public static void main(String[] args) {
        SpringApplication.run(MediApiNasApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {return new ModelMapper();}
}
