package com.luppi.gestaofinanceira.dto;

import lombok.Data;

@Data
public class UserDTO {
    Integer idUser;
    private UserGenericInfo userGeneric;
}
