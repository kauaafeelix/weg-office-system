package com.centroweg.weg.wegoffice.application.dto.student;

public record StudenteRequestDto(
    String name,
    String email,
    Long classId
) {
}
