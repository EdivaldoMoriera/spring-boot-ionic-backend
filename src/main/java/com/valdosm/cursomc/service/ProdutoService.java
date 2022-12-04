package com.valdosm.cursomc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.valdosm.cursomc.domain.Produto;
import com.valdosm.cursomc.repository.ProdutoRepository;

public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;
    public List<Produto> findAll(){
        return produtoRepository.findAll();

        
    }
    
}
