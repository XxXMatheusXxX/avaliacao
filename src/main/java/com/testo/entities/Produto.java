package com.testo.entities;



import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "produto")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id", nullable = false)
	private Long id;
	
	@Column(name = "categoria", nullable = false, length = 255)
	private String categoria;
	
	@Column(name = "descricao", nullable = false, length = 255)
	private String descricao;
	
	@Column(name = "nome", nullable = false, length = 255)
	private String nome;
	
	@Column(name = "preco", nullable = false, precision = 10, scale =2)
	private BigDecimal preco;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="id_fornecedor", nullable = false)
	private Fornecedor fornecedor;
}
