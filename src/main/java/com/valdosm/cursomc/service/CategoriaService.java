package com.valdosm.cursomc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valdosm.cursomc.domain.Categoria;
import com.valdosm.cursomc.repository.CategoriaRepository;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repository;
    public List<Categoria> fidAll(){
        return repository.findAll();
    }
    
}
