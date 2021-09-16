package com.bb.cardatabase.car;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CarConfig {

    @Bean
    CommandLineRunner commandLineRunner(CarRepository repository){
        return args -> {
            Car toyota = new Car(
                    "Toyota",
                    "4Runner",
                    "Black",
                    "ASDF-1234",
                    2019,
                    45000
            );

            Car lexus = new Car(
                    "Lexus",
                    "Spider",
                    "Red",
                    "ASDF-9999",
                    2021,
                    60000
            );

            repository.saveAll(List.of(toyota, lexus));

        };
    }
}
