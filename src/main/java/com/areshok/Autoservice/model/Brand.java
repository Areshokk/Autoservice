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
@Table(name = "brands")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany
    @JoinColumn(name = "brands_id")
    private List<Model> models = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "cars_id")
    private Car car;

    public Brand(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
