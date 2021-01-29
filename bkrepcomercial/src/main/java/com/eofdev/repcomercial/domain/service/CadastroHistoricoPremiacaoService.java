package com.eofdev.repcomercial.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eofdev.repcomercial.domain.model.HistoricoPremiacao;
import com.eofdev.repcomercial.domain.repository.HistoricoPremiacaoRepository;

@Service
public class CadastroHistoricoPremiacaoService {

	// Injeção do HistoricoPremiacaoRepository
	@Autowired
	private HistoricoPremiacaoRepository historicoPremiacaoRepository;

	// >>> SALVAR - SAVE
	public HistoricoPremiacao salvar(HistoricoPremiacao historicoPremiacao) {
		historicoPremiacao.setDatasys(OffsetDateTime.now());
		return historicoPremiacaoRepository.save(historicoPremiacao);
	}

	// >>> DELETAR - DELETE
	public void excluir(Long historicoPremiacaoId) {
		historicoPremiacaoRepository.deleteById(historicoPremiacaoId);
	}

}
