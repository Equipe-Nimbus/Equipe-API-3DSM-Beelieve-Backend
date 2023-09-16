package com.api.beelieve.entidades.tarefa;

import org.springframework.stereotype.Service;

@Service
public class AtualizarTarefa {

	public void atualizar(Tarefa tarefaAtual, DadosTarefaAtualizacao dadosTarefa) {
		if(dadosTarefa.descricao_atividade_tarefa() != null) {
			tarefaAtual.setDescricaoAtividade(dadosTarefa.descricao_atividade_tarefa());
		}
		if(dadosTarefa.resultado_esperado_tarefa() != null) {
			tarefaAtual.setResultadoEsperado(dadosTarefa.resultado_esperado_tarefa());
		}
	}
}
