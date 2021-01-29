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

import com.eofdev.repcomercial.domain.model.HistoricoComissao;
import com.eofdev.repcomercial.domain.repository.HistoricoComissaoRepository;
import com.eofdev.repcomercial.domain.service.CadastroHistoricoComissaoService;

@RestController
@RequestMapping("/historico-comissoes")
public class HistoricoComissaoController {

	// << Injeção do HistoricoComissaoRepository >>
	@Autowired
	private HistoricoComissaoRepository historicoComissaoRepository;

	// << Injeção do ParcelaComissaoService >>
	@Autowired
	private CadastroHistoricoComissaoService cadastroHistoricoComissao;

	// ***** LISTAR - SELECT * ( GET ) - AÇÃO DIRETA PELO REPOSITORY - Item
	@GetMapping
	public List<HistoricoComissao> listar() {

		// Consulta todos os Pedidos
		return historicoComissaoRepository.findAll();
	}

	// ***** BUSCA - SELECT ...WHERE ... com PARÂMETRO melhor a resposta ( GET ) - -
	// AÇÃO DIRETA PELO REPOSITORY - PRODUTO
	@GetMapping("/{historico-comissaoId}")
	public ResponseEntity<HistoricoComissao> buscar(@Valid @PathVariable Long historicoComissaoId) {

		// Lista Optional de Pedidos
		Optional<HistoricoComissao> historicoComissao = historicoComissaoRepository.findById(historicoComissaoId);

		// Resultado: verdadeiro ou seja Pedido Existe
		if (historicoComissao.isPresent()) {
			return ResponseEntity.ok(historicoComissao.get());
		}
		// falso
		return ResponseEntity.notFound().build();

	}

	// ***** ADICIONAR/CADASTRAR -- INSERT ( POST ) - - AÇÃO PELO SERVICE - PRODUTO
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public HistoricoComissao Adicionar(@Valid @RequestBody HistoricoComissao historicoComissao) {
		return cadastroHistoricoComissao.salvar(historicoComissao);
	}

	// ***** ATUALIZAR - UPDATE ( PUT ) - - AÇÃO PELO SERVICE - Pedido
	@PutMapping("/{historico-comissaoId}")
	public ResponseEntity<HistoricoComissao> Atualizar(@Valid @PathVariable Long historicoComissaoId, @RequestBody HistoricoComissao historicoComissao) {

		// VERIFIFCAÇÃO

		if (!historicoComissaoRepository.existsById(historicoComissaoId)) {

			// Resultado: Verdadeiro ... Item NÃO existe
			return ResponseEntity.notFound().build();
		}

		// Resultado: Falso.... Item existe .... Realiza a ação de alteração e traz
		// resultado o cordpo do pedido.
		historicoComissao.setId(historicoComissaoId);
		historicoComissao = cadastroHistoricoComissao.salvar(historicoComissao);

		return ResponseEntity.ok(historicoComissao);
	}

	// *** EXCLUIR - DELETE ( DELETE ) - - AÇÃO PELO SERVICE
	@DeleteMapping("/{historico-comissaoId}")
	public ResponseEntity<Void> remover(@PathVariable Long historicoComissaoId) {

		// Verifica Pedido Não Existe?

		if (!historicoComissaoRepository.existsById(historicoComissaoId)) {

			// Resultado: VERDADEIRO: NÃO EXISTE...resposta status 404
			return ResponseEntity.notFound().build();
		}

		// Resultado: FALSO (SIM EXISTE ...realiza a exclusão e retorna mensagem VAZIA)
		cadastroHistoricoComissao.excluir(historicoComissaoId);
		return ResponseEntity.noContent().build(); // noContent para resposta se conteudo no Body

	}
}