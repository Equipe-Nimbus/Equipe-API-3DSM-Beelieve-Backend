package com.api.beelieve.entidades.tarefa;

import java.util.Date;

public record DadosTarefaCadastro(
		String descricao_atividade_tarefa,
		String resultado_esperado_tarefa,
		Integer peso_tarefa,
		Integer status_tarefa,
		Date prazo_tarefa
		) {

}
