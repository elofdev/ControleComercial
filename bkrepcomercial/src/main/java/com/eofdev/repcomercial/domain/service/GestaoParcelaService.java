package com.eofdev.repcomercial.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eofdev.repcomercial.domain.exception.NegocioException;
import com.eofdev.repcomercial.domain.model.Cliente;
import com.eofdev.repcomercial.domain.model.Parcela;
import com.eofdev.repcomercial.domain.model.Pedido;
import com.eofdev.repcomercial.domain.model.StatusParcela;
import com.eofdev.repcomercial.domain.repository.ParcelaRepository;
import com.eofdev.repcomercial.domain.repository.PedidoRepository;

@Service
public class GestaoParcelaService {

	// Injeção do ParcelaRepository
	@Autowired
	private ParcelaRepository parcelaRepository;
	
	
	// Injeção do ParcelaRepository
		@Autowired
		private PedidoRepository pedidoRepository;
		

	// Criar um método
	public Parcela criar(Parcela parcela) {
		//informações da parcela, busca pelo gliente.id e traz para o optional..
		Pedido pedido = pedidoRepository.findById(parcela.getPedido().getId())
				.orElseThrow(()-> new NegocioException("Pedido não encontrdado!")); 
		// orElseThrow --- significa...dentro desse optional extrai para mim o cliente, prorém se estiver nulo, lança a exceção...descrita NegocioExepion
		parcela.setPedido(pedido);
		parcela.setStatus(StatusParcela.ABERTA);
		parcela.setDatasys(OffsetDateTime.now());

		return parcelaRepository.save(parcela);
	}

	// >>> DELETAR - DELETE
	public void excluir(Long parcelaId) {
		parcelaRepository.deleteById(parcelaId);
	}
}
