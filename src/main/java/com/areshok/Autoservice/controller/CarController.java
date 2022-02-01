package com.areshok.Autoservice.controller;

import com.areshok.Autoservice.model.Car;
import com.areshok.Autoservice.model.Order;
import com.areshok.Autoservice.repository.CarRepository;
import com.areshok.Autoservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private OrderRepository orderRepository;


    @GetMapping("/cars")
    public String listCars(Model model) {
        List<Car> listCars = carRepository.findAll();
        model.addAttribute("listCars", listCars);

        return "cars";
    }

    @GetMapping("/cars/new")
    public String showCreateNewCarForm(Model model) {
        List<Order> listOrders = orderRepository.findAll();
        model.addAttribute("car", new Car());
        model.addAttribute("listOrders", listOrders);

        return "car_form";
    }

    @PostMapping("/cars/save")
    public String saveCars(Car car) {
        carRepository.save(car);

        return "redirect:/cars";
    }

    @GetMapping("/cars/delete/{id}")
    public String deleteCar(@PathVariable("id") Integer id, Model model) {
        carRepository.deleteById(id);

        return "redirect:/cars";
    }
}
