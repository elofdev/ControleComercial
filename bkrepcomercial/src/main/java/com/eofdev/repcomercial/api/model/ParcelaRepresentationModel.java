package com.eofdev.repcomercial.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.eofdev.repcomercial.domain.model.StatusParcela;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class ParcelaRepresentationModel {
	
	/* Oque queremos que aparece para o usuário, quando ele fizer uma busca(GET)
	 no Corpo da Resposta(Body)
	 */
	
	// Injetar o Modelmappper

	private Long id;
	private String cliente_nome;
	private String nr_pedido_Cliente;
	private String master;
	private Integer nr_parcela;
	private Integer dias;
	private OffsetDateTime data_parcela_fatura;
	private BigDecimal valor_fatura;
	private OffsetDateTime data_parcela_comissao;
	private BigDecimal valor_comissao;
	private OffsetDateTime data_parcela_premiacao;
	private BigDecimal valor_premiacao;
	private StatusParcela status; 
	private String obs;
	
	//----------  GET  and    SET -----------------
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCliente_nome() {
		return cliente_nome;
	}
	public void setCliente_nome(String cliente_nome) {
		this.cliente_nome = cliente_nome;
	}
	public String getNr_pedido_Cliente() {
		return nr_pedido_Cliente;
	}
	public void setNr_pedido_Cliente(String nr_pedido_Cliente) {
		this.nr_pedido_Cliente = nr_pedido_Cliente;
	}
	public String getMaster() {
		return master;
	}
	public void setMaster(String master) {
		this.master = master;
	}
	public Integer getNr_parcela() {
		return nr_parcela;
	}
	public void setNr_parcela(Integer nr_parcela) {
		this.nr_parcela = nr_parcela;
	}
	public Integer getDias() {
		return dias;
	}
	public void setDias(Integer dias) {
		this.dias = dias;
	}
	public OffsetDateTime getData_parcela_fatura() {
		return data_parcela_fatura;
	}
	public void setData_parcela_fatura(OffsetDateTime data_parcela_fatura) {
		this.data_parcela_fatura = data_parcela_fatura;
	}
	public BigDecimal getValor_fatura() {
		return valor_fatura;
	}
	public void setValor_fatura(BigDecimal valor_fatura) {
		this.valor_fatura = valor_fatura;
	}
	public OffsetDateTime getData_parcela_comissao() {
		return data_parcela_comissao;
	}
	public void setData_parcela_comissao(OffsetDateTime data_parcela_comissao) {
		this.data_parcela_comissao = data_parcela_comissao;
	}
	public BigDecimal getValor_comissao() {
		return valor_comissao;
	}
	public void setValor_comissao(BigDecimal valor_comissao) {
		this.valor_comissao = valor_comissao;
	}
	public OffsetDateTime getData_parcela_premiacao() {
		return data_parcela_premiacao;
	}
	public void setData_parcela_premiacao(OffsetDateTime data_parcela_premiacao) {
		this.data_parcela_premiacao = data_parcela_premiacao;
	}
	public BigDecimal getValor_premiacao() {
		return valor_premiacao;
	}
	public void setValor_premiacao(BigDecimal valor_premiacao) {
		this.valor_premiacao = valor_premiacao;
	}
	public StatusParcela getStatus() {
		return status;
	}
	public void setStatus(StatusParcela status) {
		this.status = status;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	
	// ------ HASH   and  EQUALS
	
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
		ParcelaRepresentationModel other = (ParcelaRepresentationModel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
