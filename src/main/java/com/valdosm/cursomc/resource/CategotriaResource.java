package com.valdosm.cursomc.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valdosm.cursomc.domain.Categoria;
import com.valdosm.cursomc.service.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategotriaResource {
    @Autowired
    private CategoriaService service;
    @GetMapping
    public ResponseEntity<List<Categoria>> findAll(){
        List<Categoria> list = service.fidAll();
        return ResponseEntity.ok().body(list);
    }
    
}
