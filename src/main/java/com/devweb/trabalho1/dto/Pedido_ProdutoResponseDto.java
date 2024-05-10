package com.devweb.trabalho1.dto;

import java.math.BigDecimal;

import com.devweb.trabalho1.modelo.Pedido;
import com.devweb.trabalho1.modelo.Produto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Pedido_ProdutoResponseDto {
	@ManyToOne
    @JoinColumn(name = "id_pedido")
	private int id_pedido;
	
	@ManyToOne
    @JoinColumn(name = "id_produto")
	private int id_produto;
	
	@NotBlank(message ="Inserir quantidade")
	@Size(min=1, message ="Quantidade deve ser maior que zero")
	private int quantidade;
	private BigDecimal preco_unitario;
	private BigDecimal desconto;
	public int getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}
	public int getId_produto() {
		return id_produto;
	}
	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
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
