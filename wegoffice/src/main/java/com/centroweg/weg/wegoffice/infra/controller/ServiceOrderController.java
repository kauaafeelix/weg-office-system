package com.centroweg.weg.wegoffice.infra.controller;


import com.centroweg.weg.wegoffice.application.dto.serviceOrder.ServiceOrderRequestDto;
import com.centroweg.weg.wegoffice.application.dto.serviceOrder.ServiceOrderResponseDto;
import com.centroweg.weg.wegoffice.application.service.ServiceOrderService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class ServiceOrderController {

    private final ServiceOrderService service;

    @PostMapping
    public ResponseEntity<ServiceOrderResponseDto> save (@RequestBody ServiceOrderRequestDto request){

        ServiceOrderResponseDto response = service.save(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceOrderResponseDto> findById (@PathVariable Long id){

        ServiceOrderResponseDto response = service.findById(id);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ServiceOrderResponseDto>> findAll(){

        List<ServiceOrderResponseDto> response = service.findAll();

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceOrderResponseDto> update (
            @PathVariable Long id,
            @RequestBody ServiceOrderRequestDto request
    ){

        ServiceOrderResponseDto response = service.update(id, request);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){

        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}
