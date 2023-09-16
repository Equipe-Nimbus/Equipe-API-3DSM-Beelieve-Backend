package com.api.beelieve.entidades.tarefa;

import org.springframework.stereotype.Service;

@Service
public class AtualizarTarefa {

	public void atualizar(Tarefa tarefaAtual, DadosTarefaAtualizacao dadosTarefa) {
		if(dadosTarefa.descricaoAtividade() != null) {
			tarefaAtual.setDescricaoAtividade(dadosTarefa.descricaoAtividade());
		}
		if(dadosTarefa.resultadoEsperado() != null) {
			tarefaAtual.setResultadoEsperado(dadosTarefa.resultadoEsperado());
		}
	}
}
