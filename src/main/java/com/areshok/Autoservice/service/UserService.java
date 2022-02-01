package com.areshok.Autoservice.service;

import com.areshok.Autoservice.model.User;
import com.areshok.Autoservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> listAll() {
        return userRepository.findAll();
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public User findById(Integer id) {
        return userRepository.getOne(id);
    }

    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

}
