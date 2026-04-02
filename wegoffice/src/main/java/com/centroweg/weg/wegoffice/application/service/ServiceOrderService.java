package com.centroweg.weg.wegoffice.application.service;

import com.centroweg.weg.wegoffice.application.dto.serviceOrder.ServiceOrderRequestDto;
import com.centroweg.weg.wegoffice.application.dto.serviceOrder.ServiceOrderResponseDto;
import com.centroweg.weg.wegoffice.application.mapper.ServiceOrderMapper;
import com.centroweg.weg.wegoffice.domain.entity.ServiceOrder;
import com.centroweg.weg.wegoffice.domain.entity.Student;
import com.centroweg.weg.wegoffice.domain.entity.Teacher;
import com.centroweg.weg.wegoffice.domain.entity.enuns.StatusOS;
import com.centroweg.weg.wegoffice.domain.repository.ServiceOrderRepository;
import com.centroweg.weg.wegoffice.domain.repository.StudentRepository;
import com.centroweg.weg.wegoffice.domain.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ServiceOrderService {

    private final ServiceOrderRepository orderRepository;
    private final ServiceOrderMapper orderMapper;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;


    public ServiceOrderResponseDto save (ServiceOrderRequestDto request){

        Teacher teacher = teacherRepository.findById(request.teacherId())
                .orElseThrow(()-> new RuntimeException("O ID do professor não foi encontrado"));
        List<Student> students = studentRepository.findAllById(request.studentIds());

        ServiceOrder serviceOrder = orderMapper.toEntity(request);

        serviceOrder.setTeacher(teacher);
        serviceOrder.setStudents(students);
        serviceOrder.setStatus(StatusOS.EXECUTING);

        orderRepository.save(serviceOrder);

        return orderMapper.toDto(serviceOrder);
    }

    public ServiceOrderResponseDto findById(Long id){
        ServiceOrder serviceOrder = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("O ID da ordem de serviço não foi encontrado"));
        return orderMapper.toDto(serviceOrder);
    }

    public List<ServiceOrderResponseDto> findAll(){
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::toDto)
                .toList();
    }

    public ServiceOrderResponseDto update ( Long id, ServiceOrderRequestDto request){
        ServiceOrder serviceOrder = orderRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("O ID da ordem não foi encontrado"));

        Teacher teacher = teacherRepository.findById(request.teacherId())
                .orElseThrow(()-> new RuntimeException("O ID do professor não foi encontrado"));
        Student student = studentRepository.findById(request.studentIds().getFirst())
                .orElseThrow(()-> new RuntimeException("O ID do aluno não foi encontrado"));

        serviceOrder.setEquipment(request.equipment());
        serviceOrder.setDefectReported(request.defectReported());
        serviceOrder.setTeacher(teacher);
        serviceOrder.setStudents(List.of(student));


        orderRepository.save(serviceOrder);

        return orderMapper.toDto(serviceOrder);
    }

    public void delete (Long id){
        ServiceOrder serviceOrder = orderRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("O ID da ordem não foi encontrado"));

        orderRepository.delete(serviceOrder);
    }
}
