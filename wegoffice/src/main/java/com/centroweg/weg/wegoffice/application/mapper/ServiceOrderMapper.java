package com.centroweg.weg.wegoffice.application.mapper;

import com.centroweg.weg.wegoffice.application.dto.serviceOrder.ServiceOrderRequestDto;
import com.centroweg.weg.wegoffice.application.dto.serviceOrder.ServiceOrderResponseDto;
import com.centroweg.weg.wegoffice.domain.entity.ServiceOrder;
import com.centroweg.weg.wegoffice.domain.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class ServiceOrderMapper {

    public ServiceOrder toEntity(ServiceOrderRequestDto request){
        return new ServiceOrder(
                request.equipment(),
                request.defectReported(),
                request.status(),
                request.materialsUsed(),
                request.technicalConclusion()
        );
    }

    public ServiceOrderResponseDto toDto(ServiceOrder serviceOrder){
        return new ServiceOrderResponseDto(
                serviceOrder.getId(),
                serviceOrder.getEquipment(),
                serviceOrder.getDefectReported(),
                serviceOrder.getStatus(),
                serviceOrder.getMaterialsUsed(),
                serviceOrder.getTechnicalConclusion(),
                serviceOrder.getTeacher().getName(),
                serviceOrder.getStudents().stream().map(Student::getName).toList()
        );
    }
}
