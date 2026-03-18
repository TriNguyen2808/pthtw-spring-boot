package com.ou.springcode.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ou.springcode.dto.UserRequest;
import com.ou.springcode.dto.UserPatchRequest;
import com.ou.springcode.dto.UserResponse;

public interface IUserService {
    List<UserResponse> findAll();
    ResponseEntity<UserResponse> findById(Long id);
    ResponseEntity<UserResponse> create(UserRequest request);
    ResponseEntity<UserResponse> update(Long id, UserPatchRequest request);
    ResponseEntity<UserResponse> updatePut(Long id, UserPatchRequest request);
    boolean deleteById(Long id);
}
