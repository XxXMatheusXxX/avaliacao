package com.testo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testo.entities.Cliente;
import com.testo.repository.ClienteRepository;

@Service
public class ClienteService {
	private final ClienteRepository ClienteRepository;
	

	@Autowired
	public ClienteService(ClienteRepository ClienteRepository) {
		this.ClienteRepository = ClienteRepository;
	}

	public List<Cliente> getAllClientes() {
		return ClienteRepository.findAll();
	}

	public Cliente getClienteById(Long id) {
		Optional<Cliente> Cliente = ClienteRepository.findById(id);
		return Cliente.orElse(null);
	}

	public Cliente saveCliente(Cliente Cliente) {
		return ClienteRepository.save(Cliente);
	}

	public Cliente changeCliente(Long id, Cliente changeU) {
		Optional<Cliente> existeCliente = ClienteRepository.findById(id);
		if (existeCliente.isPresent()) {
			changeU.setId(id);
			return ClienteRepository.save(changeU);
		}
		return null;
	}

	public boolean deleteCliente(Long id) {
		Optional<Cliente> existeCliente= ClienteRepository.findById(id);
		if (existeCliente.isPresent()) {
			ClienteRepository.deleteById(id);
			return true;
		}
		return false;
	}

}