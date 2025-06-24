package com.example.authservice.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class LoginResponseDTO {
    private final String token;

    public LoginResponseDTO(String token) {
        this.token = token;
    }
}
