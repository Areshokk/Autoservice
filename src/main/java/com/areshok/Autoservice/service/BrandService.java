package com.areshok.Autoservice.service;

import com.areshok.Autoservice.model.Brand;
import com.areshok.Autoservice.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public List<Brand> listAll(){
        return brandRepository.findAll();
    }

    public void save(Brand brand) {
        brandRepository.save(brand);
    }

    public Brand findById(Integer id){
        return brandRepository.getOne(id);
    }

    public void deleteById(Integer id) {
        brandRepository.deleteById(id);
    }
}
