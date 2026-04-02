package com.centroweg.weg.wegoffice.domain.entity;

import com.centroweg.weg.wegoffice.domain.entity.enuns.StatusOS;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class ServiceOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String equipment;

    @Column(nullable = false, name = "defect_reported")
    private String defectReported;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusOS status;

    @Column(nullable = false, name = "materials_used")
    private String materialsUsed;

    @Column(nullable = false, name = "technical_conclusion")
    private String technicalConclusion;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    @ManyToMany
    @JoinTable(
            name = "student_so",
            joinColumns = @JoinColumn(name = "so_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;


    public ServiceOrder(String equipment, String defectReported, StatusOS status, String materialsUsed, String technicalConclusion) {
        this.equipment = equipment;
        this.defectReported = defectReported;
        this.status = status;
        this.materialsUsed = materialsUsed;
        this.technicalConclusion = technicalConclusion;
    }
}
