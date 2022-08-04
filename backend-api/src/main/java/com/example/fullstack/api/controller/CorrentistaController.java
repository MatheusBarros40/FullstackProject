package com.example.fullstack.api.controller;

import com.example.fullstack.api.dto.NovoCorrentista;
import com.example.fullstack.api.model.Correntista;
import com.example.fullstack.api.repository.CorrentistaRepository;
import com.example.fullstack.api.service.CorrentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
