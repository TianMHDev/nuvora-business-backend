package com.nuvora_business.backend.business.dto;

import java.time.LocalDateTime;

public record BusinessResponse(
        Long id,
        String name,
        String businessType,
        String email,
        String phone,
        LocalDateTime createdAt
) {
}
