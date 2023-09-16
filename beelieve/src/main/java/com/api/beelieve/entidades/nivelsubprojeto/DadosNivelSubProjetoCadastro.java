package com.api.beelieve.entidades.nivelsubprojeto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.api.beelieve.entidades.tarefa.DadosTarefaCadastro;

public record DadosNivelSubProjetoCadastro(
		String nomeNivelSubProjeto,
		List<DadosTarefaCadastro> tarefas,
		Date prazoNivelSubProjeto,
		BigDecimal progresso,
		BigDecimal orcamentoNivelSubProjeto,
		BigDecimal horaNivelHomemSubProjeto
		) {

}
