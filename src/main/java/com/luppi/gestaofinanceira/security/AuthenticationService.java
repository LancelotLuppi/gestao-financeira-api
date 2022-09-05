package com.luppi.gestaofinanceira.security;

import com.luppi.gestaofinanceira.exception.EntityNotFoundException;
import com.luppi.gestaofinanceira.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) throws EntityNotFoundException {
        return userRepository.findByUsername(username).
                orElseThrow(() -> new EntityNotFoundException("Usuario nao encontrado"));
    }
}
