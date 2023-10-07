package com.api.beelieve.entidades.tarefa.dto;

import java.util.List;

public record DadosListaTarefasAtualizacao(
		String tipo_pai,
		Long id_pai,
		Double progresso_pai,
		Boolean inicializado,
		List<DadosTarefaAtualizacao> lista_tarefas
		) {
}
