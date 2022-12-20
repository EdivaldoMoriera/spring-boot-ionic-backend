package com.valdosm.cursomc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valdosm.cursomc.domain.Categoria;
import com.valdosm.cursomc.repository.CategoriaRepository;
import com.valdosm.cursomc.service.exception.ObjectNotFoundException;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;
    public List<Categoria> fidAll(){
        return categoriaRepository.findAll();
    }
    //por id
    public Categoria findById( Integer id){
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado Id:" + id+ ", Tipo:" +Categoria.class.getName()));       
    } 

    //inserir nova categoria metodo post
    public Categoria insert(Categoria categoria){
        return categoriaRepository.save(categoria);

    }
}
