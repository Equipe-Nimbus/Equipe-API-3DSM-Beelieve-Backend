package com.api.beelieve.entidades.tarefa;

public record DadosTarefaAtualizacao(
		Long tarefa_id,
		String descricaoAtividade,
		String resultadoEsperado,
		Boolean status
		) 
{

}
