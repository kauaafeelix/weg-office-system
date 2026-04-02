package com.centroweg.weg.wegoffice.application.dto.serviceOrder;

import com.centroweg.weg.wegoffice.domain.entity.enuns.StatusOS;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record ServiceOrderRequestDto(
        @NotBlank(message = "O nome do equipamento nao pode ser nulo")
        String equipment,
        @NotBlank(message = "O defeito relatado nao pode ser nulo")
        String defectReported,
        @NotNull(message = "O status da ordem de servico nao pode ser nulo")
        StatusOS status,
        @NotBlank(message = "Os materiais utilizados nao podem ser nulos")
        String materialsUsed,
        @NotBlank(message = "A conclusao tecnica nao pode ser nula")
        String technicalConclusion,
        @NotNull(message = "O id do professor nao pode ser nulo")
        Long teacherId,
        @NotNull(message = "O id dos alunos nao pode ser nulo")
        List<Long> studentIds
) {
}
