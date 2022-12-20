package com.valdosm.cursomc.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.valdosm.cursomc.domain.Categoria;
import com.valdosm.cursomc.service.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategotriaResource {
    @Autowired
    private CategoriaService categoriaService;
    @GetMapping
    public ResponseEntity<List<Categoria>> findAll(){
        List<Categoria> list = categoriaService.fidAll();
        return ResponseEntity.ok().body(list);
    }
    @RequestMapping(value = "/{id}")
    @GetMapping
    public ResponseEntity<Categoria> findById(@PathVariable Integer id){
        Categoria categoria = categoriaService.findById(id);
        return ResponseEntity.ok().body(categoria);
    }
    //inserir nova categoria metodo post
    @PostMapping
    public ResponseEntity<Categoria>insert( @RequestBody Categoria categoria){
        categoria = categoriaService.insert(categoria);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }
    
}
