package com.devweb.trabalho1.dto;

import java.sql.Date;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public class PedidoResponseDto {
	
	private int id_pedido;
    
    private int id_funcionario;
    
    private int id_cliente;

    @Temporal(TemporalType.DATE)
    private Date data_pedido;
    
	@Temporal(TemporalType.DATE)
    private Date data_remessa;


	public int getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}

	public int getId_funcionario() {
		return id_funcionario;
	}

	public void setId_funcionario(int id_funcionario) {
		this.id_funcionario = id_funcionario;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
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
