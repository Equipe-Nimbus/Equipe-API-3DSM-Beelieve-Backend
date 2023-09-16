package com.api.beelieve.entidades.tarefa;

public record DadosTarefaAtualizacao(
		Long id_tarefa,
		String descricao_atividade_tarefa,
		String resultado_esperado_tarefa,
		Integer status_tarefa
		) 
{

}
