package com.valdosm.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valdosm.cursomc.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    
}
