package com.eofdev.repcomercial.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

import com.eofdev.repcomercial.domain.ValidationGroups;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Item {

	@NotNull(groups = ValidationGroups.ClienteId.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// ### ESTRANGEIRAS - fk_
	@Valid
	@ConvertGroup(from = Default.class , to = ValidationGroups.class)
	@ManyToOne
	private Pedido pedido;
	
	@Valid
	@ConvertGroup(from = Default.class , to = ValidationGroups.class)
	@OneToOne
	private Produto produto;
	// ###
	
	@NotNull
	private Integer quantidade_item;
	
	@NotNull
	private BigDecimal indice_item_tabela_cheia;
	
	@NotNull
	private BigDecimal valor_item_tabela_cheia;
	
	@NotNull	
	private BigDecimal indice_item_sem_desconto;
	
	@NotNull
	private BigDecimal valor_item_sem_desconto;
	
	@NotNull
	private BigDecimal valor_comissao_sem_desconto;
	
	@NotNull
	private BigDecimal indice_item_venda;
	
	@NotNull	
	private BigDecimal valor_item_venda;
	
	@NotNull
	private BigDecimal valor_comissao_venda;
	
	@NotNull
	private BigDecimal valor_premiacao_venda;
	
	@Size(max = 100)
	private String obs;

	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime datasys;

	// ----------- GET and SET ---------------
	
	
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

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantidade_item() {
		return quantidade_item;
	}

	public void setQuantidade_item(Integer quantidade_item) {
		this.quantidade_item = quantidade_item;
	}

	public BigDecimal getIndice_item_tabela_cheia() {
		return indice_item_tabela_cheia;
	}

	public void setIndice_item_tabela_cheia(BigDecimal indice_item_tabela_cheia) {
		this.indice_item_tabela_cheia = indice_item_tabela_cheia;
	}

	public BigDecimal getValor_item_tabela_cheia() {
		return valor_item_tabela_cheia;
	}

	public void setValor_item_tabela_cheia(BigDecimal valor_item_tabela_cheia) {
		this.valor_item_tabela_cheia = valor_item_tabela_cheia;
	}

	public BigDecimal getIndice_item_sem_desconto() {
		return indice_item_sem_desconto;
	}

	public void setIndice_item_sem_desconto(BigDecimal indice_item_sem_desconto) {
		this.indice_item_sem_desconto = indice_item_sem_desconto;
	}

	public BigDecimal getValor_item_sem_desconto() {
		return valor_item_sem_desconto;
	}

	public void setValor_item_sem_desconto(BigDecimal valor_item_sem_desconto) {
		this.valor_item_sem_desconto = valor_item_sem_desconto;
	}

	public BigDecimal getValor_comissao_sem_desconto() {
		return valor_comissao_sem_desconto;
	}

	public void setValor_comissao_sem_desconto(BigDecimal valor_comissao_sem_desconto) {
		this.valor_comissao_sem_desconto = valor_comissao_sem_desconto;
	}

	public BigDecimal getIndice_item_venda() {
		return indice_item_venda;
	}

	public void setIndice_item_venda(BigDecimal indice_item_venda) {
		this.indice_item_venda = indice_item_venda;
	}

	public BigDecimal getValor_item_venda() {
		return valor_item_venda;
	}

	public void setValor_item_venda(BigDecimal valor_item_venda) {
		this.valor_item_venda = valor_item_venda;
	}

	public BigDecimal getValor_comissao_venda() {
		return valor_comissao_venda;
	}

	public void setValor_comissao_venda(BigDecimal valor_comissao_venda) {
		this.valor_comissao_venda = valor_comissao_venda;
	}

	public BigDecimal getValor_premiacao_venda() {
		return valor_premiacao_venda;
	}

	public void setValor_premiacao_venda(BigDecimal valor_premiacao_venda) {
		this.valor_premiacao_venda = valor_premiacao_venda;
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

	// ------   HASH  and   EQUALS ----------
	
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
		Item other = (Item) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	//Get and Set
	
	
		
}
