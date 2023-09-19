package com.api.beelieve.entidades.tarefa;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.beelieve.entidades.nivelsubprojeto.NivelSubProjeto;
import com.api.beelieve.entidades.subprojeto.SubProjeto;
import com.api.beelieve.repositorio.TarefaRepositorio;

@Service
public class LeituraListaTarefa {
	
	@Autowired
	private TarefaRepositorio repositorio_tarefa;
	
	@Autowired
	private AtualizarTarefa atualizaTarefa;
	
	@Autowired
	private SalvarListaTarefa salvarListaTarefa;

	public void atualizarListaNivel(List<DadosTarefaAtualizacao> listaDadosTarefaAtualizacao, NivelSubProjeto nivelSubProjetoAtual) {
		List<Tarefa> listaTarefaAtual = repositorio_tarefa.findByNivelSubProjeto(nivelSubProjetoAtual);
		
		//Atualizando elementos que existem no banco
		Iterator<DadosTarefaAtualizacao> iteratorDadosTarefaAtualizacao = listaDadosTarefaAtualizacao.iterator();
		while(iteratorDadosTarefaAtualizacao.hasNext()) {
			DadosTarefaAtualizacao dadoTarefa = iteratorDadosTarefaAtualizacao.next();
			Iterator<Tarefa> iteratorTarefaAtual = listaTarefaAtual.iterator();
			while(iteratorTarefaAtual.hasNext()) {
				Tarefa tarefaAtual = iteratorTarefaAtual.next();
				if(dadoTarefa.id_tarefa() == tarefaAtual.getTarefa_id()) {
					atualizaTarefa.atualizar(tarefaAtual, dadoTarefa);
					iteratorDadosTarefaAtualizacao.remove();
					iteratorTarefaAtual.remove();
				}
			}
		}		
		//Criando elementos não encontrados no banco mas que estão no JSON
		if(!listaDadosTarefaAtualizacao.isEmpty()) {
			salvarListaTarefa.salvarAtreladoNivel(listaDadosTarefaAtualizacao, nivelSubProjetoAtual);
		};
		//Deletando elementos que não estão no JSON
		if(!listaTarefaAtual.isEmpty()) {
			listaTarefaAtual.forEach((tarefa)->{
				repositorio_tarefa.delete(tarefa);
			});
		}
	}

	public void atualizarListaSubProjeto(List<DadosTarefaAtualizacao> listaDadosTarefaAtualizacao, SubProjeto subProjetoAtual) {
		List<Tarefa> listaTarefaAtual = repositorio_tarefa.findBySubProjeto(subProjetoAtual);
		
		//Atualizando elementos que existem no banco
		Iterator<DadosTarefaAtualizacao> iteratorDadosTarefaAtualizacao = listaDadosTarefaAtualizacao.iterator();
		while(iteratorDadosTarefaAtualizacao.hasNext() ) {
			DadosTarefaAtualizacao dadoTarefa = iteratorDadosTarefaAtualizacao.next();
			Iterator<Tarefa> iteratorTarefaAtual = listaTarefaAtual.iterator();
			while(iteratorTarefaAtual.hasNext()) {
				Tarefa tarefaAtual = iteratorTarefaAtual.next();
				if(dadoTarefa.id_tarefa() == tarefaAtual.getTarefa_id() && dadoTarefa.id_tarefa() != null) {
					atualizaTarefa.atualizar(tarefaAtual, dadoTarefa);
					iteratorDadosTarefaAtualizacao.remove();
					iteratorTarefaAtual.remove();
				}
			}
		}		
		//Criando elementos não encontrados no banco mas que estão no JSON
		if(!listaDadosTarefaAtualizacao.isEmpty()) {
			salvarListaTarefa.salvarAtreladoSubProjeto(listaDadosTarefaAtualizacao, subProjetoAtual);
		};
		//Deletando elementos que não estão no JSON
		if(!listaTarefaAtual.isEmpty()) {
			listaTarefaAtual.forEach((tarefa)->{
				repositorio_tarefa.delete(tarefa);
			});
		}
		
	}

}
