package com.ou.springcode.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequest (
    @NotBlank(message = "Username khong duoc de trong")
    @Size(min = 3, max = 50)
    String username,

    @NotBlank(message = "Email khong duoc de trong")
    @Email(message = "Email khong hop le")
    String email,
    String fullName
) {
    
}
