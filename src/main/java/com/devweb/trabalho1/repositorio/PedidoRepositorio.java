package com.devweb.trabalho1.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devweb.trabalho1.modelo.Pedido;

public interface PedidoRepositorio extends JpaRepository<Pedido, Integer> {

}
