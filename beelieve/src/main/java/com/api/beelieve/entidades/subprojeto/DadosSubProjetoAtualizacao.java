package com.api.beelieve.entidades.subprojeto;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

import com.api.beelieve.entidades.nivelsubprojeto.DadosNivelSubProjetoAtualizacao;
import com.api.beelieve.entidades.tarefa.DadosTarefaAtualizacao;

public record DadosSubProjetoAtualizacao(
		Long sub_projeto_id,
		String nomeSubProjeto,
		String chefeSubProjeto,
		Date prazoSubProjeto,
		BigDecimal progressoSubProjeto,
		BigDecimal orcamentoSubProjeto,
		BigDecimal horaHumanoSubProjeto,
		List<DadosNivelSubProjetoAtualizacao> nivelSubProjetos,
		List<DadosTarefaAtualizacao> tarefas
		) 
{

}
