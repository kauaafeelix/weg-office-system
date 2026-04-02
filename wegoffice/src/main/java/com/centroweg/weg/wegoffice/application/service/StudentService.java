package com.centroweg.weg.wegoffice.application.service;

import com.centroweg.weg.wegoffice.application.dto.student.StudentRequestDto;
import com.centroweg.weg.wegoffice.application.dto.student.StudentResponseDto;
import com.centroweg.weg.wegoffice.application.mapper.StudentMapper;
import com.centroweg.weg.wegoffice.domain.entity.Classes;
import com.centroweg.weg.wegoffice.domain.entity.Student;
import com.centroweg.weg.wegoffice.domain.repository.ClassesRepository;
import com.centroweg.weg.wegoffice.domain.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final ClassesRepository classesRepository;

    public StudentResponseDto save (StudentRequestDto request){

        Classes classes = classesRepository.findById(request.classId())
                .orElseThrow(()-> new RuntimeException("O ID da turma não foi encontrado"));

        Student student = studentMapper.toEntity(request);

        student.setClasses(classes);

        studentRepository.save(student);

        return studentMapper.toDto(student);
    }

    public StudentResponseDto findById(Long id){
        Student student = studentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("O ID do aluno não foi encontrado"));
        return studentMapper.toDto(student);
    }

    public List<StudentResponseDto> findAll(){
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toDto)
                .toList();
    }

    public StudentResponseDto update (Long id, StudentRequestDto request ){
        Student student = studentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("O ID do aluno não foi encontrado"));

        Classes classes = classesRepository.findById(request.classId())
                .orElseThrow(()-> new RuntimeException("O ID da turma não foi encontrado"));

        student.setName(request.name());
        student.setEmail(request.email());
        student.setClasses(classes);

        studentRepository.save(student);

        return studentMapper.toDto(student);
    }

    public void delete (Long id){
        Student student = studentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("O ID do aluno não foi encontrado"));

        studentRepository.delete(student);
    }
}
