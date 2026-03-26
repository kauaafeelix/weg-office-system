package com.centroweg.weg.wegoffice.domain.repository;

import com.centroweg.weg.wegoffice.domain.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
