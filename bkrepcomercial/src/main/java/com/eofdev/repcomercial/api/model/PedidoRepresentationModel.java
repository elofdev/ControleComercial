package com.eofdev.repcomercial.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class PedidoRepresentationModel {
	/* Oque queremos que aparece para o usuário, quando ele fizer uma busca(GET)
	 no Corpo da Resposta(Body)
	 */
	
	// Injetar o Modelmappper
	
	private Long id;
	private String nome_cliente;
	private String descricao;
	private BigDecimal valor_total;
	private BigDecimal indice_comissao;
	private OffsetDateTime data_abertura;
	private OffsetDateTime data_faturamento;
	private String Status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome_cliente() {
		return nome_cliente;
	}
	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getValor_total() {
		return valor_total;
	}
	public void setValor_total(BigDecimal valor_total) {
		this.valor_total = valor_total;
	}
	public BigDecimal getIndice_comissao() {
		return indice_comissao;
	}
	public void setIndice_comissao(BigDecimal indice_comissao) {
		this.indice_comissao = indice_comissao;
	}
	public OffsetDateTime getData_abertura() {
		return data_abertura;
	}
	public void setData_abertura(OffsetDateTime data_abertura) {
		this.data_abertura = data_abertura;
	}
	public OffsetDateTime getData_faturamento() {
		return data_faturamento;
	}
	public void setData_faturamento(OffsetDateTime data_faturamento) {
		this.data_faturamento = data_faturamento;
	}
	
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	//-------------------------------------------------
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoRepresentationModel other = (PedidoRepresentationModel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
