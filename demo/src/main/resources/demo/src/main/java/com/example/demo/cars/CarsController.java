package com.example.demo.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/cars")

public class CarsController {


    private final CarsService carsService;

    @Autowired
    public CarsController(CarsService carsService) {
        this.carsService = carsService;
    }

    @GetMapping
    public List<Cars> getCars() {
        return carsService.getCars();
    }


    @PostMapping
    public void registerNewCars(@RequestBody Cars cars) {
        carsService.addNewCars(cars);
    }


    @DeleteMapping(path = "{carsId}")
    public void deleteCars(
            @PathVariable("carsId") Long carsId) {
        carsService.deleteCars(carsId);
    }

    @PutMapping(path = "{carsId}")
    public void updateCars(
      @PathVariable("carsId") Long carsId,
      @RequestParam(required = false) String make,
      @RequestParam(required = false) String model) {
        carsService.updateCars(carsId, make, model);
    }


}
