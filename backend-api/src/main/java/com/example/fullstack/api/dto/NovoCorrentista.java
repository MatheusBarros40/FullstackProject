package com.example.fullstack.api.dto;

import io.swagger.oas.models.security.SecurityScheme;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class NovoCorrentista {
    private Integer id;
    private String nome;
    private String cpf;

}
