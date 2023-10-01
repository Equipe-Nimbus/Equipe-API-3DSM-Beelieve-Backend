package com.api.beelieve.entidades.tarefa.dto;

import java.util.List;

public record DadosListaTarefasAtualizacao(
		String tipo_pai,
		Long id_pai,
		List<DadosTarefaAtualizacao> lista_tarefas
		) {
}
