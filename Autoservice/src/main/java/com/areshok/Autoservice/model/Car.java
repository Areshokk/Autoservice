package com.areshok.Autoservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String color;
    private Integer year;

    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Order order;

    @OneToMany
    @JoinColumn(name = "cars_id")
    List<Work> works = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "cars_id")
    List<Mechanic> mechanics = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "cars_id")
    List<Brand> brand = new ArrayList<>();
}
