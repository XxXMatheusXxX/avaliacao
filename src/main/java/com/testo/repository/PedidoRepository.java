package com.testo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testo.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}