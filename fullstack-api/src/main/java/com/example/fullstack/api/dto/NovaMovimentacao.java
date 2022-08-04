package com.example.fullstack.api.dto;

import com.example.fullstack.api.model.MovimentacaoTipo;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class NovaMovimentacao {
    private String descricao;
    private Double valor;
    private MovimentacaoTipo tipo;
    private Integer idConta;
}
