package com.valdosm.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.valdosm.cursomc.domain.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Integer>{
    
}
