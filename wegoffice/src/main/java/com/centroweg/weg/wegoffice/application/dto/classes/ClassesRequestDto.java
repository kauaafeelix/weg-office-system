package com.centroweg.weg.wegoffice.application.dto.classes;

public record ClassesRequestDto (
    String name,
    String description,
    Long teacherId
) {
}

