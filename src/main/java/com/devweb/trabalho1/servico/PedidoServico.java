package com.devweb.trabalho1.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devweb.trabalho1.excessao.PedidoNotFoundException;
import com.devweb.trabalho1.modelo.Pedido;
import com.devweb.trabalho1.repositorio.PedidoRepositorio;

@Service
public class PedidoServico {
	
	@Autowired
	private PedidoRepositorio pedidoRepositorio;
	
	public Pedido gravar(Pedido pedido) {
		return pedidoRepositorio.save(pedido);
	}
	
    public boolean existePedido(Integer id_pedido) {
        return pedidoRepositorio.existsById(id_pedido);
    }

    
    public List<Pedido> buscarTodos(){
    	return pedidoRepositorio.findAll();
    }
    
    public Pedido buscarPedidoPorId(Integer id_pedido) throws PedidoNotFoundException {
        Optional<Pedido> opt = pedidoRepositorio.findById(id_pedido);
        if (opt.isPresent()) {
            return opt.get();
        } else {
            throw new PedidoNotFoundException("Pedido com id : " + id_pedido + " não existe");
        }       
    }

    public Pedido alterarPedido(Integer id_pedido, Pedido pedido) throws PedidoNotFoundException {
        Pedido pedidoGravado = buscarPedidoPorId(id_pedido);
        pedidoGravado.setId_funcionario(pedido.getId_funcionario());
        pedidoGravado.setId_cliente(pedido.getId_cliente());
        pedidoGravado.setData_pedido(pedido.getData_pedido());
        pedidoGravado.setData_remessa(pedido.getData_remessa());
        return pedidoRepositorio.save(pedidoGravado);
    }

    public void apagarPedido(Integer id_pedido) throws PedidoNotFoundException {
        Pedido pedido = buscarPedidoPorId(id_pedido);
        pedidoRepositorio.delete(pedido);
    }


}
