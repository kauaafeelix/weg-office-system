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
public class Classes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String code;

    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = false)
    private Teacher teacher;

    @OneToMany(mappedBy = "classes", cascade = CascadeType.ALL)
    private List<Student> students;

    public Classes(String codigo) {
        this.code = code;
    }
}
