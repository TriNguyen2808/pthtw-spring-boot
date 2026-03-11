package com.ou.springcode.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ou.springcode.dto.UserRequest;
import com.ou.springcode.dto.UserResponse;
import com.ou.springcode.model.User;
import com.ou.springcode.service.UserService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //GET /api/users
    // @RequestMapping(value = "/users", method = RequestMethod.GET)
    @GetMapping()
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
    public ResponseEntity<List<UserResponse>> getAllUser() {
        List<UserResponse> users = userService.findAll();

        return ResponseEntity.ok(users);
    }

    //GET /api/users/{id}
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    //POST /api/users
    @PostMapping()
    public ResponseEntity<User> create(@RequestBody UserRequest request){
        User created = null;

        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody UserRequest request){
        User updated = null;

        return ResponseEntity.ok(updated);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> patch(@PathVariable Long id, @RequestBody UserRequest request){
        User updated = null;

        return ResponseEntity.ok(updated);
    }

    @PostMapping("/{id}")
    public ResponseEntity<User> updatePartial(@PathVariable Long id, @RequestBody UserRequest request){
        User updated = null;

        return ResponseEntity.ok(updated);
    }

    //DELETE /api/users
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        return userService.deleteById(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
    
}
