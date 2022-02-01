package com.areshok.Autoservice.repository;

import com.areshok.Autoservice.model.Car;
import com.areshok.Autoservice.model.User;
import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Order(1)
    public void saveUserTest() {

//        User user = User.builder()
//                .id(1)
//                .name("Yura")
//                .phone("1234")
//                .build();

        User user = new User(1,"Name","1234",new ArrayList<>());

        userRepository.save(user);

        Assertions.assertThat(user.getId()).isGreaterThan(0);

    }



    @Test
    @Order(2)
    @Rollback(value = false)
    public void getUserTest() {
        User user = userRepository.findById(1).get();

        Assertions.assertThat(user.getId()).isEqualTo(1);

    }

    @Test
    @Order(3)
    public void getListOfUsersTest() {

        List<User> users = userRepository.findAll();

        Assertions.assertThat(users.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateUserTest() {
        User user = userRepository.findById(1).get();

        user.setPhone("654321");

        User userUpdated = userRepository.save(user);

        Assertions.assertThat(userUpdated.getPhone()).isEqualTo("654321");
    }


    // TODO: 01.02.2022 update this method to delete user
//
//    @Test
//    @Order(5)
//    @Rollback(value = false)
//    public void deleteUserTest() {
//        User user = userRepository.findById(1).get();
//
////        userRepository.deleteById(1);
//        userRepository.delete(user);
//
//        User user1 = null;
//
//        Optional<User> optionalUser = userRepository.findByPhone("654321");
//
//        if (optionalUser.isPresent()) {
//            user1 = optionalUser.get();
//        }
//
//        Assertions.assertThat(user).isNull();
//
//        System.out.println("delete User Test");
//    }


}