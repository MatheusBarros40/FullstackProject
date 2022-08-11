package com.example.fullstack.api.service;

import com.example.fullstack.api.dto.NovoCorrentista;
import com.example.fullstack.api.model.Conta;
import com.example.fullstack.api.model.Correntista;
import com.example.fullstack.api.model.Movimentacao;
import com.example.fullstack.api.repository.CorrentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CorrentistaService {

    @Autowired
    private CorrentistaRepository repository;
    public void save(NovoCorrentista novoCorrentista){
        Correntista correntista = new Correntista();
        correntista.setCpf(novoCorrentista.getCpf());
        correntista.setNome(novoCorrentista.getNome());

        Conta conta = new Conta();
        conta.setSaldo(0.0);
        conta.setNumero(new Date().getTime());

        correntista.setConta(conta);
        repository.save(correntista);
    }
}
