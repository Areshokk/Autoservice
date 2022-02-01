package com.areshok.Autoservice.service;

import com.areshok.Autoservice.model.Order;
import com.areshok.Autoservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> listAll() {
        return orderRepository.findAll();
    }

    public void save(Order order) {
        orderRepository.save(order);
    }

    public Order findById(Integer id) {
        return orderRepository.getOne(id);
    }

    public void deleteById(Integer id) {
        orderRepository.deleteById(id);
    }
}
