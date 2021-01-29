package com.eofdev.repcomercial.api.model;

import java.math.BigDecimal;

public class ItemRepresentationModel {
	
	private Long id;
	private String nr_pedido_cliente;
	private String produto_nome;
	private Integer quantidade_item;
	private BigDecimal indice_item_tabela_cheia;
	private BigDecimal valor_item_tabela_cheia;
	private BigDecimal indice_item_sem_desconto;
	private BigDecimal valor_item_sem_desconto;
	private BigDecimal valor_comissao_sem_desconto;
	private BigDecimal indice_item_venda;
	private BigDecimal valor_item_venda;
	private BigDecimal valor_comissao_venda;
	private BigDecimal valor_premiacao_venda;
	private String obs;
	
	//------ GET   and   SET -------
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNr_pedido_cliente() {
		return nr_pedido_cliente;
	}
	public void setNr_pedido_cliente(String nr_pedido_cliente) {
		this.nr_pedido_cliente = nr_pedido_cliente;
	}
	public String getProduto_nome() {
		return produto_nome;
	}
	public void setProduto_nome(String produto_nome) {
		this.produto_nome = produto_nome;
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
	
	//--------   HASH  and   EQUALS ------   
	
	
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
		ItemRepresentationModel other = (ItemRepresentationModel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

	

}
