package com.api.beelieve.entidades.nivelsubprojeto;

import java.math.BigDecimal;

public record DadosOrcamentoNivelSubProjeto(
		Long id_nivel_sub_projeto,
		String grupo_nivel_sub_projeto,
		BigDecimal hora_valor_nivel_sub_projeto,
		BigDecimal orcamento_nivel_sub_projeto
		) {

}
