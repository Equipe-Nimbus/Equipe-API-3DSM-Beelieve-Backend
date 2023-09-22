package com.api.beelieve.entidades.projeto;

import java.math.BigDecimal;
import java.util.List;

import com.api.beelieve.entidades.subprojeto.DadosOrcamentoSubProjeto;

public record DadosOrcamentoProjeto(
			Long id_projeto,
			String chefe_projeto,
			BigDecimal hora_valor_projeto,
			BigDecimal hora_humano_total,
			BigDecimal orcamento_projeto,
			List<DadosOrcamentoSubProjeto> sub_projetos
		) {

}
