package com.devweb.trabalho1.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devweb.trabalho1.modelo.Produto;

public interface ProdutoRepositorio extends JpaRepository<Produto, Integer> {

}
