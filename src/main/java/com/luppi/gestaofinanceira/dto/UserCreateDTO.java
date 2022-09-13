package com.luppi.gestaofinanceira.dto;

import lombok.Data;

@Data
public class UserCreateDTO {
    private UserGenericInfo userGenericInfo;
    private String password;
}
