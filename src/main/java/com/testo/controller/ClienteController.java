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

import com.testo.entities.Cliente;
import com.testo.services.ClienteService;

@RestController
@RequestMapping("/Cliente")
public class ClienteController {

	private final ClienteService ClienteService;

	@Autowired
	public ClienteController(ClienteService ClienteService) {
		this.ClienteService = ClienteService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscaClienteControlId(@PathVariable Long id) {
		Cliente Cliente = ClienteService.getClienteById(id);
		if (Cliente != null) {
			return ResponseEntity.ok(Cliente);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Cliente>> buscaTodosClientesControl() {
		List<Cliente> Clientes = ClienteService.getAllClientes();
		return ResponseEntity.ok(Clientes);
	}

	@PostMapping("/")
	public ResponseEntity<Cliente> saveClientesControl(@RequestBody Cliente Cliente) {
		Cliente saveCliente = ClienteService.saveCliente(Cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveCliente);
	}

	@PostMapping("/{id}")
	public ResponseEntity<Cliente> alteraClienteControl(@PathVariable Long id, @RequestBody Cliente Cliente) {
		Cliente alteraCliente = ClienteService.changeCliente(id, Cliente);

		if (alteraCliente != null) {
			return ResponseEntity.ok(Cliente);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteClienteControl(@PathVariable Long id) {
		boolean delete = ClienteService.deleteCliente(id);
		if (delete) {
			return ResponseEntity.ok().body("O Cliente foi excluido com o sucesso");
		} else {
			return ResponseEntity.notFound().build();
		}

	}

}