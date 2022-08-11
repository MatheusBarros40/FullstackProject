package com.example.fullstack.api.repository;

import com.example.fullstack.api.model.Correntista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CorrentistaRepository extends JpaRepository<Correntista, Integer> {

}
