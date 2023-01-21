package com.valdosm.cursomc.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.valdosm.cursomc.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Transactional
    Cliente findByEmail(String email);
    
}
