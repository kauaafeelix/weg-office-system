package com.centroweg.weg.wegoffice.application.dto.classes;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClassesRequestDto (
        @NotBlank (message = "Code não pode ser nulo")
        String code,

        @NotNull(message = "O Teacher Id não pode ser nulo.")
        Long teacherId
    ) {
}

