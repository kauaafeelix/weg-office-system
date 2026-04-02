package com.centroweg.weg.wegoffice.application.dto.teacher;

import jakarta.validation.constraints.NotBlank;

public record TeacherRequestDto(
        @NotBlank(message = "O nome do teacher nao pode ser nulo")
        String name,
        @NotBlank(message = "A especializacao nao pode ser nulo")
        String specialization
) {
}
