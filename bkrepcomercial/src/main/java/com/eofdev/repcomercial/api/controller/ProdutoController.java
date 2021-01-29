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

import com.eofdev.repcomercial.domain.model.Produto;
import com.eofdev.repcomercial.domain.repository.ProdutoRepository;
import com.eofdev.repcomercial.domain.service.CadastroProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	// Injeção do ProdutoRepository
	@Autowired
	private ProdutoRepository produtoRepository;

	// Injeção do CadastroProduto
	@Autowired
	private CadastroProdutoService cadastroProduto;

	// >> LISTAR - SELECT * ( GET ) - AÇÃO DIRETA PELO REPOSITORY - PRODUTO

	@GetMapping
	public List<Produto> listar() {
		// Consulta todos
		return produtoRepository.findAll();
	}

	// >> BUSCA - SELECT ...WHERE ... com PARÂMETRO melhor a resposta ( GET ) - - AÇÃO DIRETA PELO REPOSITORY - PRODUTO
	@GetMapping("/{produtoId}")
	public ResponseEntity<Produto> buscar(@Valid @PathVariable Long produtoId) {

		Optional<Produto> produto = produtoRepository.findById(produtoId);

		// verdadeiro
		if (produto.isPresent()) {
			return ResponseEntity.ok(produto.get());
		}
		// falso
		return ResponseEntity.notFound().build();

	}

	// >> ADICIONAR/CADASTRAR -- INSERT ( POST ) - - AÇÃO PELO SERVICE - PRODUTO
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto Adicionar(@Valid @RequestBody Produto produto) {
		return cadastroProduto.salvar(produto);
	}

	// >> ATUALIZAR - UPDATE ( PUT ) - - AÇÃO PELO SERVICE - PRODUTO
	@PutMapping("/{produtoId}")
	public ResponseEntity<Produto> Atualizar(@Valid @PathVariable Long produtoId, @RequestBody Produto produto) {
		// VERIFIFCAÇÃO A NÃO EXISTENCIA DO PRODUTO
		// VERDADE ... Não existe resposta...
		if (!produtoRepository.existsById(produtoId)) {

			return ResponseEntity.notFound().build();
		}

		// FALSO.. Produto existe
		produto.setId(produtoId);
		produto = cadastroProduto.salvar(produto);

		return ResponseEntity.ok(produto);
	}

	// >>>> EXCLUIR - DELETE ( DELETE ) - - AÇÃO PELO SERVICE - PRODUTO
	@DeleteMapping("/{produtoId}")
	public ResponseEntity<Void> remover(@PathVariable Long produtoId) {

		// VERIFICA A NÃO EXISTÊNCIA DO PRODUTO

		// VERDADEIRO: Produto Não existe...resposta status 404
		if (!produtoRepository.existsById(produtoId)) {

			return ResponseEntity.notFound().build();
		}

		// FALSO: Produto Existe...realiza a exclusão
		cadastroProduto.excluir(produtoId);
		return ResponseEntity.noContent().build(); // noContent para resposta se conteudo no Body

	}
}