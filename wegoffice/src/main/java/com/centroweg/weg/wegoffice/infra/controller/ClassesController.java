package com.centroweg.weg.wegoffice.infra.controller;

import com.centroweg.weg.wegoffice.application.dto.classes.ClassesRequestDto;
import com.centroweg.weg.wegoffice.application.dto.classes.ClassesResponseDto;
import com.centroweg.weg.wegoffice.application.service.ClassesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/classes")
public class ClassesController {

    private final ClassesService service;


    @PostMapping
    public ResponseEntity<ClassesResponseDto> save (@Valid @RequestBody ClassesRequestDto request){

        ClassesResponseDto response = service.save(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassesResponseDto> findById (@PathVariable Long id){

        ClassesResponseDto response = service.findById(id);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ClassesResponseDto>> findAll (){

        List<ClassesResponseDto> response = service.findAll();

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassesResponseDto> update (@PathVariable Long id, @Valid @RequestBody ClassesRequestDto request){

        ClassesResponseDto response = service.update(id, request);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClassesResponseDto> delete (@PathVariable Long id){

        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
