package com.testo.entities;



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
@Table(name = "itempedido")
public class Itempedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id", nullable = false)
	private Long id;
	
	@Column(name = "quantidade", nullable = false, length = 255)
	private String quantidade;
	
	@Column(name = "valor_unitario", nullable = false, length = 255)
	private String valor_unitario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="id_pedido", nullable = false)
	private Fornecedor pedido;

}