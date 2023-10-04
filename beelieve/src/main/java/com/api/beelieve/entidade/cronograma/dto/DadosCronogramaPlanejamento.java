package com.api.beelieve.entidade.cronograma.dto;

import java.util.List;

public record DadosCronogramaPlanejamento(
		Long id_projeto,
		List<DadosMes> lista_cronograma
		) {

}
