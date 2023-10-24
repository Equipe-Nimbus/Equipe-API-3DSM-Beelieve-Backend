package com.api.beelieve.entidades.tarefa.servico;

import org.springframework.stereotype.Service;

import com.api.beelieve.entidades.tarefa.Tarefa;
import com.api.beelieve.entidades.tarefa.dto.DadosTarefaAtualizacao;

@Service
public class AtualizarTarefa {

	public void atualizar(Tarefa tarefaAtual, DadosTarefaAtualizacao dadosTarefa) {
		if(dadosTarefa.descricao_atividade_tarefa() != null) {
			tarefaAtual.setDescricaoAtividade(dadosTarefa.descricao_atividade_tarefa());
		}
		if(dadosTarefa.resultado_esperado_tarefa() != null) {
			tarefaAtual.setResultadoEsperado(dadosTarefa.resultado_esperado_tarefa());
		}
		if(dadosTarefa.status_tarefa() != null) {
			tarefaAtual.setStatus(dadosTarefa.status_tarefa());
		}
		if(dadosTarefa.peso_tarefa() != null) {
			tarefaAtual.setPeso_tarefa(dadosTarefa.peso_tarefa());
		}
		if(dadosTarefa.prazo_tarefa() != null) {
			tarefaAtual.setPrazo_tarefa(dadosTarefa.prazo_tarefa());
		}
		if(dadosTarefa.tendencia_tarefa() != null) {
			tarefaAtual.setTendencia_tarefa(dadosTarefa.tendencia_tarefa());
		}
		System.out.println(dadosTarefa);
	}
}
