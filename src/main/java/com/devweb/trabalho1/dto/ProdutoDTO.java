package com.devweb.trabalho1.dto;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ProdutoDTO {
	
	@NotBlank(message ="O produto deve ter um codigo")
	@Size(min=2, message ="O código deve ter no minimo 2 caracteres")
	@Size(max=20, message ="A descricao deve ter no máximo 20 caracteres")
    @Column(length = 20)
    private String codigo;
	
	@NotBlank(message ="O produto deve ter uma descricao")
	@Size(min=2, message ="O descricao deve ter no minimo 2 caracteres")
    private String descricao;
	
	@NotBlank(message ="O produto deve ter um valor de custo")
    private BigDecimal valor_custo;
	
	@NotBlank(message ="O produto deve ter um codigo")
    private BigDecimal valor_venda;

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
