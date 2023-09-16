package com.api.beelieve.entidades.nivelsubprojeto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.api.beelieve.entidades.tarefa.DadosTarefaAtualizacao;

public record DadosNivelSubProjetoAtualizacao(
		Long nivel_sub_projeto_id,
		String nomeNivelSubProjeto,
		Date prazoNivelSubProjeto,
		BigDecimal horaHomemNivelSubProjeto,
		BigDecimal progressoNivelSubProjeto,
		BigDecimal orcamentoNivelSubProjeto,
		List<DadosTarefaAtualizacao> tarefas
		) 
{

}
