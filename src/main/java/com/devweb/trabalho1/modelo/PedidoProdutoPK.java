package com.devweb.trabalho1.modelo;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;

@Embeddable
public class PedidoProdutoPK implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id_pedido")
	private Integer id_pedido;
    
    @Id
    @Column(name = "id_produto")
    private Integer id_produto;
    
    
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
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidoProdutoPK that = (PedidoProdutoPK) o;
        return Objects.equals(id_pedido, that.id_pedido) &&
               Objects.equals(id_produto, that.id_produto);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id_pedido, id_produto);
    }
    
}
