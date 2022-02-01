package com.areshok.Autoservice.controller;

import com.areshok.Autoservice.model.Brand;
import com.areshok.Autoservice.model.Car;
import com.areshok.Autoservice.model.Work;
import com.areshok.Autoservice.repository.BrandRepository;
import com.areshok.Autoservice.repository.ModelRepository;
import com.areshok.Autoservice.service.BrandService;
import com.areshok.Autoservice.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ModelController {

    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private BrandRepository brandRepository;


    @GetMapping("/models")
    public String listCategories(Model model) {
        List<com.areshok.Autoservice.model.Model> listModels = modelRepository.findAll();
        model.addAttribute("listModels",listModels);

        return "models";
    }

    @GetMapping("/models/new")
    public String showCreateNewModelForm(Model model) {
        List<Brand> listBrands = brandRepository.findAll();
        model.addAttribute("model",new com.areshok.Autoservice.model.Model());
        model.addAttribute("listBrands", listBrands);


        return "model_form";
    }

    @PostMapping("/models/save")
    public String saveModel(com.areshok.Autoservice.model.Model model) {
        modelRepository.save(model);

        return "redirect:/models";
    }


    @GetMapping("/models/delete/{id}")
    public String deleteModel(@PathVariable("id") Integer id, Model model){
        modelRepository.deleteById(id);

        return "redirect:/models";
    }
}
