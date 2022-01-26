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
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "service_name")
    private String serviceName;

    private Integer price;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;

    @OneToMany
    @JoinColumn(name = "orders_id")
    private List<Car> cars = new ArrayList<>();
}
