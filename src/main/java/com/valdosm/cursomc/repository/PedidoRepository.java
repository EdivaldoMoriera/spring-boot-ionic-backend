package com.valdosm.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valdosm.cursomc.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
