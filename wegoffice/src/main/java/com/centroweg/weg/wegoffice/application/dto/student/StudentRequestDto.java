package com.centroweg.weg.wegoffice.application.dto.student;

public record StudentRequestDto(
    String name,
    String email,
    Long classId
) {
}
