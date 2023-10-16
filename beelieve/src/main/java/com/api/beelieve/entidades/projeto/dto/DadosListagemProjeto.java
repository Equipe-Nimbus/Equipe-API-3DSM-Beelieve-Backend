package com.api.beelieve.entidades.projeto.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.api.beelieve.entidades.subprojeto.dto.DadosListagemSubProjeto;

public record DadosListagemProjeto(
		
		Long id_projeto,		
		String ordem_projeto,
		String nome_projeto,
		String chefe_projeto,
		Double progresso_projeto,
		Date prazo_projeto,
		String descricao_projeto,
		Date data_inicio_projeto,
		BigDecimal orcamento_projeto,
		BigDecimal hora_humano_total,
		BigDecimal materiais_projeto,
		BigDecimal hora_valor_projeto,
		List<DadosListagemSubProjeto> sub_projetos
		) {

}
