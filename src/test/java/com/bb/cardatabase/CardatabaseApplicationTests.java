package com.bb.cardatabase;

import com.bb.cardatabase.car.CarController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class CardatabaseApplicationTests {

	@Autowired
	private CarController controller;


	@Test
	void contextLoads() {
		assert controller != null;
	}



}
