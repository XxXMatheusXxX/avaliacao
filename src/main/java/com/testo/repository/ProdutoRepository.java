package com.testo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testo.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}