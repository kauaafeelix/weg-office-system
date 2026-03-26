package com.centroweg.weg.wegoffice.application.mapper;

import com.centroweg.weg.wegoffice.application.dto.teacher.TeacherRequestDto;
import com.centroweg.weg.wegoffice.application.dto.teacher.TeacherResponseDto;
import com.centroweg.weg.wegoffice.domain.entity.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper {

    public Teacher toEntity(TeacherRequestDto request){
        return new Teacher(
                request.name(),
                request.specialization()
        );
    }

    public TeacherResponseDto toDto (Teacher teacher){
        return new TeacherResponseDto(
                teacher.getId(),
                teacher.getName(),
                teacher.getSpecialization()
        );
    }
}
