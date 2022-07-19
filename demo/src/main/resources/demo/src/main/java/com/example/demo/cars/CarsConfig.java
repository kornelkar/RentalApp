package com.example.demo.cars;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CarsConfig {

    @Bean
    CommandLineRunner commandLineRunner(CarsRepository repository) {
        return args -> {

            Cars audi = new Cars(
                    "Audi",
                    "A8",
                    2022,
                    "black"
            );

            Cars volvo = new Cars(
                    "Volvo",
                    "XC90",
                    2020,
                    "silver"
            );


            repository.saveAll(
                    List.of(audi, volvo)
            );
        };
    }
}
