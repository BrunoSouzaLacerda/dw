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

import com.devweb.trabalho1.dto.PedidoDTO;
import com.devweb.trabalho1.dto.PedidoResponseDto;
import com.devweb.trabalho1.dto.mapper.PedidoMapper;
import com.devweb.trabalho1.excessao.PedidoNotFoundException;
import com.devweb.trabalho1.modelo.Pedido;
import com.devweb.trabalho1.servico.PedidoServico;

@RestController
@RequestMapping("/pedidos")
public class PedidoControle {

	@Autowired
	private PedidoServico pedidoServico;
	
	@Autowired
	private PedidoMapper pedidoMapper;
	
	@PostMapping
	public ResponseEntity<PedidoResponseDto> salvar(@RequestBody PedidoDTO pedidoDTO){
		Pedido pedido = pedidoMapper.toEntity(pedidoDTO);
		Pedido pedidoGravado = pedidoServico.gravar(pedido);
		PedidoResponseDto pedidoResponseDto = pedidoMapper.toDTO(pedidoGravado);
		return ResponseEntity.status(HttpStatus.CREATED).body(pedidoResponseDto);

	}
	
	@GetMapping
	public ResponseEntity<List<PedidoResponseDto>>buscarTodos(){
		List<Pedido> pedidos = pedidoServico.buscarTodos();
		List<PedidoResponseDto> pedidosResponseDto = pedidoMapper.toDTO(pedidos);
		return ResponseEntity.status(HttpStatus.OK).body(pedidosResponseDto);

	}
	
	@GetMapping("/{id_pedido}")
    public ResponseEntity<Object> buscarUm(@PathVariable(value = "id_pedido") Integer id_pedido) {		
		try {
			Pedido produtoGravado  = pedidoServico.buscarPedidoPorId(id_pedido);
			PedidoResponseDto produtoResponseDTO = pedidoMapper.toDTO(produtoGravado);        
	        return ResponseEntity.status(HttpStatus.OK).body(produtoResponseDTO);
		} catch (PedidoNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
    }
	
	@PutMapping("/{id_pedido}")
    public ResponseEntity<Object> alterar(@PathVariable(value = "id_pedido") Integer id_pedido, 
    									  @RequestBody PedidoDTO pedidoDto) {
		try {
			Pedido pedido = pedidoMapper.toEntity(pedidoDto);
			Pedido pedidoGravado = pedidoServico.alterarPedido(id_pedido, pedido);
			PedidoResponseDto pedidoResponseDTO = pedidoMapper.toDTO(pedidoGravado);
			return ResponseEntity.status(HttpStatus.OK).body(pedidoResponseDTO);
		} catch (PedidoNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
    }
	
	@DeleteMapping("/{id_pedido}")
    public ResponseEntity<Object> apagar(@PathVariable(value = "id_pedido") Integer id_pedido) {
		try {
			pedidoServico.apagarPedido(id_pedido);
			return ResponseEntity.status(HttpStatus.OK).body("Removido com sucesso.");
		} catch (PedidoNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
    }
}
