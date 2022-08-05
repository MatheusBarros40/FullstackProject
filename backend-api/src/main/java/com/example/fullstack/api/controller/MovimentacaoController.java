package com.example.fullstack.api.controller;

import com.example.fullstack.api.dto.NovaMovimentacao;
import com.example.fullstack.api.model.Movimentacao;
import com.example.fullstack.api.repository.MovimentacaoRepository;
import com.example.fullstack.api.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoRepository repository;

    @Autowired
    private MovimentacaoService service;

    @GetMapping
    public List<Movimentacao> findAll(){
        return repository.findAll();
    }

    @GetMapping("/{idConta}")
    public List<Movimentacao> findAll(@PathVariable("idConta") Integer idConta){
        return repository.findByIdConta(idConta);
    }

    @PostMapping
    public void save(@RequestBody NovaMovimentacao movimentacao){
        service.save(movimentacao);
    }
}
