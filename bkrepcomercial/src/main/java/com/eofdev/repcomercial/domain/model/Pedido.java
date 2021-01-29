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
public class Pedido {
	@NotNull(groups = ValidationGroups.ClienteId.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// ### ESTRANGEIRAS - fk_
	
	@Valid
	@ConvertGroup(from = Default.class , to = ValidationGroups.class)
	@NotNull
	@ManyToOne
	private Cliente cliente;	
	// ###

	@NotNull
	@Size(max = 20)
	private String nr_pedido_cliente;

	@Size(max = 20)
	private String nr_master;

	@NotNull
	private BigDecimal valor_normal;

	@NotNull
	private BigDecimal valor_venda;

	@NotNull
	private BigDecimal valor_comissao;

	private OffsetDateTime data_abertura;

	private OffsetDateTime data_faturamento;

	@Enumerated(EnumType.STRING) // vamos determinar tipo string para ele armazenar o texto (ABERTA, FINALIZAD								// OU CANCELADA)
	private StatusPedido status; // Criar enum (enumeração)...botao direirto do maouse sibre a palavra.
	
	
	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getNr_pedido_cliente() {
		return nr_pedido_cliente;
	}

	public void setNr_pedido_cliente(String nr_pedido_cliente) {
		this.nr_pedido_cliente = nr_pedido_cliente;
	}

	public String getNr_master() {
		return nr_master;
	}

	public void setNr_master(String nr_master) {
		this.nr_master = nr_master;
	}

	public BigDecimal getValor_normal() {
		return valor_normal;
	}

	public void setValor_normal(BigDecimal valor_normal) {
		this.valor_normal = valor_normal;
	}

	public BigDecimal getValor_venda() {
		return valor_venda;
	}

	public void setValor_venda(BigDecimal valor_venda) {
		this.valor_venda = valor_venda;
	}

	public BigDecimal getValor_comissao() {
		return valor_comissao;
	}

	public void setValor_comissao(BigDecimal valor_comissao) {
		this.valor_comissao = valor_comissao;
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
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
}
