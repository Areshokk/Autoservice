package com.areshok.Autoservice.controller;

import com.areshok.Autoservice.model.Car;
import com.areshok.Autoservice.model.Order;
import com.areshok.Autoservice.model.Work;
import com.areshok.Autoservice.repository.CarRepository;
import com.areshok.Autoservice.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class WorkController {

    @Autowired
    private WorkRepository workRepository;

    @Autowired
    private CarRepository carRepository;

    @GetMapping("/works")
    public String listWorks(Model model) {
        List<Work> listWorks = workRepository.findAll();
        model.addAttribute("listWorks",listWorks);

        return "works";
    }

    @GetMapping("/works/new")
    public String showCreateNewWorkForm(Model model) {
        List<Car> listCars = carRepository.findAll();
        model.addAttribute("work", new Work());
        model.addAttribute("listCars", listCars);

        return "work_form";
    }

    @PostMapping("/works/save")
    public String saveWorks(Work work) {
        workRepository.save(work);

        return "redirect:/works";
    }

    @GetMapping("/works/delete/{id}")
    public String deleteWork(@PathVariable("id") Integer id, Model model){
        workRepository.deleteById(id);

        return "redirect:/works";
    }
}
