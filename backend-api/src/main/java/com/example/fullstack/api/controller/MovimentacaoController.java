package com.example.fullstack.api.controller;

import com.example.fullstack.api.dto.NovaMovimentacao;
import com.example.fullstack.api.model.Correntista;
import com.example.fullstack.api.model.Movimentacao;
import com.example.fullstack.api.repository.MovimentacaoRepository;
import com.example.fullstack.api.service.CorrentistaService;
import com.example.fullstack.api.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    @DeleteMapping("/{idConta}")
    public void deleteMovimentacao(@PathVariable("idConta") Integer idConta) {
        repository.deleteById(idConta);
    }

    @PutMapping("/{idConta}")
    private ResponseEntity<Movimentacao> save(@RequestBody Movimentacao novaMovimentacao, @PathVariable(value = "idConta") Integer idConta) {
        Optional<Movimentacao> atualMovimentacao = repository.findById(idConta);
        if(atualMovimentacao.isPresent()){
            Movimentacao movimentacao = atualMovimentacao.get();
            movimentacao.setDataHora(LocalDateTime.now());
            movimentacao.setDescricao(novaMovimentacao.getDescricao());
            movimentacao.setIdConta(novaMovimentacao.getIdConta());
            movimentacao.setTipo(novaMovimentacao.getTipo());
            repository.save(movimentacao);
            return new ResponseEntity<Movimentacao>(movimentacao, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
