package com.api.beelieve.entidades.cronograma.dto;

import java.util.List;

public record DadosCronogramaPlanejamento(
		Long id_projeto,
		List<DadosMes> lista_cronograma
		) {

}
