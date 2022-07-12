package com.example.demo.cars;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsService {
    public List<Cars> getCars() {
        return List.of(
                new Cars(
                        1L,
                        "Audi",
                        "A8",
                        2022,
                        "Black"
                )
        );
    }
}
