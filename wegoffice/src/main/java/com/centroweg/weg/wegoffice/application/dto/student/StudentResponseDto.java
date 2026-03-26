package com.centroweg.weg.wegoffice.application.dto.student;

public record StudentResponseDto(
        Long id,
        String name,
        String email,
        Long classId
) {
}
