package com.devweb.trabalho1.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devweb.trabalho1.modelo.PedidoProdutoPK;
import com.devweb.trabalho1.modelo.Pedido_Produto;

public interface Pedido_ProdutoRepositorio extends JpaRepository<Pedido_Produto, PedidoProdutoPK> {

}
