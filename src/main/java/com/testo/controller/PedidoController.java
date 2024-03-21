package com.testo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testo.entities.Pedido;
import com.testo.services.PedidoService;

@RestController
@RequestMapping("/Pedido")
public class PedidoController {

	private final PedidoService PedidoService;

	@Autowired
	public PedidoController(PedidoService PedidoService) {
		this.PedidoService = PedidoService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pedido> buscaPedidoControlId(@PathVariable Long id) {
		Pedido Pedido = PedidoService.getPedidoById(id);
		if (Pedido != null) {
			return ResponseEntity.ok(Pedido);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Pedido>> buscaTodosPedidosControl() {
		List<Pedido> Pedidos = PedidoService.getAllPedidos();
		return ResponseEntity.ok(Pedidos);
	}

	@PostMapping("/")
	public ResponseEntity<Pedido> savePedidosControl(@RequestBody Pedido Pedido) {
		Pedido savePedido = PedidoService.savePedido(Pedido);
		return ResponseEntity.status(HttpStatus.CREATED).body(savePedido);
	}

	@PostMapping("/{id}")
	public ResponseEntity<Pedido> alteraPedidoControl(@PathVariable Long id, @RequestBody Pedido Pedido) {
		Pedido alteraPedido = PedidoService.changePedido(id, Pedido);

		if (alteraPedido != null) {
			return ResponseEntity.ok(Pedido);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePedidoControl(@PathVariable Long id) {
		boolean delete = PedidoService.deletePedido(id);
		if (delete) {
			return ResponseEntity.ok().body("O Pedido foi excluido com o sucesso");
		} else {
			return ResponseEntity.notFound().build();
		}

	}

}