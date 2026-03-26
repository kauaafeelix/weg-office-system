package com.centroweg.weg.wegoffice.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String specialization;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Classes> classes;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<ServiceOrder> serviceOrders;

    public Teacher(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

}
