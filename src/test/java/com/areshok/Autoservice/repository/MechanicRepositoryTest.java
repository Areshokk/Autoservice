package com.areshok.Autoservice.repository;

import com.areshok.Autoservice.model.Car;
import com.areshok.Autoservice.model.Mechanic;
import com.areshok.Autoservice.model.Work;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
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
class MechanicRepositoryTest {
    @Autowired
    private MechanicRepository mechanicRepository;

    @Test
    @Order(1)
    public void saveMechanicTest() {

//        Mechanic mechanic = Mechanic.builder()
//                .id(1)
//                .firstName("First Name")
//                .lastName("Last Name")
//                .build();

        Mechanic mechanic = new Mechanic(1,"First Name","Last Name",new Car());

        mechanicRepository.save(mechanic);

        Assertions.assertThat(mechanic.getId()).isGreaterThan(0);

    }

    @Test
    @Order(2)
    @Rollback(value = false)
    public void getMechanicTest() {
        Mechanic mechanic = mechanicRepository.findById(1).get();

        Assertions.assertThat(mechanic.getId()).isEqualTo(1);

    }

    @Test
    @Order(3)
    public void getListOfMechanicTest() {

        List<Mechanic> mechanics = mechanicRepository.findAll();

        Assertions.assertThat(mechanics.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateMechanicTest() {
        Mechanic mechanic = mechanicRepository.findById(1).get();

        mechanic.setFirstName("Yurii");

        Mechanic mechanicUpdated = mechanicRepository.save(mechanic);

        Assertions.assertThat(mechanicUpdated.getFirstName()).isEqualTo("Yurii");
    }

    // TODO: 01.02.2022 update this method to delete mechanic
//
//    @Test
//    @Order(5)
//    @Rollback(value = false)
//    public void deleteMechanicTest() {
//        Mechanic mechanic = mechanicRepository.findById(1).get();
//
////        mechanicRepository.deleteById(1);
//        mechanicRepository.delete(mechanic);
//
//        Mechanic mechanic1 = null;
//
//        Optional<Mechanic> optionalMechanic = mechanicRepository.findByFirstName("Yurii");
//
//        if (optionalMechanic.isPresent()) {
//            mechanic1 = optionalMechanic.get();
//        }
//
//        Assertions.assertThat(mechanic).isNull();
//
//        System.out.println("delete Mechanic Test");
//    }
}