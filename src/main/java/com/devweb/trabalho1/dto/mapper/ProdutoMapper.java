package com.devweb.trabalho1.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devweb.trabalho1.dto.ProdutoDTO;
import com.devweb.trabalho1.dto.ProdutoResponseDto;
import com.devweb.trabalho1.modelo.Produto;

@Component 
public class ProdutoMapper {
	@Autowired 
	private ModelMapper mapper;
	
	public Produto toEntity(ProdutoDTO dto) {
		Produto entity = mapper.map(dto, Produto.class);
		return entity;
	}
	 
	public ProdutoResponseDto toDTO(Produto entity) {
		ProdutoResponseDto dto = mapper.map(entity, ProdutoResponseDto.class);
		return dto;
	}
	
	public List<ProdutoResponseDto> toDTO (List<Produto> produtos){
		return produtos.stream()
				.map(produto -> toDTO(produto))
				.collect(Collectors.toList());
	}
}
