package com.valdosm.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valdosm.cursomc.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
    
}
