package com.luppi.gestaofinanceira.controller;

import com.luppi.gestaofinanceira.dto.UserCreateDTO;
import com.luppi.gestaofinanceira.dto.UserDTO;
import com.luppi.gestaofinanceira.service.user.CreateUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final CreateUserService createUserService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> create(UserCreateDTO userCreateDTO) {
        return ResponseEntity.ok(createUserService.createUser(userCreateDTO));
    }
}
