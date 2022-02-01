package com.areshok.Autoservice.repository;

import com.areshok.Autoservice.model.Car;
import com.areshok.Autoservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {
    Optional<Car> findByColor(String color);
}
