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

import com.eofdev.repcomercial.api.model.ItemRepresentationModel;
import com.eofdev.repcomercial.api.model.ParcelaRepresentationModel;
import com.eofdev.repcomercial.domain.model.Item;
import com.eofdev.repcomercial.domain.model.Parcela;
import com.eofdev.repcomercial.domain.repository.ItemRepository;
import com.eofdev.repcomercial.domain.repository.ParcelaRepository;
import com.eofdev.repcomercial.domain.service.GestaoItemService;
import com.eofdev.repcomercial.domain.service.GestaoParcelaService;

@RestController
@RequestMapping("/itens")
public class ItemController {

	// Injeção do Service -- GestaoOarcelaService
		@Autowired
		private GestaoItemService gestaoItem;

		@Autowired
		private ItemRepository itemRepository;

		@Autowired
		private ModelMapper modelMapper;

		// Listar
		@GetMapping
		public List<Item> listar() {
			return itemRepository.findAll();
		}

		// Buscar
		@GetMapping("/{itemId}")
		public ResponseEntity<ItemRepresentationModel> buscar(@PathVariable Long itemId) {
			Optional<Item> item = itemRepository.findById(itemId);

			if (item.isPresent()) {
				// Usareos ModelMapper... entidade para DTOs...transforma de uma mdelo para
				// outro...
				ItemRepresentationModel itemModel = modelMapper.map(item.get(), ItemRepresentationModel.class);
				return ResponseEntity.ok(itemModel);
			}
			return ResponseEntity.notFound().build();
		}

		// ADICIONAR: Está criando uma nova Ordem de Serviço
		@PostMapping
		@ResponseStatus(HttpStatus.CREATED)
		public Item Adicionar(@Valid @RequestBody Item item) {
			return gestaoItem.criar(item);
		}

		// >> ATUALIZAR - UPDATE ( PUT ) - - AÇÃO PELO SERVICE - PRODUTO
		@PutMapping("/{itemId}")
		public ResponseEntity<Item> Atualizar(@Valid @PathVariable Long itemId, @RequestBody Item item) {

			// VERIFIFCAÇÃO A NÃO EXISTENCIA DO CLIENTE
			// VERDADE ... Não existe resposta...
			if (!itemRepository.existsById(itemId)) {
				return ResponseEntity.notFound().build();
			}

			// FALSO.. Cliente existe
			item.setId(itemId);
			item = gestaoItem.criar(item);

			return ResponseEntity.ok(item);
		}

		// >>>> EXCLUIR - DELETE ( DELETE ) - - AÇÃO PELO SERVICE - PRODUTO
		@DeleteMapping("/{itemId}")
		public ResponseEntity<Void> remover(@PathVariable Long itemId) {

			// VERIFICA A NÃO EXISTÊNCIA DO Pedido

			// VERDADEIRO: Produto Não existe...resposta status 404
			if (!itemRepository.existsById(itemId)) {

				return ResponseEntity.notFound().build();
			}

			// FALSO: Produto Existe...realiza a exclusão
			gestaoItem.excluir(itemId);
			return ResponseEntity.noContent().build(); // noContent para resposta se conteudo no Body

		}
}