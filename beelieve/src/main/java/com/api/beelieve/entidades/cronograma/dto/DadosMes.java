package com.api.beelieve.entidades.cronograma.dto;

import java.util.List;

public record DadosMes(
		String mes_cronograma,
		Integer ordem_mes_cronograma,
		List<DadosPlanejamento> niveis
		) {

}
