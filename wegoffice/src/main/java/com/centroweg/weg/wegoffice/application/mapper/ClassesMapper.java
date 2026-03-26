package com.centroweg.weg.wegoffice.application.mapper;

import com.centroweg.weg.wegoffice.application.dto.classes.ClassesRequestDto;
import com.centroweg.weg.wegoffice.application.dto.classes.ClassesResponseDto;
import com.centroweg.weg.wegoffice.domain.entity.Classes;
import org.springframework.stereotype.Component;

@Component
public class ClassesMapper {

    public Classes toEntity(ClassesRequestDto request){
        return new Classes(
                request.code()
        );
    }

    public ClassesResponseDto toDto(Classes classes){
        return new ClassesResponseDto(
                classes.getId(),
                classes.getCode(),
                classes.getProfessor().getId()
        );
    }
}
