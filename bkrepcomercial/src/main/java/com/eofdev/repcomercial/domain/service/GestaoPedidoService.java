package com.eofdev.repcomercial.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eofdev.repcomercial.domain.exception.NegocioException;
import com.eofdev.repcomercial.domain.model.Cliente;
import com.eofdev.repcomercial.domain.model.Pedido;
import com.eofdev.repcomercial.domain.model.StatusPedido;
import com.eofdev.repcomercial.domain.repository.ClienteRepository;
import com.eofdev.repcomercial.domain.repository.PedidoRepository;

@Service
public class GestaoPedidoService {

	// injeção do Repositorio da ordem de serviço
	@Autowired
	private PedidoRepository pedidoRepository;

	// Buscar informações do Cliente
	// injeção do Repositorio de Clientes
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	// Criar um método
	public Pedido criar(Pedido pedido) {
		//informações do cliente, busca pelo gliente.id e traz para o optional..
		Cliente cliente = clienteRepository.findById(pedido.getCliente().getId())
				.orElseThrow(()-> new NegocioException("Cliente não encontrdado!")); 
		// orElseThrow --- significa...dentro desse optional extrai para mim o cliente, prorém se estiver nulo, lança a exceção...descrita NegocioExepion
		pedido.setCliente(cliente);
		pedido.setStatus(StatusPedido.ABERTO);
		pedido.setDatasys(OffsetDateTime.now());

		return pedidoRepository.save(pedido);
	}
	
	// >>> DELETAR - DELETE
	public void excluir(Long pedidoId) {
		pedidoRepository.deleteById(pedidoId);
	}
	
	
	
	
	
	
	

}
