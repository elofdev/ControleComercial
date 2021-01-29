package com.eofdev.repcomercial.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eofdev.repcomercial.domain.model.HistoricoComissao;
import com.eofdev.repcomercial.domain.repository.HistoricoComissaoRepository;

@Service
public class CadastroHistoricoComissaoService {

	// Injeção do HistoricoComissaoRepository
	@Autowired
	private HistoricoComissaoRepository historicoComissaoRepository;

	// >>> SALVAR - SAVE
	public HistoricoComissao salvar(HistoricoComissao historicoComissao) {
		historicoComissao.setDatasys(OffsetDateTime.now());
		return historicoComissaoRepository.save(historicoComissao);
	}

	// >>> DELETAR - DELETE
	public void excluir(Long historicoComissaoId) {
		historicoComissaoRepository.deleteById(historicoComissaoId);
	}
}
