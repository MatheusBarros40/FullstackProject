package com.example.fullstack.api.controller;

import com.example.fullstack.api.dto.NovoCorrentista;
import com.example.fullstack.api.model.Correntista;
import com.example.fullstack.api.repository.CorrentistaRepository;
import com.example.fullstack.api.service.CorrentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {

    @Autowired
    private CorrentistaRepository repository;

    @Autowired
    private CorrentistaService service;

    @GetMapping
    public List<Correntista> findAll(){
        return repository.findAll();
    }

    @PostMapping
    public void save(@RequestBody NovoCorrentista correntista){
        service.save(correntista);
    }

    @DeleteMapping("/{id}")
    public void deleteCorrentista(@PathVariable Integer id) {
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    private ResponseEntity<Correntista> save(@RequestBody Correntista novoCorrentista, @PathVariable(value = "id") Integer id) {
        Optional<Correntista> atualCorrentista = repository.findById(id);
        if(atualCorrentista.isPresent()){
            Correntista correntista = atualCorrentista.get();
            correntista.setCpf(novoCorrentista.getCpf());
            correntista.setNome(novoCorrentista.getNome());
            repository.save(correntista);
            return new ResponseEntity<Correntista>(correntista, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
