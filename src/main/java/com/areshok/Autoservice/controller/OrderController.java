package com.areshok.Autoservice.controller;

import com.areshok.Autoservice.model.Order;
import com.areshok.Autoservice.model.User;
import com.areshok.Autoservice.repository.OrderRepository;
import com.areshok.Autoservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/orders")
    public String listOrders(Model model) {
        List<Order> listOrders = orderRepository.findAll();
        model.addAttribute("listOrders", listOrders);

        return "orders";
    }

    @GetMapping("/orders/new")
    public String showCreateNewOrderForm(Model model) {
        List<User> listUsers = userRepository.findAll();
        model.addAttribute("order", new Order());
        model.addAttribute("listUsers", listUsers);

        return "order_form";
    }

    @PostMapping("/orders/save")
    public String saveOrders(Order order) {
        orderRepository.save(order);

        return "redirect:/orders";
    }

    @GetMapping("/orders/edit/{id}")
    public String showEditOrderForm(@PathVariable("id") Integer id, Model model){
        Order order = orderRepository.findById(id).get();
        model.addAttribute("order",order);

        List<User> listUsers = userRepository.findAll();
        model.addAttribute("listUsers",listUsers);

        return "order_form";
    }

    @GetMapping("/orders/delete/{id}")
    public String deleteOrder(@PathVariable("id") Integer id, Model model) {
        orderRepository.deleteById(id);

        return "redirect:/orders";
    }

}
