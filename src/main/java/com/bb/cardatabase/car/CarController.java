package com.bb.cardatabase.car;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/api/car")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService){
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getCars(){
        return carService.getCars();
    }

    @GetMapping(path = "{color}")
    public Optional<Car> getCarByColor(@RequestParam(value = "color") String color){
        return carService.getByColor(color);
    }

    @GetMapping(path = "{year}")
    public Optional<Car> getCarByColor(@RequestParam(value = "year") Integer year){
        return carService.getByYear(year);
    }

    @PostMapping
    public void registerNewCar(@RequestBody Car car){
        carService.addNewCar(car);
    }

    @PutMapping(path = "{carId}")
    public void updateCar(
            @PathVariable("carId") Long carId,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) String registerNumber,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Integer price){
        carService.updateCar(carId, brand, model, color, registerNumber, year, price);
        }


    @DeleteMapping(path = "{carId}")
    public void deleteCar(@PathVariable("carId") Long carId){
        carService.deleteCar(carId);
    }


}

