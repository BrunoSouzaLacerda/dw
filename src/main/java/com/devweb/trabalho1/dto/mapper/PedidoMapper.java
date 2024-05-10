package com.devweb.trabalho1.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devweb.trabalho1.dto.PedidoDTO;
import com.devweb.trabalho1.dto.PedidoResponseDto;
import com.devweb.trabalho1.modelo.Pedido;

@Component 
public class PedidoMapper {
	@Autowired 
	private ModelMapper mapper;
	
	public Pedido toEntity(PedidoDTO dto) {
		Pedido entity = mapper.map(dto, Pedido.class);
		return entity;
	}
	 
	public PedidoResponseDto toDTO(Pedido entity) {
		PedidoResponseDto dto = mapper.map(entity, PedidoResponseDto.class);
		return dto;
	}
	
	public List<PedidoResponseDto> toDTO (List<Pedido> pedidos){
		return pedidos.stream()
				.map(pedido -> toDTO(pedido))
				.collect(Collectors.toList());
	}
}
