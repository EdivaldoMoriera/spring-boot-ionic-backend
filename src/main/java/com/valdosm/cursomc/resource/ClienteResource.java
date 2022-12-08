package com.valdosm.cursomc.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valdosm.cursomc.domain.Cliente;
import com.valdosm.cursomc.service.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
    @Autowired
    private ClienteService clienteService;
    @GetMapping
    public ResponseEntity<List<Cliente>>findAll(){
        List<Cliente> list =clienteService.findAll();
        return ResponseEntity.ok().body(list);
        
    }
}
