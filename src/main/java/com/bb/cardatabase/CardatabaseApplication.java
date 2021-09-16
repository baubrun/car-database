package com.bb.cardatabase;

import com.bb.cardatabase.car.Car;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class CardatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
	}



}
