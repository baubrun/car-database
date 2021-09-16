package com.bb.cardatabase.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    public List<Car> getCars(){
        return carRepository.findAll();
    }

    public Optional<Car> getByColor(String color){
        return carRepository.findByColor(color);
    }

    public Optional<Car> getByYear(Integer year){
        return carRepository.findByYear(year);
    }

    public void addNewCar(Car car) {
        Optional<Car> carByBrand = carRepository.findByBrand(car.getBrand());
        if (carByBrand.isPresent()){
            throw new IllegalStateException("Car already exists.");
        }
        carRepository.save(car);
    }

    public void deleteCar(Long carId){
        boolean car = carRepository.existsById(carId);
        if (!car){
            throw new IllegalStateException("Car with id " + carId + " does not exist.");
        }
        carRepository.deleteById(carId);
    }

    @Transactional
    public void updateCar(Long carId,
                          String brand,
                          String model,
                          String color,
                          String registerNumber,
                          Integer year,
                          Integer price
    ){
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new IllegalStateException(
                        "Car with id " + carId + " does not exist."
                ));
        if (brand != null &&
                brand.length() > 0 &&
                !Objects.equals(car.getBrand(), brand)){
            car.setBrand(brand);
        }
        if (model != null &&
                model.length() > 0 &&
                !Objects.equals(car.getModel(), model)){
            car.setModel(model);
        }
        if (color != null &&
                color.length() > 0 &&
                !Objects.equals(car.getColor(), color)){
            car.setColor(color);
        }
        if (registerNumber != null &&
                registerNumber.length() > 0 &&
                !Objects.equals(car.getRegisterNumber(), registerNumber)){
            car.setRegisterNumber(registerNumber);
        }
        if (year != null &&
                year != car.getYear()){
            car.setYear(year);
        }
        if (price != null &&
                price != car.getPrice()){
            car.setPrice(price);
            }
    }

}
