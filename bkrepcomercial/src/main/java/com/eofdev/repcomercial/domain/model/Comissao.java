package com.eofdev.repcomercial.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Comissao {
	@NotNull
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(max = 1)
	private String tbl;
	@NotNull
	private BigDecimal limite;

	@NotNull
	private BigDecimal indice_comissao;

	@Size(max = 100)
	private String obs;

	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime datasys;

	// GET and SET

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTbl() {
		return tbl;
	}

	public void setTbl(String tbl) {
		this.tbl = tbl;
	}

	public BigDecimal getLimite() {
		return limite;
	}

	public void setLimite(BigDecimal limite) {
		this.limite = limite;
	}

	public BigDecimal getIndice_comissao() {
		return indice_comissao;
	}

	public void setIndice_comissao(BigDecimal indice_comissao) {
		this.indice_comissao = indice_comissao;
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

	// HASH and EQUALS

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
		Comissao other = (Comissao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
