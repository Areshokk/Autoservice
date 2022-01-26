package com.areshok.Autoservice.service;

import com.areshok.Autoservice.model.Car;
import com.areshok.Autoservice.repository.CarRepository;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> listAll(){
        return carRepository.findAll();
    }

    public void save(Car car) {
        carRepository.save(car);
    }

    public Car findById(Integer id){
        return carRepository.getOne(id);
    }

    public void deleteById(Integer id) {
        carRepository.deleteById(id);
    }
}
