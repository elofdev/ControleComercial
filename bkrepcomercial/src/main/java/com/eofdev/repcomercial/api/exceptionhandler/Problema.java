package com.eofdev.repcomercial.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Problema {

	private Integer status;
	private OffsetDateTime datahora;
	private String titulo;

	// criar um lista de campos
	private List<Campo> campos;

	// nova classe campo
	public static class Campo {
		private String campo_;
		private String mensagem;

		// Cria um construtor

		public Campo(String campo_, String mensagem) {
			super();
			this.campo_ = campo_;
			this.mensagem = mensagem;
		}

		// Get and Set

		public String getCampo_() {
			return campo_;
		}

		public void setCampo_(String campo_) {
			this.campo_ = campo_;
		}

		public String getMensagem() {
			return mensagem;
		}

		public void setMensagem(String mensagem) {
			this.mensagem = mensagem;
		}

	}

	// Get and Set classe Problema

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public OffsetDateTime getDatahora() {
		return datahora;
	}

	public void setDatahora(OffsetDateTime datahora) {
		this.datahora = datahora;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Campo> getCampos() {
		return campos;
	}

	public void setCampos(List<Campo> campos) {
		this.campos = campos;
	}

}
