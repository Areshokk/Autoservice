package com.areshok.Autoservice.service;

import com.areshok.Autoservice.model.Mechanic;
import com.areshok.Autoservice.repository.MechanicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MechanicService {

    @Autowired
    private MechanicRepository mechanicRepository;

    public List<Mechanic> listAll(){
        return mechanicRepository.findAll();
    }

    public void save(Mechanic mechanic) {
        mechanicRepository.save(mechanic);
    }

    public Mechanic findById(Integer id){
        return mechanicRepository.getOne(id);
    }

    public void deleteById(Integer id) {
        mechanicRepository.deleteById(id);
    }
}
