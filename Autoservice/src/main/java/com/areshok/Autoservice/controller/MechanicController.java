package com.areshok.Autoservice.controller;

import com.areshok.Autoservice.model.Car;
import com.areshok.Autoservice.model.Mechanic;
import com.areshok.Autoservice.model.Work;
import com.areshok.Autoservice.repository.CarRepository;
import com.areshok.Autoservice.repository.MechanicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MechanicController {

    @Autowired
    private MechanicRepository mechanicRepository;

    @Autowired
    private CarRepository carRepository;


    @GetMapping("/mechanics")
    public String listMechanics(Model model) {
        List<Mechanic> listMechanics = mechanicRepository.findAll();
        model.addAttribute("listMechanics",listMechanics);

        return "mechanics";
    }

    @GetMapping("/mechanics/new")
    public String showCreateNewMechanicForm(Model model) {
        List<Car> listCars = carRepository.findAll();
        model.addAttribute("mechanic", new Mechanic());
        model.addAttribute("listCars", listCars);

        return "mechanic_form";
    }

    @PostMapping("/mechanics/save")
    public String saveMechanics(Mechanic mechanic) {
        mechanicRepository.save(mechanic);

        return "redirect:/mechanics";
    }

    @GetMapping("/mechanics/delete/{id}")
    public String deleteMechanic(@PathVariable("id") Integer id, Model model){
        mechanicRepository.deleteById(id);

        return "redirect:/mechanics";
    }
}
