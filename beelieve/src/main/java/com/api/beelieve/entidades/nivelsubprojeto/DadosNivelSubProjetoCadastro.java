package com.api.beelieve.entidades.nivelsubprojeto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.api.beelieve.entidades.tarefa.DadosTarefaCadastro;

public record DadosNivelSubProjetoCadastro(
		String nome_nivel_sub_projeto,
		List<DadosTarefaCadastro> tarefas,
		Date prazo_nivel_sub_projeto,
		Double progresso,
		BigDecimal orcamento_nivel_sub_projeto,
		BigDecimal hora_nivel_humano_sub_projeto
		) {

}
