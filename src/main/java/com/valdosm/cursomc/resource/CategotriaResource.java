package com.valdosm.cursomc.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.valdosm.cursomc.domain.Categoria;
import com.valdosm.cursomc.domain.dto.CategoriaDTO;
import com.valdosm.cursomc.service.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategotriaResource {
    @Autowired
    private CategoriaService categoriaService;
    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> findAll(){
        List<Categoria> list = categoriaService.fidAll();
        List<CategoriaDTO> listDto = list.stream()
        .map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
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
    //metodo put
    @PutMapping(value = "/{id}")
    public ResponseEntity<Categoria> update(@PathVariable Integer id, @RequestBody Categoria obj){
        obj = categoriaService.uppate(id, obj);
        return ResponseEntity.ok().body(obj);
    }
    //metodo delete
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    //paginação
    @GetMapping(value = "/pages")
    public ResponseEntity<Page<CategoriaDTO>>findPage( 
        @RequestParam(value = "page", defaultValue = "0") Integer page,
        @RequestParam(value = "linesPerPages", defaultValue = "24") Integer linesPerPages, 
        @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
        @RequestParam(value = "direction", defaultValue = "ASC") String direction){

        Page<Categoria> list = categoriaService.findPage(page, linesPerPages, orderBy, direction);
        Page<CategoriaDTO> listDto = list.map(obj -> new CategoriaDTO(obj));
        return ResponseEntity.ok().body(listDto);

        }

    }
    

