package com.testo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testo.entities.Fornecedor;
import com.testo.repository.FornecedorRepository;

@Service
public class FornecedorService {
	private final FornecedorRepository FornecedorRepository;
	

	@Autowired
	public FornecedorService(FornecedorRepository FornecedorRepository) {
		this.FornecedorRepository = FornecedorRepository;
	}

	public List<Fornecedor> getAllFornecedors() {
		return FornecedorRepository.findAll();
	}

	public Fornecedor getFornecedorById(Long id) {
		Optional<Fornecedor> Fornecedor = FornecedorRepository.findById(id);
		return Fornecedor.orElse(null);
	}

	public Fornecedor saveFornecedor(Fornecedor Fornecedor) {
		return FornecedorRepository.save(Fornecedor);
	}

	public Fornecedor changeFornecedor(Long id, Fornecedor changeU) {
		Optional<Fornecedor> existeFornecedor = FornecedorRepository.findById(id);
		if (existeFornecedor.isPresent()) {
			changeU.setId(id);
			return FornecedorRepository.save(changeU);
		}
		return null;
	}

	public boolean deleteFornecedor(Long id) {
		Optional<Fornecedor> existeFornecedor= FornecedorRepository.findById(id);
		if (existeFornecedor.isPresent()) {
			FornecedorRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
