package com.areshok.Autoservice.repository;

import com.areshok.Autoservice.model.Car;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class WorkRepositoryTest {

    @Autowired
    private WorkRepository workRepository;

    @Test
    @Order(1)
    public void saveWorkTest() {

//        Work work = Work.builder()
//                .id(1)
//                .works("Replace oil")
//                .build();

        Work work = new Work(1, "Replace oil", new Car());

        workRepository.save(work);

        Assertions.assertThat(work.getId()).isGreaterThan(0);

    }

    @Test
    @Order(2)
    @Rollback(value = false)
    public void getWorkTest() {
        Work work = workRepository.findById(1).get();

        Assertions.assertThat(work.getId()).isEqualTo(1);

    }

    @Test
    @Order(3)
    public void getListOfWorkTest() {

        List<Work> works = workRepository.findAll();

        Assertions.assertThat(works.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateWorkTest() {
        Work work = workRepository.findById(1).get();

        work.setWorks("Replace wheel");

        Work workUpdated = workRepository.save(work);

        Assertions.assertThat(workUpdated.getWorks()).isEqualTo("Replace wheel");
    }

    // TODO: 01.02.2022 update this method to delete work

//    @Test
//    @Order(5)
//    @Rollback(value = false)
//    public void deleteWorkTest() {
//        Work work = workRepository.findById(1).get();
//
////        workRepository.deleteById(1);
//        workRepository.delete(work);
//
//        Work work1 = null;
//
//        Optional<Work> optionalWork = workRepository.findByWorks("Replace wheel");
//
//        if (optionalWork.isPresent()) {
//            work1 = optionalWork.get();
//        }
//
//        Assertions.assertThat(work).isNull();
//
//        System.out.println("delete Car Test");
//    }

}