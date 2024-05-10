package com.devweb.trabalho1.modelo;


import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Integer id_pedido;
    
    private int id_funcionario;
    
    private int id_cliente;

    @Temporal(TemporalType.DATE)
    private Date data_pedido;
    
    @Temporal(TemporalType.DATE)
    private Date data_remessa;
    
    @OneToMany(mappedBy = "id_pedido")
    private List<Pedido_Produto> pedidosProdutos;

	public Integer getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(Integer id_pedido) {
		this.id_pedido = id_pedido;
	}

	public Integer getId_funcionario() {
		return id_funcionario;
	}

	public void setId_funcionario(Integer id_funcionario) {
		this.id_funcionario = id_funcionario;
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public Date getData_pedido() {
		return data_pedido;
	}

	public void setData_pedido(Date data_pedido) {
		this.data_pedido = data_pedido;
	}

	public Date getData_remessa() {
		return data_remessa;
	}

	public void setData_remessa(Date data_remessa) {
		this.data_remessa = data_remessa;
	}


    
}

