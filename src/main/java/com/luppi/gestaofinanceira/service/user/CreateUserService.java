package com.luppi.gestaofinanceira.service.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luppi.gestaofinanceira.dto.UserCreateDTO;
import com.luppi.gestaofinanceira.dto.UserDTO;
import com.luppi.gestaofinanceira.entity.UserEntity;
import com.luppi.gestaofinanceira.enums.OfficeEnum;
import com.luppi.gestaofinanceira.repository.OfficeRepository;
import com.luppi.gestaofinanceira.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CreateUserService {
    private final UserRepository userRepository;
    private final OfficeRepository officeRepository;
    private final Argon2PasswordEncoder passwordEncoder;
    private final ObjectMapper objectMapper;

    public UserDTO createUser(UserCreateDTO userCreateDTO) {
        UserEntity userEntity = objectMapper.convertValue(userCreateDTO, UserEntity.class);
        userEntity.setOffices(Set.of(officeRepository.findById(OfficeEnum.USER.ordinal()).get()));
        userEntity.setPassword(passwordEncoder.encode(userCreateDTO.getPassword()));
         userEntity = userRepository.save(userEntity);
         return objectMapper.convertValue(userEntity, UserDTO.class);
    }
}
