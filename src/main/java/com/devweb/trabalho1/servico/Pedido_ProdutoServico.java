package com.devweb.trabalho1.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devweb.trabalho1.excessao.PedidoProdutoNotFoundException;
import com.devweb.trabalho1.modelo.PedidoProdutoPK;
import com.devweb.trabalho1.modelo.Pedido_Produto;
import com.devweb.trabalho1.repositorio.Pedido_ProdutoRepositorio;

@Service
public class Pedido_ProdutoServico {
	
	@Autowired
	private Pedido_ProdutoRepositorio pedido_produtoRepositorio;
	
	public Pedido_Produto gravar(Pedido_Produto pedido_produto) {
		return pedido_produtoRepositorio.save(pedido_produto);
	}
	
    public List<Pedido_Produto> buscarTodos(){
    	return pedido_produtoRepositorio.findAll();
    }
    
    public Pedido_Produto buscarPedidoProdutoPorId(Integer id_pedido, Integer id_produto) throws PedidoProdutoNotFoundException {
        PedidoProdutoPK pk = new PedidoProdutoPK();
        pk.setId_pedido(id_pedido);
        pk.setId_produto(id_produto);
        
        Optional<Pedido_Produto> opt = pedido_produtoRepositorio.findById(pk);
        if (opt.isPresent()) {
            return opt.get();
        } else {
            throw new PedidoProdutoNotFoundException("PedidoProduto com id_pedido : " + id_pedido + " e id_produto : " + id_produto + " não existe");
        }       
    }


    
    public Pedido_Produto alterarPedido_Produto(Integer id_pedido, Integer id_produto, Pedido_Produto pedidoProdutoNovo) throws PedidoProdutoNotFoundException {
        PedidoProdutoPK pk = new PedidoProdutoPK();
        pk.setId_pedido(id_pedido);
        pk.setId_produto(id_produto);
        
        Pedido_Produto pedidoProdutoGravado = buscarPedidoProdutoPorId(id_pedido, id_produto);
        
        pedidoProdutoGravado.setDesconto(pedidoProdutoNovo.getDesconto());
        pedidoProdutoGravado.setPreco_unitario(pedidoProdutoNovo.getPreco_unitario());
        pedidoProdutoGravado.setQuantidade(pedidoProdutoNovo.getQuantidade());
        
        return pedido_produtoRepositorio.save(pedidoProdutoGravado);
    }

	
    public void apagarPedidoProduto(Integer id_pedido, Integer id_produto) throws PedidoProdutoNotFoundException {
        Pedido_Produto pedidoProduto = buscarPedidoProdutoPorId(id_pedido, id_produto);
        pedido_produtoRepositorio.delete(pedidoProduto);
    }


}
