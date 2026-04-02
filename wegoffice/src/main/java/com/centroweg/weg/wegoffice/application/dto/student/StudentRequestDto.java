package com.centroweg.weg.wegoffice.application.dto.student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record StudentRequestDto(
        @NotBlank(message = "O nome do student nao pode ser nulo")
        String name,
        @NotBlank(message = "O email do student nao pode ser nulo")
        @Email(message = "O email do student deve ser valido")
        String email,
        @NotNull(message = "O id da classe nao pode ser nulo")
        Long classId
) {
}
