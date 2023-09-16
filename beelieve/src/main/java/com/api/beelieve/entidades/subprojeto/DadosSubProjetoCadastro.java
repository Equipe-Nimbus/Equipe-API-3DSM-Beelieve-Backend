package com.api.beelieve.entidades.subprojeto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


import com.api.beelieve.entidades.nivelsubprojeto.DadosNivelSubProjetoCadastro;
import com.api.beelieve.entidades.tarefa.DadosTarefaCadastro;

public record DadosSubProjetoCadastro(
		String nomeSubProjeto,
		String chefeSubProjeto,
		Date prazoSubProjeto,
		BigDecimal progressoSubProjeto,
		BigDecimal horaHomemSubProjeto,
		BigDecimal orcamentoSubProjeto,
		List<DadosNivelSubProjetoCadastro> nivelSubProjetos,
		List<DadosTarefaCadastro> tarefas
		) {
	
}
