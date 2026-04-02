package com.centroweg.weg.wegoffice.domain.entity;

import com.centroweg.weg.wegoffice.application.mapper.ServiceOrderMapper;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private Classes classes;

    @ManyToMany(mappedBy = "students")
    private List<ServiceOrder> serviceOrders;

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
