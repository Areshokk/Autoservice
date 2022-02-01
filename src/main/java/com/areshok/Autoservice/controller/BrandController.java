package com.areshok.Autoservice.controller;

import com.areshok.Autoservice.model.Brand;
import com.areshok.Autoservice.model.Car;
import com.areshok.Autoservice.repository.BrandRepository;
import com.areshok.Autoservice.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BrandController {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private CarRepository carRepository;

    @GetMapping("/brands")
    public String listWorks(Model model) {
        List<Brand> listBrands = brandRepository.findAll();
        model.addAttribute("listBrands", listBrands);

        return "brands";
    }

    @GetMapping("/brands/new")
    public String showCreateNewBrandForm(Model model) {
        List<Car> listCars = carRepository.findAll();
        model.addAttribute("brand", new Brand());
        model.addAttribute("listCars", listCars);

        return "brand_form";
    }

    @PostMapping("/brands/save")
    public String saveBrands(Brand brand) {
        brandRepository.save(brand);

        return "redirect:/brands";
    }

    @GetMapping("/brands/delete/{id}")
    public String deleteBrand(@PathVariable("id") Integer id, Model model) {
        brandRepository.deleteById(id);

        return "redirect:/brands";
    }
}
