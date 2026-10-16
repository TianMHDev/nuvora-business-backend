package com.nuvora_business.backend.business.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record BusinessRequest(

        @NotBlank(message = "The business name is required")
        @Size(max = 120)
        String name,

        @NotBlank(message = "The business type is required")
        @Size(max = 60)
        String businessType,

        @Email(message = "The email format is invalid")
        @Size(max = 150)
        String email,

        @Size(max = 30)
        String phone

) {
}