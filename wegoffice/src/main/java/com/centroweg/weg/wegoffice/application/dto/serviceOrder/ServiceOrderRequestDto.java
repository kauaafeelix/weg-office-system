package com.centroweg.weg.wegoffice.application.dto.serviceOrder;

import com.centroweg.weg.wegoffice.domain.entity.enuns.StatusOS;

import java.util.List;

public record ServiceOrderRequestDto(
        String equipment,
        String defectReported,
        StatusOS status,
        String materialsUsed,
        String technicalConclusion,
        Long teacherId,
        List<Long> studentIds
) {
}
