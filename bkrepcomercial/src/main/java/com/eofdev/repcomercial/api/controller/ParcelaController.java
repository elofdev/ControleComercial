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

import com.eofdev.repcomercial.api.model.ParcelaRepresentationModel;
import com.eofdev.repcomercial.api.model.PedidoRepresentationModel;
import com.eofdev.repcomercial.domain.model.Parcela;
import com.eofdev.repcomercial.domain.model.Pedido;
import com.eofdev.repcomercial.domain.repository.ParcelaRepository;
import com.eofdev.repcomercial.domain.repository.PedidoRepository;
import com.eofdev.repcomercial.domain.service.GestaoParcelaService;
import com.eofdev.repcomercial.domain.service.GestaoPedidoService;

@RestController
@RequestMapping("/parcelas")
public class ParcelaController {

	// Injeção do Service -- GestaoOarcelaService
	@Autowired
	private GestaoParcelaService gestaoParcela;

	@Autowired
	private ParcelaRepository parcelaRepository;

	@Autowired
	private ModelMapper modelMapper;

	// Listar
	@GetMapping
	public List<Parcela> listar() {
		return parcelaRepository.findAll();
	}

	// Buscar
	@GetMapping("/{parcelaId}")
	public ResponseEntity<ParcelaRepresentationModel> buscar(@PathVariable Long parcelaId) {
		Optional<Parcela> parcela = parcelaRepository.findById(parcelaId);

		if (parcela.isPresent()) {
			// Usareos ModelMapper... entidade para DTOs...transforma de uma mdelo para
			// outro...
			ParcelaRepresentationModel parcelaModel = modelMapper.map(parcela.get(), ParcelaRepresentationModel.class);
			return ResponseEntity.ok(parcelaModel);
		}
		return ResponseEntity.notFound().build();
	}

	// ADICIONAR: Está criando uma nova Ordem de Serviço
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Parcela Adicionar(@Valid @RequestBody Parcela parcela) {
		return gestaoParcela.criar(parcela);
	}

	// >> ATUALIZAR - UPDATE ( PUT ) - - AÇÃO PELO SERVICE - PRODUTO
	@PutMapping("/{parcelaId}")
	public ResponseEntity<Parcela> Atualizar(@Valid @PathVariable Long parcelaId, @RequestBody Parcela parcela) {

		// VERIFIFCAÇÃO A NÃO EXISTENCIA DO CLIENTE
		// VERDADE ... Não existe resposta...
		if (!parcelaRepository.existsById(parcelaId)) {
			return ResponseEntity.notFound().build();
		}

		// FALSO.. Cliente existe
		parcela.setId(parcelaId);
		parcela = gestaoParcela.criar(parcela);

		return ResponseEntity.ok(parcela);
	}

	// >>>> EXCLUIR - DELETE ( DELETE ) - - AÇÃO PELO SERVICE - PRODUTO
	@DeleteMapping("/{parcelaId}")
	public ResponseEntity<Void> remover(@PathVariable Long parcelaId) {

		// VERIFICA A NÃO EXISTÊNCIA DO Pedido

		// VERDADEIRO: Produto Não existe...resposta status 404
		if (!parcelaRepository.existsById(parcelaId)) {

			return ResponseEntity.notFound().build();
		}

		// FALSO: Produto Existe...realiza a exclusão
		gestaoParcela.excluir(parcelaId);
		return ResponseEntity.noContent().build(); // noContent para resposta se conteudo no Body

	}
}