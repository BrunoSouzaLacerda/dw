package com.devweb.trabalho1.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devweb.trabalho1.dto.Pedido_ProdutoDTO;
import com.devweb.trabalho1.dto.Pedido_ProdutoResponseDto;
import com.devweb.trabalho1.dto.mapper.Pedido_ProdutoMapper;
import com.devweb.trabalho1.excessao.PedidoProdutoNotFoundException;
import com.devweb.trabalho1.modelo.Pedido_Produto;
import com.devweb.trabalho1.servico.PedidoServico;
import com.devweb.trabalho1.servico.Pedido_ProdutoServico;
import com.devweb.trabalho1.servico.ProdutoServico;

@RestController
@RequestMapping("/pedido_produto")
public class Pedido_ProdutoControle {
	
	@Autowired
	private Pedido_ProdutoServico pedido_produtoServico;
	
	@Autowired
	private ProdutoServico produtoServico;
	
	@Autowired
	private PedidoServico pedidoServico;
	
	@Autowired
	private Pedido_ProdutoMapper pedido_produtoMapper;

	@PostMapping
	public ResponseEntity<Pedido_ProdutoResponseDto> gravar(@RequestBody Pedido_ProdutoDTO pedido_produtoDTO){
		
        if (!produtoServico.existeProduto(pedido_produtoDTO.getId_produto())) {
        	return new ResponseEntity("Erro ao cadastrar pedido_produto, produto nao encontrado",HttpStatus.BAD_REQUEST);
        }
        
        if (!pedidoServico.existePedido(pedido_produtoDTO.getId_pedido())) {
        	return new ResponseEntity("Erro ao cadastrar pedido_produto, pedido nao encontrado",HttpStatus.BAD_REQUEST);
        }
		Pedido_Produto pedido_produto = pedido_produtoMapper.toEntity(pedido_produtoDTO);
		Pedido_Produto pedido_produtoGravado = pedido_produtoServico.gravar(pedido_produto);
		Pedido_ProdutoResponseDto pedido_produtoResponseDto = pedido_produtoMapper.toDTO(pedido_produtoGravado);
		return ResponseEntity.status(HttpStatus.CREATED).body(pedido_produtoResponseDto);

	}
	
	@GetMapping
	public ResponseEntity<List<Pedido_ProdutoResponseDto>>buscarTodos(){
		List<Pedido_Produto> pedidos_produtos = pedido_produtoServico.buscarTodos();
		List<Pedido_ProdutoResponseDto> pedidos_produtoResponseDto = pedido_produtoMapper.toDTO(pedidos_produtos);
		return ResponseEntity.status(HttpStatus.OK).body(pedidos_produtoResponseDto);

	}
	
	
	@GetMapping("/{id_produto}/{id_pedido}")
	public ResponseEntity<Object> buscarUm(@PathVariable(value = "id_pedido") Integer id_pedido,
	                                        @PathVariable(value = "id_produto") Integer id_produto) {		
	    try {
	        Pedido_Produto pedidoProdutoGravado = pedido_produtoServico.buscarPedidoProdutoPorId(id_pedido, id_produto);
	        Pedido_ProdutoResponseDto pedidoProdutoResponseDTO = pedido_produtoMapper.toDTO(pedidoProdutoGravado);        
	        return ResponseEntity.status(HttpStatus.OK).body(pedidoProdutoResponseDTO);
	    } catch (PedidoProdutoNotFoundException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	    }
	}
	
	@PutMapping("/{id_produto}/{id_pedido}")
	public ResponseEntity<Object> alterar(@PathVariable(value = "id_pedido") Integer id_pedido,
	                                       @PathVariable(value = "id_produto") Integer id_produto, 
	                                       @RequestBody Pedido_ProdutoDTO pedidoProdutoDTO) {
	    try {
	        Pedido_Produto pedidoProduto = pedido_produtoMapper.toEntity(pedidoProdutoDTO);
	        Pedido_Produto pedidoProdutoGravado = pedido_produtoServico.alterarPedido_Produto(id_pedido, id_produto, pedidoProduto);
	        Pedido_ProdutoResponseDto pedidoProdutoResponseDTO = pedido_produtoMapper.toDTO(pedidoProdutoGravado);
	        return ResponseEntity.status(HttpStatus.OK).body(pedidoProdutoResponseDTO);
	    } catch (PedidoProdutoNotFoundException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	    }
	}
	
	@DeleteMapping("/{id_produto}/{id_pedido}")
	public ResponseEntity<Object> apagar(@PathVariable(value = "id_pedido") Integer id_pedido,
	                                     @PathVariable(value = "id_produto") Integer id_produto) {
	    try {
	        pedido_produtoServico.apagarPedidoProduto(id_pedido, id_produto);
	        return ResponseEntity.status(HttpStatus.OK).body("Removido com sucesso.");
	    } catch (PedidoProdutoNotFoundException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	    }
	}





	
}
