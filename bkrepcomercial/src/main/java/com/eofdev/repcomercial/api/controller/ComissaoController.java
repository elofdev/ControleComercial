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

import com.eofdev.repcomercial.domain.model.Comissao;
import com.eofdev.repcomercial.domain.repository.ComissaoRepository;
import com.eofdev.repcomercial.domain.service.CadastroComissaoService;

@RestController
@RequestMapping("/comissoes")
public class ComissaoController {
	// Injeção do ProdutoRepository
	@Autowired
	private ComissaoRepository comissaoRepository;

	// Injeção do CadastroProduto
	@Autowired
	private CadastroComissaoService cadastroComissao;

	// >> LISTAR - SELECT * ( GET ) - AÇÃO DIRETA PELO REPOSITORY - PRODUTO

	@GetMapping
	public List<Comissao> listar() {
		// consulta por parte do nome do produto
		// return produtoRepository.findByNome_produtoContaing("digitar parte nome");
		// Consulta todos
		return comissaoRepository.findAll();
	}

	// >> BUSCA - SELECT ...WHERE ... com PARÂMETRO melhor a resposta ( GET ) - - AÇÃO DIRETA PELO REPOSITORY - PRODUTO
	@GetMapping("/{comissaoId}")
	public ResponseEntity<Comissao> buscar(@Valid @PathVariable Long comissaoId) {

		Optional<Comissao> comissao = comissaoRepository.findById(comissaoId);

		// verdadeiro
		if (comissao.isPresent()) {
			return ResponseEntity.ok(comissao.get());
		}
		// falso
		return ResponseEntity.notFound().build();

	}

	// >> ADICIONAR/CADASTRAR -- INSERT ( POST ) - - AÇÃO PELO SERVICE - PRODUTO
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Comissao Adicionar(@Valid @RequestBody Comissao comissao) {
		return cadastroComissao.salvar(comissao);
	}

	// >> ATUALIZAR - UPDATE ( PUT ) - - AÇÃO PELO SERVICE - PRODUTO
	@PutMapping("/{comissaoId}")
	public ResponseEntity<Comissao> Atualizar(@Valid @PathVariable Long comissaoId, @RequestBody Comissao comissao) {
		// VERIFIFCAÇÃO A NÃO EXISTENCIA DO PRODUTO
		// VERDADE ... Não existe resposta...
		if (!comissaoRepository.existsById(comissaoId)) {

			return ResponseEntity.notFound().build();
		}

		// FALSO.. Produto existe
		comissao.setId(comissaoId);
		comissao = cadastroComissao.salvar(comissao);

		return ResponseEntity.ok(comissao);
	}

	// >>>> EXCLUIR - DELETE ( DELETE ) - - AÇÃO PELO SERVICE - PRODUTO
	@DeleteMapping("/{comissaoId}")
	public ResponseEntity<Void> remover(@PathVariable Long comissaoId) {

		// VERIFICA A NÃO EXISTÊNCIA DO PRODUTO

		// VERDADEIRO: Produto Não existe...resposta status 404
		if (!comissaoRepository.existsById(comissaoId)) {

			return ResponseEntity.notFound().build();
		}

		// FALSO: Produto Existe...realiza a exclusão
		cadastroComissao.excluir(comissaoId);
		return ResponseEntity.noContent().build(); // noContent para resposta se conteudo no Body

	}
}