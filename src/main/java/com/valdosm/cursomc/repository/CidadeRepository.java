package com.valdosm.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valdosm.cursomc.domain.Cidade;

public interface CidadeRepository  extends JpaRepository<Cidade, Integer>{
    
}
