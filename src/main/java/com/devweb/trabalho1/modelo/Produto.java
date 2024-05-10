package com.devweb.trabalho1.modelo;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_produto;
    
    @Column(length = 20)
    private String codigo;
    
    @Column(columnDefinition = "text")
    private String descricao;
    private BigDecimal valor_custo;
    private BigDecimal valor_venda;

	@OneToMany(mappedBy = "id_produto")
    private List<Pedido_Produto> pedidosProdutos;
    
	public Integer getId_produto() {
		return id_produto;
	}
	public void setId_produto(Integer id_produto) {
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

