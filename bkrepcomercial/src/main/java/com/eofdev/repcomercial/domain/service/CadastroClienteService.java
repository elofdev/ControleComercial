package com.eofdev.repcomercial.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eofdev.repcomercial.domain.model.Cliente;
import com.eofdev.repcomercial.domain.repository.ClienteRepository;

@Service
public class CadastroClienteService {
	// Injeção do ProdutoRepository
	@Autowired
	private ClienteRepository clienteRepository;

	// >>> SALVAR - SAVE
	public Cliente salvar(Cliente cliente) {
		cliente.setDatasys(OffsetDateTime.now());
		return clienteRepository.save(cliente);
	}

	// >>> DELETAR - DELETE
	public void excluir(Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}

}