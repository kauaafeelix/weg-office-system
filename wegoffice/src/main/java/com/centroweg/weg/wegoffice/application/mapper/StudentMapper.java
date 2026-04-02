package com.centroweg.weg.wegoffice.application.mapper;

import com.centroweg.weg.wegoffice.application.dto.student.StudentRequestDto;
import com.centroweg.weg.wegoffice.application.dto.student.StudentResponseDto;
import com.centroweg.weg.wegoffice.domain.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public Student toEntity(StudentRequestDto request){
        return new Student(
            request.name(),
            request.email()
        );
    }

    public StudentResponseDto toDto(Student student){
        return new StudentResponseDto(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getClasses().getCode()
        );
    }
}
