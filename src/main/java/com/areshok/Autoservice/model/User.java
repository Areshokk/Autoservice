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
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;

    @OneToMany
    @JoinColumn(name = "users_id")
    private List<Order> orders = new ArrayList<>();

    public User(Integer id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

}
