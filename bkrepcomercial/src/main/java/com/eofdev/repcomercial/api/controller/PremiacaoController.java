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

import com.eofdev.repcomercial.domain.model.Premiacao;
import com.eofdev.repcomercial.domain.repository.PremiacaoRepository;
import com.eofdev.repcomercial.domain.service.CadastroPremiacaoService;


@RestController
@RequestMapping("/premiacoes")
public class PremiacaoController {
	// Injeção do ProdutoRepository
	@Autowired
	private PremiacaoRepository premiacaoRepository;

	// Injeção do CadastroProduto
	@Autowired
	private CadastroPremiacaoService cadastroPremiacao;

	// >> LISTAR - SELECT * ( GET ) - AÇÃO DIRETA PELO REPOSITORY - PRODUTO

	@GetMapping
	public List<Premiacao> listar() {
		// consulta por parte do nome do produto
		// return produtoRepository.findByNome_produtoContaing("digitar parte nome");
		// Consulta todos
		return premiacaoRepository.findAll();
	}

	// >> BUSCA - SELECT ...WHERE ... com PARÂMETRO melhor a resposta ( GET ) - - AÇÃO DIRETA PELO REPOSITORY - PRODUTO
	@GetMapping("/{premiacaoId}")
	public ResponseEntity<Premiacao> buscar(@Valid @PathVariable Long premiacaoId) {

		Optional<Premiacao> premiacao = premiacaoRepository.findById(premiacaoId);

		// verdadeiro
		if (premiacao.isPresent()) {
			return ResponseEntity.ok(premiacao.get());
		}
		// falso
		return ResponseEntity.notFound().build();

	}

	// >> ADICIONAR/CADASTRAR -- INSERT ( POST ) - - AÇÃO PELO SERVICE - PRODUTO
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Premiacao Adicionar(@Valid @RequestBody Premiacao premiacao) {
		return cadastroPremiacao.salvar(premiacao);
	}

	// >> ATUALIZAR - UPDATE ( PUT ) - - AÇÃO PELO SERVICE - PRODUTO
	@PutMapping("/{premiacaoId}")
	public ResponseEntity<Premiacao> Atualizar(@Valid @PathVariable Long premiacaoId, @RequestBody Premiacao premiacao) {
		// VERIFIFCAÇÃO A NÃO EXISTENCIA DO PRODUTO
		// VERDADE ... Não existe resposta...
		if (!premiacaoRepository.existsById(premiacaoId)) {

			return ResponseEntity.notFound().build();
		}

		// FALSO.. Produto existe
		premiacao.setId(premiacaoId);
		premiacao = cadastroPremiacao.salvar(premiacao);

		return ResponseEntity.ok(premiacao);
	}

	// >>>> EXCLUIR - DELETE ( DELETE ) - - AÇÃO PELO SERVICE - PRODUTO
	@DeleteMapping("/{premiacaoId}")
	public ResponseEntity<Void> remover(@PathVariable Long premiacaoId) {

		// VERIFICA A NÃO EXISTÊNCIA DO PRODUTO

		// VERDADEIRO: Produto Não existe...resposta status 404
		if (!premiacaoRepository.existsById(premiacaoId)) {

			return ResponseEntity.notFound().build();
		}

		// FALSO: Produto Existe...realiza a exclusão
		cadastroPremiacao.excluir(premiacaoId);
		return ResponseEntity.noContent().build(); // noContent para resposta se conteudo no Body

	}
}