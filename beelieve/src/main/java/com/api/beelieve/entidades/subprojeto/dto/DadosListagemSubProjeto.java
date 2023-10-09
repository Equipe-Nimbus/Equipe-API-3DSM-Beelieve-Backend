package com.api.beelieve.entidades.subprojeto.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.api.beelieve.entidades.nivelsubprojeto.dto.DadosListagemNivelSubProjeto;
import com.api.beelieve.entidades.tarefa.dto.DadosListagemTarefa;


public record DadosListagemSubProjeto(
		
		Long id_sub_projeto,
		String ordem_sub_projeto,
		String nome_sub_projeto,
		String chefe_sub_projeto,
		Date prazo_sub_projeto,
		Double progresso_sub_projeto,
		BigDecimal orcamento_sub_projeto,
		BigDecimal hora_humano_sub_projeto,
		BigDecimal materiais_sub_projeto,
		List<DadosListagemNivelSubProjeto> nivel_sub_projeto,
		List<DadosListagemTarefa> tarefas
		) {

}
