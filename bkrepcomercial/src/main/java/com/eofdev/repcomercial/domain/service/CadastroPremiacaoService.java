package com.eofdev.repcomercial.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eofdev.repcomercial.domain.model.Premiacao;
import com.eofdev.repcomercial.domain.repository.PremiacaoRepository;

@Service
public class CadastroPremiacaoService {

	// Injeção do ProdutoRepository
	@Autowired
	private PremiacaoRepository premiacaoRepository;

	// >>> SALVAR - SAVE
	public Premiacao salvar(Premiacao premiacao) {
		premiacao.setDatasys(OffsetDateTime.now());
		return premiacaoRepository.save(premiacao);
	}

	// >>> DELETAR - DELETE
	public void excluir(Long premiacaoId) {
		premiacaoRepository.deleteById(premiacaoId);
	}

}