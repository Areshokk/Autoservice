package com.areshok.Autoservice.repository;

import com.areshok.Autoservice.model.Car;
import com.areshok.Autoservice.model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    @Test
    @Order(1)
    public void saveCarTest() {

//        Car car = Car.builder()
//                .id(1)
//                .color("Black")
//                .year(2022)
//                .build();

        Car car = new Car(1,"Black",2022,new com.areshok.Autoservice.model.Order(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>());

        carRepository.save(car);

        Assertions.assertThat(car.getId()).isGreaterThan(0);

    }

    @Test
    @Order(2)
    @Rollback(value = false)
    public void getCarTest() {
        Car car = carRepository.findById(1).get();

        Assertions.assertThat(car.getId()).isEqualTo(1);

    }

    @Test
    @Order(3)
    public void getListOfCarsTest() {

        List<Car> cars = carRepository.findAll();

        Assertions.assertThat(cars.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateCarTest() {
        Car car = carRepository.findById(1).get();

        car.setColor("Black");

        Car carUpdated = carRepository.save(car);

        Assertions.assertThat(carUpdated.getColor()).isEqualTo("Black");
    }

    // TODO: 01.02.2022 update this method to delete user

//    @Test
//    @Order(5)
//    @Rollback(value = false)
//    public void deleteCarTest() {
//        Car car = carRepository.findById(1).get();
//
////        carRepository.deleteById(1);
//        carRepository.delete(car);
//
//        Car car1 = null;
//
//        Optional<Car> optionalCar = carRepository.findByColor("Black");
//
//        if (optionalCar.isPresent()) {
//            car1 = optionalCar.get();
//        }
//
//        Assertions.assertThat(car).isNull();
//
//        System.out.println("delete Car Test");
//    }

}