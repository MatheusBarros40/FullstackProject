package com.example.fullstack.api.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Movimentacao {
    private Integer id;
    private LocalDateTime dataHora;
    private String descricao;
    private Double valor;
    private MovimentacaoTipo tipo;

}
