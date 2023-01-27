package com.valdosm.cursomc.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.valdosm.cursomc.domain.Pedido;
import com.valdosm.cursomc.service.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>>findAll(){
        List<Pedido> list = pedidoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/{id}")
    @GetMapping
    public ResponseEntity<Pedido> findById(@PathVariable Integer id){
        Pedido pedido = pedidoService.findById(id);
        return ResponseEntity.ok().body(pedido);
    }

    @PostMapping
    public ResponseEntity<Pedido>insert(@Valid @RequestBody Pedido obj){
        obj = pedidoService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);

    }
    
}
