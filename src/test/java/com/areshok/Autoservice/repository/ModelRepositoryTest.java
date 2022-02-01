package com.areshok.Autoservice.repository;

import com.areshok.Autoservice.model.Brand;
import com.areshok.Autoservice.model.Car;
import com.areshok.Autoservice.model.Model;
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
class ModelRepositoryTest {

    @Autowired
    private  ModelRepository modelRepository;

    @Test
    @Order(1)
    public void saveModelTest() {

//        Model model = Model.builder()
//                .id(1)
//                .name("Brand Name")
//                .build();

        Model model = new Model(1, "Model Name",new Brand());

        modelRepository.save(model);

        Assertions.assertThat(model.getId()).isGreaterThan(0);

    }

    @Test
    @Order(2)
    @Rollback(value = false)
    public void getModelTest() {
        Model model = modelRepository.findById(1).get();

        Assertions.assertThat(model.getId()).isEqualTo(1);

    }

    @Test
    @Order(3)
    public void getListOfModelTest() {

        List<Model> models = modelRepository.findAll();

        Assertions.assertThat(models.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateModelTest() {
        Model model = modelRepository.findById(1).get();

        model.setName("Model");

        Model modelUpdated = modelRepository.save(model);

        Assertions.assertThat(modelUpdated.getName()).isEqualTo("Model");
    }

    // TODO: 01.02.2022 update this method to delete mechanic

//    @Test
//    @Order(5)
//    @Rollback(value = false)
//    public void deleteModelTest() {
//        Model model = modelRepository.findById(1).get();
//
////        modelRepository.deleteById(1);
//        modelRepository.delete(model);
//
//        Model model1 = null;
//
//        Optional<Model> optionalModel = modelRepository.findByName("Model");
//
//        if (optionalModel.isPresent()) {
//            model1 = optionalModel.get();
//        }
//
//        Assertions.assertThat(model).isNull();
//
//        System.out.println("delete Model Test");
//    }
}