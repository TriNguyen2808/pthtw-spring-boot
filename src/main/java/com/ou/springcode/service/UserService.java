package com.ou.springcode.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ou.springcode.dto.UserResponse;
import com.ou.springcode.model.User;
import com.ou.springcode.repository.UserRepository;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<UserResponse> findAll() {
        return userRepository.findAll().stream()
                .map(UserResponse::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteById(Long id) {
        if(!userRepository.existsById(id))
            return false;
        userRepository.deleteById(id);
        return true;
    }

    public ResponseEntity<UserResponse> findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        return ResponseEntity.ok(UserResponse.fromEntity(user));
    }
    
    public ResponseEntity<UserResponse> update(User user) {
        User updated = userRepository.update(user);
        return ResponseEntity.ok(UserResponse.fromEntity(updated));
    }

    public ResponseEntity<UserResponse> partialUpdate(User user) {
        User updated = userRepository.partialUpdate(user);
        return ResponseEntity.ok(UserResponse.fromEntity(updated));
    }
}
