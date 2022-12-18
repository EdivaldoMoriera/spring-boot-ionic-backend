package com.valdosm.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valdosm.cursomc.domain.Pagamento;

public interface PagamentoRepository  extends JpaRepository<Pagamento, Integer>{
    
}
