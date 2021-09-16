package com.bb.cardatabase.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository
        extends JpaRepository<Car, Long> {

    Optional<Car> findByBrand(String brand);
    Optional<Car> findByColor(@Param("color") String color);
    Optional<Car> findByYear(@Param("year") Integer year);

}
