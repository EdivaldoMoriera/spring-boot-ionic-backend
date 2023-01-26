package com.valdosm.cursomc.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

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
import com.valdosm.cursomc.domain.Produto;
import com.valdosm.cursomc.domain.dto.CategoriaDto;
import com.valdosm.cursomc.domain.dto.ProdutoDto;
import com.valdosm.cursomc.service.CategoriaService;
import com.valdosm.cursomc.service.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Integer id){
        Produto produto = produtoService.findById(id);
        return ResponseEntity.ok().body(produto);
    }
   
    //paginação
    @GetMapping(value = "/pages")
    public ResponseEntity<Page<CategoriaDto>>findPage( 
        @RequestParam(value = "nome", defaultValue = "") Integer nome,
        @RequestParam(value = "categorias", defaultValue = "") Integer categorias,
        @RequestParam(value = "page", defaultValue = "0") Integer page,
        @RequestParam(value = "linesPerPages", defaultValue = "24") Integer linesPerPages, 
        @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
        @RequestParam(value = "direction", defaultValue = "ASC") String direction){

        Page<Produto> list = produtoService.search(page, linesPerPages, orderBy, direction);
        Page<CategoriaDto> listDto = list.map(CategoriaDto::new);
        return ResponseEntity.ok().body(listDto);

        }

    }
    

