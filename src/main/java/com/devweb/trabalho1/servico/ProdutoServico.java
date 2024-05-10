package com.devweb.trabalho1.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devweb.trabalho1.excessao.ProdutoNotFoundException;
import com.devweb.trabalho1.modelo.Produto;
import com.devweb.trabalho1.repositorio.ProdutoRepositorio;

@Service
public class ProdutoServico {
	
	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	
	public Produto gravar(Produto produto) {
		return produtoRepositorio.save(produto);
	}

    public boolean existeProduto(Integer id_produto) {
        return produtoRepositorio.existsById(id_produto);
    }
    
    public List<Produto> buscarTodos(){
    	return produtoRepositorio.findAll();
    }
    
	public Produto buscarProdutoPorId(Integer id_produto) throws ProdutoNotFoundException {
		Optional<Produto> opt = produtoRepositorio.findById(id_produto);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new ProdutoNotFoundException("Produto com id : " + id_produto + " não existe");
		}		
	}
	
	public Produto alterarProduto(Integer id_produto, Produto produto) throws ProdutoNotFoundException {
		Produto produtoGravado = buscarProdutoPorId(id_produto);
		produtoGravado.setId_produto(produto.getId_produto());
		produtoGravado.setCodigo(produto.getCodigo());
		produtoGravado.setDescricao(produto.getDescricao());
		produtoGravado.setValor_custo(produto.getValor_custo());
		produtoGravado.setValor_venda(produto.getValor_venda());
		return produtoRepositorio.save(produtoGravado);
	}
	
	public void apagarProduto(Integer id_produto) throws ProdutoNotFoundException {
		Produto produto = buscarProdutoPorId(id_produto);
		produtoRepositorio.delete(produto);
	}
}

