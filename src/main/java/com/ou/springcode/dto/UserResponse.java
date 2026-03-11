package com.ou.springcode.dto;

import com.ou.springcode.model.User;

public record UserResponse (
    Long id,
    String username,
    String email,
    String fullName,
    String createdAt
) {
    public static UserResponse fromEntity (User user) {
        return new UserResponse(
            user.getId(),
            user.getUsername(),
            user.getEmail(),
            user.getFullName(),
            user.getCreatedAt().toString()
        );
    }
}
