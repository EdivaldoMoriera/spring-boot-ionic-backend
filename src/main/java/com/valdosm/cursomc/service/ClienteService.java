package com.valdosm.cursomc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valdosm.cursomc.domain.Cliente;
import com.valdosm.cursomc.repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    public List<Cliente> findAll(){
        return clienteRepository.findAll();

    }
}
