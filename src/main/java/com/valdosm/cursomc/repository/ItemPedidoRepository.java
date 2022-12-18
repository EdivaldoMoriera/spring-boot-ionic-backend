package com.valdosm.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valdosm.cursomc.domain.ItemPedido;
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer>{
    
}
