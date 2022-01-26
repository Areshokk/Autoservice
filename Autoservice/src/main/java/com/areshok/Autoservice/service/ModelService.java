package com.areshok.Autoservice.service;

import com.areshok.Autoservice.model.Model;
import com.areshok.Autoservice.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ModelService {

    @Autowired
    private ModelRepository modelRepository;

    public List<Model> listAll(){
        return modelRepository.findAll();
    }

    public void save(Model model) {
        modelRepository.save(model);
    }

    public Model findById(Integer id){
        return modelRepository.getOne(id);
    }

    public void deleteById(Integer id) {
        modelRepository.deleteById(id);
    }
}
