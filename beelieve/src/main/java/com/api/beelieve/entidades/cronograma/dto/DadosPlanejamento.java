package com.api.beelieve.entidades.cronograma.dto;

public record DadosPlanejamento(
		String tipo,
		Long id_nivel,
		String ordem_nivel,
		String nome_nivel,
		Double progresso_planejado
		) {

}
