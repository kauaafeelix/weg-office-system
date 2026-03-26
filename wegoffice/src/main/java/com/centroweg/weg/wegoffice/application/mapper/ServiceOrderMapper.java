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
                request.defectReported()
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
                serviceOrder.getTeacher().getId(),
                serviceOrder.getStudents().stream().map(Student::getId).toList()
        );
    }
}
