package com.areshok.Autoservice.repository;

import com.areshok.Autoservice.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {
}
