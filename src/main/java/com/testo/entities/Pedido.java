package com.testo.entities;

import java.math.BigDecimal;
import java.sql.Date;

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
@Table(name = "pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id", nullable = false)
	private Long id;
	
	@Column(name = "data_pedido", nullable = false, length = 255)
	private Date data_pedido;
	
	@Column(name = "valor_total", nullable = false, precision = 10, scale =2)
	private BigDecimal valor_total;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="id_cliente", nullable = false)
	private Fornecedor cliente;

}