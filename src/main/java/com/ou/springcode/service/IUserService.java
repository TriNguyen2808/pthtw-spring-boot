package com.ou.springcode.service;

import java.util.List;

import com.ou.springcode.dto.UserResponse;

public interface IUserService {
    List<UserResponse> findAll();

    boolean deleteById(Long id);
}
