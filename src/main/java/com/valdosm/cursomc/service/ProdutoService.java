package com.valdosm.cursomc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valdosm.cursomc.domain.Produto;
import com.valdosm.cursomc.repository.ProdutoRepository;
import com.valdosm.cursomc.service.exception.ObjectNotFoundException;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;
    public List<Produto> findAll(){
        return produtoRepository.findAll();

        
    }
     // por id
     public Produto findById(Integer id) {
        Optional<Produto> obj = produtoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado Id:" + id + ", Tipo:" + Produto.class.getName()));
    }
    
}
