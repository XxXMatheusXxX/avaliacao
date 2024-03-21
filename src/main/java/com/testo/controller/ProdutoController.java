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

import com.testo.entities.Produto;
import com.testo.services.ProdutoService;

@RestController
@RequestMapping("/Produto")
public class ProdutoController {

	private final ProdutoService ProdutoService;

	@Autowired
	public ProdutoController(ProdutoService ProdutoService) {
		this.ProdutoService = ProdutoService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> buscaProdutoControlId(@PathVariable Long id) {
		Produto Produto = ProdutoService.getProdutoById(id);
		if (Produto != null) {
			return ResponseEntity.ok(Produto);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Produto>> buscaTodosProdutosControl() {
		List<Produto> Produtos = ProdutoService.getAllProdutos();
		return ResponseEntity.ok(Produtos);
	}

	@PostMapping("/")
	public ResponseEntity<Produto> saveProdutosControl(@RequestBody Produto Produto) {
		Produto saveProduto = ProdutoService.saveProduto(Produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveProduto);
	}

	@PostMapping("/{id}")
	public ResponseEntity<Produto> alteraProdutoControl(@PathVariable Long id, @RequestBody Produto Produto) {
		Produto alteraProduto = ProdutoService.changeProduto(id, Produto);

		if (alteraProduto != null) {
			return ResponseEntity.ok(Produto);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProdutoControl(@PathVariable Long id) {
		boolean delete = ProdutoService.deleteProduto(id);
		if (delete) {
			return ResponseEntity.ok().body("O Produto foi excluido com o sucesso");
		} else {
			return ResponseEntity.notFound().build();
		}

	}

}
