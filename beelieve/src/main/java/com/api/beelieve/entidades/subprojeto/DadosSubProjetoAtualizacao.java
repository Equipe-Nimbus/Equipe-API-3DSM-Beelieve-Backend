package com.api.beelieve.entidades.subprojeto;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

import com.api.beelieve.entidades.nivelsubprojeto.DadosNivelSubProjetoAtualizacao;
import com.api.beelieve.entidades.tarefa.DadosTarefaAtualizacao;

public record DadosSubProjetoAtualizacao(
		Long id_sub_projeto,
		String nome_sub_projeto,
		String chefe_sub_projeto,
		Date prazo_sub_projeto,
		Double progresso_sub_projeto,
		BigDecimal orcamento_sub_projeto,
		BigDecimal hora_humano_sub_projeto,
		List<DadosNivelSubProjetoAtualizacao> nivel_sub_projetos,
		List<DadosTarefaAtualizacao> tarefas
		) 
{

}
