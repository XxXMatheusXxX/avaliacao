package com.testo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testo.entities.Itempedido;
import com.testo.repository.ItempedidoRepository;

@Service
public class ItempedidoService {
	private final ItempedidoRepository ItempedidoRepository;
	

	@Autowired
	public ItempedidoService(ItempedidoRepository ItempedidoRepository) {
		this.ItempedidoRepository = ItempedidoRepository;
	}

	public List<Itempedido> getAllItempedidos() {
		return ItempedidoRepository.findAll();
	}

	public Itempedido getItempedidoById(Long id) {
		Optional<Itempedido> Itempedido = ItempedidoRepository.findById(id);
		return Itempedido.orElse(null);
	}

	public Itempedido saveItempedido(Itempedido Itempedido) {
		return ItempedidoRepository.save(Itempedido);
	}

	public Itempedido changeItempedido(Long id, Itempedido changeU) {
		Optional<Itempedido> existeItempedido = ItempedidoRepository.findById(id);
		if (existeItempedido.isPresent()) {
			changeU.setId(id);
			return ItempedidoRepository.save(changeU);
		}
		return null;
	}

	public boolean deleteItempedido(Long id) {
		Optional<Itempedido> existeItempedido= ItempedidoRepository.findById(id);
		if (existeItempedido.isPresent()) {
			ItempedidoRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
