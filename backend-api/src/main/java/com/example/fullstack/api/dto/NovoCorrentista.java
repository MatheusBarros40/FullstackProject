package com.example.fullstack.api.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class NovoCorrentista {
    private String nome;
    private String cpf;

}
