package com.luppi.gestaofinanceira.security;

import com.luppi.gestaofinanceira.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) throws UserPrincipalNotFoundException {
        return userRepository.findByUsername(username).get();
    }
}
