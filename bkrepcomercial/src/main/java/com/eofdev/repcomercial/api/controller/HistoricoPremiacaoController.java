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


import com.eofdev.repcomercial.domain.model.HistoricoPremiacao;
import com.eofdev.repcomercial.domain.repository.HistoricoPremiacaoRepository;
import com.eofdev.repcomercial.domain.service.CadastroHistoricoPremiacaoService;

@RestController
@RequestMapping("/historico-premiacoes")
public class HistoricoPremiacaoController {

	// << Injeção do HistoricoPremiacaoRepository >>
	@Autowired
	private HistoricoPremiacaoRepository historicoPremiacaoRepository;

	// << Injeção do ParcelaComissaoService >>
	@Autowired
	private CadastroHistoricoPremiacaoService cadastroHistoricoPremiacao;

	// ***** LISTAR - SELECT * ( GET ) - AÇÃO DIRETA PELO REPOSITORY - Item
	@GetMapping
	public List<HistoricoPremiacao> listar() {

		// Consulta todos os Pedidos
		return historicoPremiacaoRepository.findAll();
	}

	// ***** BUSCA - SELECT ...WHERE ... com PARÂMETRO melhor a resposta ( GET ) - -
	// AÇÃO DIRETA PELO REPOSITORY - PRODUTO
	@GetMapping("/{historico-premiacaoId}")
	public ResponseEntity<HistoricoPremiacao> buscar(@Valid @PathVariable Long historicoPremiacaoId) {

		// Lista Optional de Pedidos
		Optional<HistoricoPremiacao> historicoPremiacao = historicoPremiacaoRepository.findById(historicoPremiacaoId);

		// Resultado: verdadeiro ou seja Pedido Existe
		if (historicoPremiacao.isPresent()) {
			return ResponseEntity.ok(historicoPremiacao.get());
		}
		// falso
		return ResponseEntity.notFound().build();

	}

	// ***** ADICIONAR/CADASTRAR -- INSERT ( POST ) - - AÇÃO PELO SERVICE - PRODUTO
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public HistoricoPremiacao Adicionar(@Valid @RequestBody HistoricoPremiacao historicoPremiacao) {
		return cadastroHistoricoPremiacao.salvar(historicoPremiacao);
	}

	// ***** ATUALIZAR - UPDATE ( PUT ) - - AÇÃO PELO SERVICE - Pedido
	@PutMapping("/{historico-premiacaooId}")
	public ResponseEntity<HistoricoPremiacao> Atualizar(@Valid @PathVariable Long historicoPremiacaoId, @RequestBody HistoricoPremiacao historicoPremiacao) {

		// VERIFIFCAÇÃO

		if (!historicoPremiacaoRepository.existsById(historicoPremiacaoId)) {

			// Resultado: Verdadeiro ... Item NÃO existe
			return ResponseEntity.notFound().build();
		}

		// Resultado: Falso.... Item existe .... Realiza a ação de alteração e traz
		// resultado o cordpo do pedido.
		historicoPremiacao.setId(historicoPremiacaoId);
		historicoPremiacao = cadastroHistoricoPremiacao.salvar(historicoPremiacao);

		return ResponseEntity.ok(historicoPremiacao);
	}

	// *** EXCLUIR - DELETE ( DELETE ) - - AÇÃO PELO SERVICE
	@DeleteMapping("/{historico-comissaoId}")
	public ResponseEntity<Void> remover(@PathVariable Long historicoPremiacaoId) {

		// Verifica Pedido Não Existe?

		if (!historicoPremiacaoRepository.existsById(historicoPremiacaoId)) {

			// Resultado: VERDADEIRO: NÃO EXISTE...resposta status 404
			return ResponseEntity.notFound().build();
		}

		// Resultado: FALSO (SIM EXISTE ...realiza a exclusão e retorna mensagem VAZIA)
		cadastroHistoricoPremiacao.excluir(historicoPremiacaoId);
		return ResponseEntity.noContent().build(); // noContent para resposta se conteudo no Body

	}
}