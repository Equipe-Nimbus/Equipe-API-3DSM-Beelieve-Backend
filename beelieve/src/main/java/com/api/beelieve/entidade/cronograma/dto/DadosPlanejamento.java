package com.api.beelieve.entidade.cronograma.dto;

public record DadosPlanejamento(
		String tipo,
		Long id_nivel,
		String ordem_nivel,
		String nome_nivel,
		Double progresso_planejado
		) {

}
