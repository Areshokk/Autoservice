package com.areshok.Autoservice.service;

import com.areshok.Autoservice.model.Work;
import com.areshok.Autoservice.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkService {

    @Autowired
    private WorkRepository workRepository;

    public List<Work> listAll() {
        return workRepository.findAll();
    }

    public void save(Work work) {
        workRepository.save(work);
    }

    public Work findById(Integer id) {
        return workRepository.getOne(id);
    }

    public void deleteById(Integer id) {
        workRepository.deleteById(id);
    }
}
