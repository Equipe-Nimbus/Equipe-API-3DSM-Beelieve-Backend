package com.api.beelieve.entidades.subprojeto;

import java.math.BigDecimal;
import java.util.List;

import com.api.beelieve.entidades.nivelsubprojeto.DadosOrcamentoNivelSubProjeto;

public record DadosOrcamentoSubProjeto(
		Long id_sub_projeto,
		String chefe_sub_projeto,
		BigDecimal hora_humano_sub_projeto,
		BigDecimal orcamento_sub_projeto,
		List<DadosOrcamentoNivelSubProjeto> nivel_sub_projeto
		) {

}
