package com.eofdev.repcomercial.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.eofdev.repcomercial.api.model.PedidoRepresentationModel;
import com.eofdev.repcomercial.domain.model.Cliente;
import com.eofdev.repcomercial.domain.model.Pedido;
import com.eofdev.repcomercial.domain.repository.PedidoRepository;
import com.eofdev.repcomercial.domain.service.GestaoPedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	// Injeção do Service -- GestaoPedido
	@Autowired
	private GestaoPedidoService gestaoPedido;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ModelMapper modelMapper;

	// Listar
	@GetMapping
	public List<Pedido> listar() {
		return pedidoRepository.findAll();
	}

	// Buscar
	@GetMapping("/{pedidoId}")
	public ResponseEntity<PedidoRepresentationModel> buscar(@PathVariable Long pedidoId) {
		Optional<Pedido> pedido = pedidoRepository.findById(pedidoId);

		if (pedido.isPresent()) {
			// Usareos ModelMapper... entidade para DTOs...transforma de uma mdelo para
			// outro...
			PedidoRepresentationModel pedidoModel = modelMapper.map(pedido.get(), PedidoRepresentationModel.class);
			return ResponseEntity.ok(pedidoModel);
		}
		return ResponseEntity.notFound().build();
	}

	// ADICIONAR: Está criando uma nova Ordem de Serviço
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Pedido Adicionar(@Valid @RequestBody Pedido pedido) {
		return gestaoPedido.criar(pedido);
	}

	// >> ATUALIZAR - UPDATE ( PUT ) - - AÇÃO PELO SERVICE - PRODUTO
	@PutMapping("/{pedidoId}")
	public ResponseEntity<Pedido> Atualizar(@Valid @PathVariable Long pedidoId, @RequestBody Pedido pedido) {

		// VERIFIFCAÇÃO A NÃO EXISTENCIA DO CLIENTE
		// VERDADE ... Não existe resposta...
		if (!pedidoRepository.existsById(pedidoId)) {
			return ResponseEntity.notFound().build();
		}

		// FALSO.. Cliente existe
		pedido.setId(pedidoId);
		pedido = gestaoPedido.criar(pedido);

		return ResponseEntity.ok(pedido);
	}

	// >>>> EXCLUIR - DELETE ( DELETE ) - - AÇÃO PELO SERVICE - PRODUTO
	@DeleteMapping("/{pedidoId}")
	public ResponseEntity<Void> remover(@PathVariable Long pedidoId) {

		// VERIFICA A NÃO EXISTÊNCIA DO Pedido

		// VERDADEIRO: Produto Não existe...resposta status 404
		if (!pedidoRepository.existsById(pedidoId)) {

			return ResponseEntity.notFound().build();
		}

		// FALSO: Produto Existe...realiza a exclusão
		gestaoPedido.excluir(pedidoId);
		return ResponseEntity.noContent().build(); // noContent para resposta se conteudo no Body

	}
}