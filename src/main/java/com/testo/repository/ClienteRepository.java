package com.testo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testo.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}