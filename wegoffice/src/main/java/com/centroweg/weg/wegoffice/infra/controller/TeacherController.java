package com.centroweg.weg.wegoffice.infra.controller;

import com.centroweg.weg.wegoffice.application.dto.teacher.TeacherRequestDto;
import com.centroweg.weg.wegoffice.application.dto.teacher.TeacherResponseDto;
import com.centroweg.weg.wegoffice.application.service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService service;

    @PostMapping
    public ResponseEntity<TeacherResponseDto> save (@Valid  @RequestBody TeacherRequestDto request){
        TeacherResponseDto response = service.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherResponseDto> findById (@PathVariable Long id) {
        TeacherResponseDto response = service.findById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<TeacherResponseDto>> findAll () {
        List<TeacherResponseDto> response = service.findAll();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeacherResponseDto> update (@PathVariable Long id, @Valid @RequestBody TeacherRequestDto request) {
        TeacherResponseDto response = service.update(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
