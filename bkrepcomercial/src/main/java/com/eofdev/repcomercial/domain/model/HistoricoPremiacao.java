package com.eofdev.repcomercial.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class HistoricoPremiacao {

	@NotNull
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// ### ESTRANGEIRAS - fk_

	@ManyToOne
	private Item item;
	
	@ManyToOne
	private Parcela parcela;
	// ###
	
	@NotNull
	private OffsetDateTime data_premiacao;
	
	@NotNull
	private BigDecimal valor_total_premiacao;
	
	@NotNull
	private String status_recebimento;

	@Size(max = 100)
	private String obs;

	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime datasys;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Parcela getParcela() {
		return parcela;
	}

	public void setParcela(Parcela parcela) {
		this.parcela = parcela;
	}

	public OffsetDateTime getData_premiacao() {
		return data_premiacao;
	}

	public void setData_premiacao(OffsetDateTime data_premiacao) {
		this.data_premiacao = data_premiacao;
	}

	public BigDecimal getValor_total_premiacao() {
		return valor_total_premiacao;
	}

	public void setValor_total_premiacao(BigDecimal valor_total_premiacao) {
		this.valor_total_premiacao = valor_total_premiacao;
	}

	public String getStatus_recebimento() {
		return status_recebimento;
	}

	public void setStatus_recebimento(String status_recebimento) {
		this.status_recebimento = status_recebimento;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public OffsetDateTime getDatasys() {
		return datasys;
	}

	public void setDatasys(OffsetDateTime datasys) {
		this.datasys = datasys;
	}

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
		HistoricoPremiacao other = (HistoricoPremiacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
