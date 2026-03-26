package com.centroweg.weg.wegoffice.application.service;

import com.centroweg.weg.wegoffice.application.dto.teacher.TeacherRequestDto;
import com.centroweg.weg.wegoffice.application.dto.teacher.TeacherResponseDto;
import com.centroweg.weg.wegoffice.application.mapper.TeacherMapper;
import com.centroweg.weg.wegoffice.domain.entity.Teacher;
import com.centroweg.weg.wegoffice.domain.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TeacherService {

    private final TeacherRepository repository;
    private final TeacherMapper mapper;


    public TeacherResponseDto save (TeacherRequestDto request){
        Teacher teacher = mapper.toEntity(request);

        repository.save(teacher);

        return mapper.toDto(teacher);
    }

    public TeacherResponseDto findById(Long id){
        Teacher teacher = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("O ID do professor não foi encontrado"));
        return mapper.toDto(teacher);
    }

    public List<TeacherResponseDto> findAll(){
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public TeacherResponseDto update ( Long id, TeacherRequestDto request){
        Teacher teacher = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("O ID do professor não foi encontrado"));

        teacher.setName(request.name());
        teacher.setSpecialization(request.specialization());

        repository.save(teacher);

        return mapper.toDto(teacher);
    }

    public void delete (Long id){
        Teacher teacher = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("O ID do professor não foi encontrado"));

        repository.delete(teacher);
    }


}
