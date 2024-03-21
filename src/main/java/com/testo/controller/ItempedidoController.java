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

import com.testo.entities.Itempedido;
import com.testo.services.ItempedidoService;

@RestController
@RequestMapping("/Itempedido")
public class ItempedidoController {

	private final ItempedidoService ItempedidoService;

	@Autowired
	public ItempedidoController(ItempedidoService ItempedidoService) {
		this.ItempedidoService = ItempedidoService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Itempedido> buscaItempedidoControlId(@PathVariable Long id) {
		Itempedido Itempedido = ItempedidoService.getItempedidoById(id);
		if (Itempedido != null) {
			return ResponseEntity.ok(Itempedido);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Itempedido>> buscaTodosItempedidosControl() {
		List<Itempedido> Itempedidos = ItempedidoService.getAllItempedidos();
		return ResponseEntity.ok(Itempedidos);
	}

	@PostMapping("/")
	public ResponseEntity<Itempedido> saveItempedidosControl(@RequestBody Itempedido Itempedido) {
		Itempedido saveItempedido = ItempedidoService.saveItempedido(Itempedido);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveItempedido);
	}

	@PostMapping("/{id}")
	public ResponseEntity<Itempedido> alteraItempedidoControl(@PathVariable Long id, @RequestBody Itempedido Itempedido) {
		Itempedido alteraItempedido = ItempedidoService.changeItempedido(id, Itempedido);

		if (alteraItempedido != null) {
			return ResponseEntity.ok(Itempedido);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteItempedidoControl(@PathVariable Long id) {
		boolean delete = ItempedidoService.deleteItempedido(id);
		if (delete) {
			return ResponseEntity.ok().body("O Itempedido foi excluido com o sucesso");
		} else {
			return ResponseEntity.notFound().build();
		}

	}

}