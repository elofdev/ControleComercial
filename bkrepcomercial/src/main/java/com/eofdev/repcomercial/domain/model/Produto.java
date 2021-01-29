package com.eofdev.repcomercial.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Produto {
	@NotNull
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotBlank
	@Size(max = 10)
	private String codigo;

	@NotNull
	@NotBlank
	@Size(max = 100)
	private String nome_produto;

	@NotNull
	@NotBlank
	@Size(max = 10)
	private String medida;

	@NotNull
	@NotBlank
	@Size(max = 1)
	private String tbl;

	@NotNull
	@NotBlank
	@Size(max = 10)
	private String classe_produto;

	@NotNull
	private BigDecimal preco;

	@Size(max = 100)
	private String obs;

	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime datasys;

	// Get e Set

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome_produto() {
		return nome_produto;
	}

	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}

	public String getMedida() {
		return medida;
	}

	public void setMedida(String medida) {
		this.medida = medida;
	}

	public String getTbl() {
		return tbl;
	}

	public void setTbl(String tbl) {
		this.tbl = tbl;
	}

	public String getClasse_produto() {
		return classe_produto;
	}

	public void setClasse_produto(String classe_produto) {
		this.classe_produto = classe_produto;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
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

	// Hash and Equals

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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
