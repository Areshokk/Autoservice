package com.areshok.Autoservice.repository;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    @Order(1)
    public void saveOrderTest() {

        com.areshok.Autoservice.model.Order order = com.areshok.Autoservice.model.Order.builder()
                .id(1)
                .serviceName("Service Name")
                .price(1000)
                .build();

        orderRepository.save(order);

        Assertions.assertThat(order.getId()).isGreaterThan(0);

    }

    @Test
    @Order(2)
    @Rollback(value = false)
    public void getOrderTest() {
        com.areshok.Autoservice.model.Order order = orderRepository.findById(1).get();

        Assertions.assertThat(order.getId()).isEqualTo(1);

    }

    @Test
    @Order(3)
    public void getListOfOrdersTest() {

        List<com.areshok.Autoservice.model.Order> orders = orderRepository.findAll();

        Assertions.assertThat(orders.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateUserTest() {
        com.areshok.Autoservice.model.Order order = orderRepository.findById(1).get();

        order.setPrice(500);

        com.areshok.Autoservice.model.Order orderUpdated = orderRepository.save(order);

        Assertions.assertThat(orderUpdated.getPrice()).isEqualTo(500);
    }

    // TODO: 01.02.2022 update this method to delete user

//    @Test
//    @Order(5)
//    @Rollback(value = false)
//    public void deleteOrderTest() {
//
//        Integer id = 1;
//
//        boolean isExistBeforeDelete = orderRepository.findById(id).isPresent();
//
//        orderRepository.deleteById(id);
//
//        boolean notExistAfterDelete = orderRepository.findById(id).isPresent();
//
//        assertTrue(isExistBeforeDelete);
//        assertFalse(notExistAfterDelete);
//

//        com.areshok.Autoservice.model.Order order = orderRepository.findById(1).get();
//
//        orderRepository.deleteById(1);
//        orderRepository.delete(order);
//
//        com.areshok.Autoservice.model.Order order1 = null;
//
//        Optional<com.areshok.Autoservice.model.Order> optionalOrder = orderRepository.findByPrice(500);
//
//        if (optionalOrder.isPresent()) {
//            order1 = optionalOrder.get();
//        }
//
//        Assertions.assertThat(order).isNull();
//
//        System.out.println("delete Order Test");
//
//    }

}