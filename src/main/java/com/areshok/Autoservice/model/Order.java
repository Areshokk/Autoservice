package com.areshok.Autoservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    public Order(Integer id, String serviceName, Integer price) {
        this.id = id;
        this.serviceName = serviceName;
        this.price = price;
    }

}
