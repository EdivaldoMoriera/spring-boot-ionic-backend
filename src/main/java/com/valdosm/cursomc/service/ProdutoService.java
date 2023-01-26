package com.valdosm.cursomc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.valdosm.cursomc.domain.Categoria;
import com.valdosm.cursomc.domain.Produto;
import com.valdosm.cursomc.repository.CategoriaRepository;
import com.valdosm.cursomc.repository.ProdutoRepository;
import com.valdosm.cursomc.service.exception.ObjectNotFoundException;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    public List<Produto> findAll(){
        return produtoRepository.findAll();

        
    }
     // por id
     public Produto findById(Integer id) {
        Optional<Produto> obj = produtoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado Id:" + id + ", Tipo:" + Produto.class.getName()));
    }
    public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPages, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPages, Direction.valueOf(direction), orderBy);

        List<Categoria> categorias = categoriaRepository.findAllById(ids);
        return produtoRepository.search(nome, categorias, pageRequest);


    }
    
}
