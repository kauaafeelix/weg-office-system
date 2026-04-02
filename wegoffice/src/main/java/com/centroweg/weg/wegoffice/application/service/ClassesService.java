package com.centroweg.weg.wegoffice.application.service;

import com.centroweg.weg.wegoffice.application.dto.classes.ClassesRequestDto;
import com.centroweg.weg.wegoffice.application.dto.classes.ClassesResponseDto;
import com.centroweg.weg.wegoffice.application.mapper.ClassesMapper;
import com.centroweg.weg.wegoffice.domain.entity.Classes;
import com.centroweg.weg.wegoffice.domain.entity.Teacher;
import com.centroweg.weg.wegoffice.domain.repository.ClassesRepository;
import com.centroweg.weg.wegoffice.domain.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor

@Service
public class ClassesService {
    private final ClassesRepository classesRepository;
    private final ClassesMapper classesMapper;
    private final TeacherRepository teacherRepository;


    public ClassesResponseDto save (ClassesRequestDto request){

        Teacher teacher = teacherRepository.findById(request.teacherId())
                .orElseThrow(() -> new RuntimeException("O ID do professor não foi encontrado"));

        Classes classes = classesMapper.toEntity(request);

        classes.setTeacher(teacher);

        classesRepository.save(classes);

        return classesMapper.toDto(classes);
    }

    public ClassesResponseDto findById(Long id){
        Classes classes = classesRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("O ID da turma não foi encontrado"));
        return classesMapper.toDto(classes);
    }

    public List<ClassesResponseDto> findAll(){
        return classesRepository.findAll()
                .stream()
                .map(classesMapper::toDto)
                .toList();
    }

    public ClassesResponseDto update ( Long id, ClassesRequestDto request){
        Classes classes = classesRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("O ID da turma não foi encontrado"));

        Teacher teacher = teacherRepository.findById(request.teacherId())
                .orElseThrow(() -> new RuntimeException("O ID do professor não foi encontrado"));


        classes.setCode(request.code());
        classes.setTeacher(teacher);

        classesRepository.save(classes);

        return classesMapper.toDto(classes);
    }

    public void delete (Long id){
        Classes classes = classesRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("O ID da turma não foi encontrado"));

        classesRepository.delete(classes);
    }
}
