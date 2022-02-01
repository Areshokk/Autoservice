package com.areshok.Autoservice.repository;

import com.areshok.Autoservice.model.Brand;
import com.areshok.Autoservice.model.Car;
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
class BrandRepositoryTest {

    @Autowired
    private BrandRepository brandRepository;

    @Test
    @Order(1)
    public void saveBrandTest() {
//
//        Brand brand = Brand.builder()
//                .id(1)
//                .name("Brand Name")
//                .build();

        Brand brand = new Brand(1, "Brand Name", new ArrayList<>(), new Car());

        brandRepository.save(brand);

        Assertions.assertThat(brand.getId()).isGreaterThan(0);

    }

    @Test
    @Order(2)
    @Rollback(value = false)
    public void getBrandTest() {
        Brand brand = brandRepository.findById(1).get();

        Assertions.assertThat(brand.getId()).isEqualTo(1);

    }

    @Test
    @Order(3)
    public void getListOfBrandTest() {

        List<Brand> brands = brandRepository.findAll();

        Assertions.assertThat(brands.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateBrandTest() {
        Brand brand = brandRepository.findById(1).get();

        brand.setName("Brand");

        Brand brandUpdated = brandRepository.save(brand);

        Assertions.assertThat(brandUpdated.getName()).isEqualTo("Brand");
    }

    // TODO: 01.02.2022 update this method to delete mechanic

//    @Test
//    @Order(5)
//    @Rollback(value = false)
//    public void deleteBrandTest() {
//        Brand brand = brandRepository.findById(1).get();
//
////        brandRepository.deleteById(1);
//        brandRepository.delete(brand);
//
//        Brand brand1 = null;
//
//        Optional<Brand> optionalBrand = brandRepository.findByName("Brand");
//
//        if (optionalBrand.isPresent()) {
//            brand1 = optionalBrand.get();
//        }
//
//        Assertions.assertThat(brand).isNull();
//
//        System.out.println("delete Brand Test");
//    }
}