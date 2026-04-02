package com.centroweg.weg.wegoffice.infra.controller;


import com.centroweg.weg.wegoffice.application.dto.classes.ClassesRequestDto;
import com.centroweg.weg.wegoffice.application.dto.classes.ClassesResponseDto;
import com.centroweg.weg.wegoffice.application.dto.student.StudentRequestDto;
import com.centroweg.weg.wegoffice.application.dto.student.StudentResponseDto;
import com.centroweg.weg.wegoffice.application.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;


    @PostMapping
    public ResponseEntity<StudentResponseDto> save (@Valid @RequestBody StudentRequestDto request){

        StudentResponseDto response = service.save(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDto> findById (@PathVariable Long id){

        StudentResponseDto response = service.findById(id);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<StudentResponseDto>> findAll (){

        List<StudentResponseDto> response = service.findAll();

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDto> update (@PathVariable Long id, @Valid  @RequestBody StudentRequestDto request){

        StudentResponseDto response = service.update(id, request);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StudentResponseDto> delete (@PathVariable Long id){

        service.delete(id);

        return ResponseEntity.noContent().build();
    }


}
