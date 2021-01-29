package com.eofdev.repcomercial.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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

import com.eofdev.repcomercial.domain.model.Cliente;
import com.eofdev.repcomercial.domain.repository.ClienteRepository;
import com.eofdev.repcomercial.domain.service.CadastroClienteService;


@RestController
@RequestMapping("/clientes")
public class ClienteController {
	// Injeção do ProdutoRepository
	@Autowired
	private ClienteRepository clienteRepository;

	// Injeção do CadastroProduto
	@Autowired
	private CadastroClienteService cadastroCliente;

	// >> LISTAR - SELECT * ( GET ) - AÇÃO DIRETA PELO REPOSITORY - PRODUTO

	@GetMapping
	public List<Cliente> listar() {
		// consulta por parte do nome do produto
		// return produtoRepository.findByNome_produtoContaing("digitar parte nome");
		// Consulta todos
		return clienteRepository.findAll();
	}

	// >> BUSCA - SELECT ...WHERE ... com PARÂMETRO melhor a resposta ( GET ) - - AÇÃO DIRETA PELO REPOSITORY - PRODUTO
	@GetMapping("/{clienteId}")
	public ResponseEntity<Cliente> buscar(@Valid @PathVariable Long clienteId) {
		Optional<Cliente> cliente = clienteRepository.findById(clienteId);
		// verdadeiro
		if (cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		}
		// falso
		return ResponseEntity.notFound().build();
	}

	// >> ADICIONAR/CADASTRAR -- INSERT ( POST ) - - AÇÃO PELO SERVICE - PRODUTO
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente Adicionar(@Valid @RequestBody Cliente cliente) {
		return cadastroCliente.salvar(cliente);
	}

	// >> ATUALIZAR - UPDATE ( PUT ) - - AÇÃO PELO SERVICE - PRODUTO
	@PutMapping("/{clienteId}")
	public ResponseEntity<Cliente> Atualizar(@Valid @PathVariable Long clienteId, @RequestBody Cliente cliente) {
		
		// VERIFIFCAÇÃO A NÃO EXISTENCIA DO CLIENTE
		// VERDADE ... Não existe resposta...
		if (!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}

		// FALSO.. Cliente existe
		cliente.setId(clienteId);
		cliente = cadastroCliente.salvar(cliente);

		return ResponseEntity.ok(cliente);
	}

	// >>>> EXCLUIR - DELETE ( DELETE ) - - AÇÃO PELO SERVICE - PRODUTO
	@DeleteMapping("/{clienteId}")
	public ResponseEntity<Void> remover(@PathVariable Long clienteId) {

		// VERIFICA A NÃO EXISTÊNCIA DO Cliente

		// VERDADEIRO: Produto Não existe...resposta status 404
		if (!clienteRepository.existsById(clienteId)) {

			return ResponseEntity.notFound().build();
		}

		// FALSO: Produto Existe...realiza a exclusão
		cadastroCliente.excluir(clienteId);
		return ResponseEntity.noContent().build(); // noContent para resposta se conteudo no Body

	}
}