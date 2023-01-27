package com.valdosm.cursomc.resource;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.valdosm.cursomc.domain.Produto;
import com.valdosm.cursomc.domain.dto.ProdutoDto;
import com.valdosm.cursomc.resource.utils.Url;
import com.valdosm.cursomc.service.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

    @GetMapping
    public ResponseEntity<List<ProdutoDto>> findAll(){
        List<Produto> list = produtoService.findAll();
        List<ProdutoDto> listDto = list.stream()
        .map(ProdutoDto::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @Autowired
    private ProdutoService produtoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Integer id){
        Produto produto = produtoService.findById(id);
        return ResponseEntity.ok().body(produto);
    }
   
    //paginação
    @GetMapping(value = "/pages")
    public ResponseEntity<Page<ProdutoDto>>findPage( 
        @RequestParam(value = "nome", defaultValue = "") String nome,
        @RequestParam(value = "categorias", defaultValue = "") String categorias,
        @RequestParam(value = "page", defaultValue = "0") Integer page,
        @RequestParam(value = "linesPerPages", defaultValue = "24") Integer linesPerPages, 
        @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
        @RequestParam(value = "direction", defaultValue = "ASC") String direction){

        String nomeDecoded = Url.decodeParam(nome);
        List<Integer> ids = Url.decoIntList(categorias);
        Page<Produto> list = produtoService.search(nomeDecoded, ids, page, linesPerPages, orderBy, direction);
        Page<ProdutoDto> listDto = list.map(t -> new ProdutoDto(t));
        return ResponseEntity.ok().body(listDto);

        }

    }
    

