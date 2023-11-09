package com.api.beelieve.entidades.nivelsubprojeto.dto;

import java.math.BigDecimal;

public record DadosOrcamentoNivelSubProjeto(
		Long id_nivel_sub_projeto,
		Long chefe_nivel_sub_projeto,
		BigDecimal hora_humano_nivel_sub_projeto,
		BigDecimal orcamento_nivel_sub_projeto,
		BigDecimal materiais_nivel_sub_projeto
		) {

}
