package com.areshok.Autoservice.controller;

import com.areshok.Autoservice.model.Order;
import com.areshok.Autoservice.model.User;
import com.areshok.Autoservice.repository.OrderRepository;
import com.areshok.Autoservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> listUsers = userRepository.findAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }

    @GetMapping("/users/new")
    public String showCreateNewUserForm(Model model) {
        List<Order> listOrders = orderRepository.findAll();
        model.addAttribute("user", new User());
        model.addAttribute("listOrders", listOrders);

        return "user_form";
    }

    @PostMapping("/users/save")
    public String saveUsers(User user) {
        userRepository.save(user);

        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String showEditUserForm(@PathVariable("id") Integer id, Model model) {
        User user = userRepository.findById(id).get();
        List<Order> listOrders = orderRepository.findAll();

        model.addAttribute("user", user);
        model.addAttribute("listOrders", listOrders);

        return "user_form";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, Model model) {
        userRepository.deleteById(id);

//        ResponseEntity.ok().build();

        return "redirect:/users";
    }
}
