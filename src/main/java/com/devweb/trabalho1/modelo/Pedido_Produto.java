package com.devweb.trabalho1.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
@IdClass(PedidoProdutoPK.class)
public class Pedido_Produto {
	
	@Id
    @JoinColumn(name = "id_pedido")
    @ManyToMany
	private Integer id_pedido;
	
	@Id
    @JoinColumn(name = "id_produto")
	@ManyToMany
	private Integer id_produto;
	
	
	private Integer quantidade;
	private BigDecimal preco_unitario;
	private BigDecimal desconto;
	
	public Integer getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(Integer id_pedido) {
		this.id_pedido = id_pedido;
	}
	public Integer getId_produto() {
		return id_produto;
	}
	public void setId_produto(Integer id_produto) {
		this.id_produto = id_produto;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getPreco_unitario() {
		return preco_unitario;
	}
	public void setPreco_unitario(BigDecimal preco_unitario) {
		this.preco_unitario = preco_unitario;
	}
	public BigDecimal getDesconto() {
		return desconto;
	}
	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

}
