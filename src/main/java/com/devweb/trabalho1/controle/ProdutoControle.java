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

import com.devweb.trabalho1.dto.ProdutoDTO;
import com.devweb.trabalho1.dto.ProdutoResponseDto;
import com.devweb.trabalho1.dto.mapper.ProdutoMapper;
import com.devweb.trabalho1.excessao.ProdutoNotFoundException;
import com.devweb.trabalho1.modelo.Produto;
import com.devweb.trabalho1.servico.ProdutoServico;

@RestController
@RequestMapping("/produtos")
public class ProdutoControle {

	@Autowired
	private ProdutoServico produtoServico;
	
	@Autowired
	private ProdutoMapper produtoMapper;
	
	@PostMapping
	public ResponseEntity<ProdutoResponseDto> salvar(@RequestBody ProdutoDTO produtoDTO){
		Produto produto = produtoMapper.toEntity(produtoDTO);
		Produto produtoGravado = produtoServico.gravar(produto);
		ProdutoResponseDto produtoResponseDto = produtoMapper.toDTO(produtoGravado);
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoResponseDto);

	}
	
	@GetMapping
	public ResponseEntity<List<ProdutoResponseDto>>buscarTodos(){
		List<Produto> produtos = produtoServico.buscarTodos();
		List<ProdutoResponseDto> produtoResponseDto = produtoMapper.toDTO(produtos);
		return ResponseEntity.status(HttpStatus.OK).body(produtoResponseDto);

	}
	
	@GetMapping("/{id_produto}")
    public ResponseEntity<Object> buscarUm(@PathVariable(value = "id_produto") Integer id_produto) {		
		try {
			Produto produtoGravado  = produtoServico.buscarProdutoPorId(id_produto);
			ProdutoResponseDto produtoResponseDTO = produtoMapper.toDTO(produtoGravado);        
	        return ResponseEntity.status(HttpStatus.OK).body(produtoResponseDTO);
		} catch (ProdutoNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
    }
	
	@PutMapping("/{id_produto}")
    public ResponseEntity<Object> alterar(@PathVariable(value = "id_produto") Integer id_produto,
    									  @RequestBody ProdutoDTO produtoDto) {
		try {
			Produto produto = produtoMapper.toEntity(produtoDto);
			Produto produtoGravado = produtoServico.alterarProduto(id_produto, produto);
			ProdutoResponseDto produtoResponseDTO = produtoMapper.toDTO(produtoGravado);
			return ResponseEntity.status(HttpStatus.OK).body(produtoResponseDTO);
		} catch (ProdutoNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
    }
	
	@DeleteMapping("/{id_produto}")
    public ResponseEntity<Object> apagar(@PathVariable(value = "id_produto") Integer id_produto) {
		try {
			produtoServico.apagarProduto(id_produto);
			return ResponseEntity.status(HttpStatus.OK).body("Removido com sucesso.");
		} catch (ProdutoNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
    }

}
