package com.eofdev.repcomercial.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eofdev.repcomercial.domain.model.Comissao;
import com.eofdev.repcomercial.domain.repository.ComissaoRepository;

@Service
public class CadastroComissaoService {
		// Injeção do ProdutoRepository
		@Autowired
		private ComissaoRepository comissaoRepository;

		// >>> SALVAR - SAVE
		public Comissao salvar(Comissao comissao) {
			comissao.setDatasys(OffsetDateTime.now());
			return comissaoRepository.save(comissao);
		}

		// >>> DELETAR - DELETE
		public void excluir(Long comissaoId) {
			comissaoRepository.deleteById(comissaoId);
		}

	}