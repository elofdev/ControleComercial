package com.eofdev.repcomercial.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

import com.eofdev.repcomercial.domain.ValidationGroups;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Parcela {

	@NotNull(groups = ValidationGroups.ClienteId.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// ### ESTRANGEIRAS - fk_
	@Valid
	@ConvertGroup(from = Default.class , to = ValidationGroups.class)
	@ManyToOne
	private Pedido pedido;

	// ###

	@NotNull
	private Integer nr_parcela;

	@NotNull
	private Integer dias;

	@NotNull
	private OffsetDateTime data_parcela_fatura;

	@NotNull
	private BigDecimal valor_fatura;

	@NotNull
	private OffsetDateTime data_parcela_comissao;

	@NotNull
	private BigDecimal valor_comissao;

	private OffsetDateTime data_parcela_premiacao;
	private BigDecimal valor_premiacao;

	@Size(max = 100)
	private String obs;

	@Enumerated(EnumType.STRING) // vamos determinar tipo string para ele armazenar o texto (ABERTA, FINALIZAD //								// OU CANCELADA)
	private StatusParcela status; // Criar enum (enumeração)...botao direirto do maouse sibre a palavra.

	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime datasys;

	//------  GET and SET  -------------------------------
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
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

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public StatusParcela getStatus() {
		return status;
	}

	public void setStatus(StatusParcela status) {
		this.status = status;
	}

	public OffsetDateTime getDatasys() {
		return datasys;
	}

	public void setDatasys(OffsetDateTime datasys) {
		this.datasys = datasys;
	}

	// -------   HASH  and   EQUALS
	
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
		Parcela other = (Parcela) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	// Get and Set

}
