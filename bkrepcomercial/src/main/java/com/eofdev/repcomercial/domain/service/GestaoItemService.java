package com.eofdev.repcomercial.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eofdev.repcomercial.domain.exception.NegocioException;
import com.eofdev.repcomercial.domain.model.Item;
import com.eofdev.repcomercial.domain.model.Pedido;
import com.eofdev.repcomercial.domain.model.Produto;
import com.eofdev.repcomercial.domain.repository.ItemRepository;
import com.eofdev.repcomercial.domain.repository.PedidoRepository;
import com.eofdev.repcomercial.domain.repository.ProdutoRepository;

@Service
public class GestaoItemService {
	// Injeção do ParcelaRepository
	@Autowired
	private ItemRepository itemRepository;

	// Injeção do ParcelaRepository
	@Autowired
	private PedidoRepository pedidoRepository;

	// Injeção do ParcelaRepository
	@Autowired
	private ProdutoRepository produtoRepository;

	// Criar um método
	public Item criar(Item item) {
		// informações da parcela, busca pelo gliente.id e traz para o optional..
		Pedido pedido = pedidoRepository.findById(item.getPedido().getId())
				.orElseThrow(() -> new NegocioException("Pedido não encontrdado!"));
		// orElseThrow --- significa...dentro desse optional extrai para mim o cliente,
		// prorém se estiver nulo, lança a exceção...descrita NegocioExepion
		item.setPedido(pedido);

		Produto produto = produtoRepository.findById(item.getProduto().getId())
				.orElseThrow(() -> new NegocioException("Pruduto não encontrdado!"));
		// orElseThrow --- significa...dentro desse optional extrai para mim o cliente,
		// prorém se estiver nulo, lança a exceção...descrita NegocioExepion
		item.setProduto(produto);
		item.setDatasys(OffsetDateTime.now());

		return itemRepository.save(item);
	}

	// >>> DELETAR - DELETE
	public void excluir(Long itemId) {
		itemRepository.deleteById(itemId);
	}

}
