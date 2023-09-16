package com.api.beelieve.entidades.nivelsubprojeto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.api.beelieve.entidades.tarefa.DadosTarefaAtualizacao;

public record DadosNivelSubProjetoAtualizacao(
		Long id_nivel_sub_projeto,
		String nome_nivel_sub_projeto,
		Date prazo_nivel_sub_projeto,
		BigDecimal hora_humano_nivel_sub_projeto,
		Double progresso_nivel_sub_projeto,
		BigDecimal orcamento_nivel_sub_projeto,
		List<DadosTarefaAtualizacao> tarefas
		) 
{

}
