package com.valdosm.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.valdosm.cursomc.domain.Endereco;


public interface EnderecoRepository extends JpaRepository<Endereco, Integer>  {
    
}
