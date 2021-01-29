package com.eofdev.repcomercial.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eofdev.repcomercial.domain.model.Produto;
import com.eofdev.repcomercial.domain.repository.ProdutoRepository;

@Service
public class CadastroProdutoService {
	// Injeção do ProdutoRepository
	@Autowired
	private ProdutoRepository produtoRepository;

	// >>> SALVAR - SAVE
	public Produto salvar(Produto produto) {
		produto.setDatasys(OffsetDateTime.now());
		return produtoRepository.save(produto);
	}

	// >>> DELETAR - DELETE
	public void excluir(Long produtoId) {
		produtoRepository.deleteById(produtoId);
	}

}