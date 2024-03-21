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

import com.testo.entities.Fornecedor;
import com.testo.services.FornecedorService;

@RestController
@RequestMapping("/Fornecedor")
public class FornecedorController {

	private final FornecedorService FornecedorService;

	@Autowired
	public FornecedorController(FornecedorService FornecedorService) {
		this.FornecedorService = FornecedorService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Fornecedor> buscaFornecedorControlId(@PathVariable Long id) {
		Fornecedor Fornecedor = FornecedorService.getFornecedorById(id);
		if (Fornecedor != null) {
			return ResponseEntity.ok(Fornecedor);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Fornecedor>> buscaTodosFornecedorsControl() {
		List<Fornecedor> Fornecedors = FornecedorService.getAllFornecedors();
		return ResponseEntity.ok(Fornecedors);
	}

	@PostMapping("/")
	public ResponseEntity<Fornecedor> saveFornecedorsControl(@RequestBody Fornecedor Fornecedor) {
		Fornecedor saveFornecedor = FornecedorService.saveFornecedor(Fornecedor);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveFornecedor);
	}

	@PostMapping("/{id}")
	public ResponseEntity<Fornecedor> alteraFornecedorControl(@PathVariable Long id, @RequestBody Fornecedor Fornecedor) {
		Fornecedor alteraFornecedor = FornecedorService.changeFornecedor(id, Fornecedor);

		if (alteraFornecedor != null) {
			return ResponseEntity.ok(Fornecedor);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteFornecedorControl(@PathVariable Long id) {
		boolean delete = FornecedorService.deleteFornecedor(id);
		if (delete) {
			return ResponseEntity.ok().body("O Fornecedor foi excluido com o sucesso");
		} else {
			return ResponseEntity.notFound().build();
		}

	}

}
