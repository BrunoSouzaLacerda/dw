package com.devweb.trabalho1.dto;

import java.math.BigDecimal;

public class ProdutoResponseDto {

	private int id_produto;
    
    private String codigo;
    private String descricao;
    private BigDecimal valor_custo;
    private BigDecimal valor_venda;
    
	public int getId_produto() {
		return id_produto;
	}
	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getValor_custo() {
		return valor_custo;
	}
	public void setValor_custo(BigDecimal valor_custo) {
		this.valor_custo = valor_custo;
	}
	public BigDecimal getValor_venda() {
		return valor_venda;
	}
	public void setValor_venda(BigDecimal valor_venda) {
		this.valor_venda = valor_venda;
	}
    
    
	
}
