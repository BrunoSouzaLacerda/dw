package com.devweb.trabalho1.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devweb.trabalho1.dto.Pedido_ProdutoDTO;
import com.devweb.trabalho1.dto.Pedido_ProdutoResponseDto;
import com.devweb.trabalho1.modelo.Pedido_Produto;

@Component 
public class Pedido_ProdutoMapper {
	@Autowired 
	private ModelMapper mapper;
	
	public Pedido_Produto toEntity(Pedido_ProdutoDTO dto) {
		Pedido_Produto entity = mapper.map(dto, Pedido_Produto.class);
		return entity;
	}
	 
	public Pedido_ProdutoResponseDto toDTO(Pedido_Produto entity) {
		Pedido_ProdutoResponseDto dto = mapper.map(entity, Pedido_ProdutoResponseDto.class);
		return dto;
	}
	
	public List<Pedido_ProdutoResponseDto> toDTO (List<Pedido_Produto> pedidos_produto){
		return pedidos_produto.stream()
				.map(pedido_produto -> toDTO(pedido_produto))
				.collect(Collectors.toList());
	}
}
