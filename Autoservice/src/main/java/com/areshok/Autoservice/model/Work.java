package com.areshok.Autoservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "works")
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "types_of_work")
    private String works;

    @ManyToOne
    @JoinColumn(name = "cars_id")
    private Car car;
}
