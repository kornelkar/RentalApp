package com.example.demo.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CarsService {

    private final CarsRepository carsRepository;

    @Autowired
    public CarsService(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }


    public List<Cars> getCars() {
        return carsRepository.findAll();

    }

    public void addNewCars(Cars cars) {
        Optional<Cars> carsOptional = carsRepository.findCarsByMake(cars.getMake());

        if (carsOptional.isPresent()) {
            throw new IllegalStateException("We have a make that you are looking for!");
        }
        carsRepository.save(cars);
    }

    public void deleteCars(Long carsId) {
        boolean exists = carsRepository.existsById(carsId);
        if (!exists) {
            throw new IllegalStateException("Car with id " + carsId + " does not exists");
        }
        carsRepository.deleteById(carsId);
    }

    @Transactional
    public void updateCars(Long carsId, String make, String model) {
        Cars cars = carsRepository.findById(carsId).orElseThrow(() -> new IllegalStateException(
                "car with id " + carsId + " does not exists"
        ));

        if (make != null && make.length() > 0 && !Objects.equals(cars.getMake(), make)) {
            cars.setMake(make);
        }

        if (model != null && model.length() > 0 && !Objects.equals(cars.getModel(), model)) {
            cars.setModel(model);
        }

    }
}

