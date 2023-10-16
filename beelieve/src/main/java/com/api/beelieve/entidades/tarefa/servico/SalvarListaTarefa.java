package com.api.beelieve.entidades.tarefa.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.beelieve.entidades.nivelsubprojeto.NivelSubProjeto;
import com.api.beelieve.entidades.subprojeto.SubProjeto;
import com.api.beelieve.entidades.tarefa.Tarefa;
import com.api.beelieve.entidades.tarefa.dto.DadosTarefaAtualizacao;
import com.api.beelieve.repositorio.TarefaRepositorio;

@Service
public class SalvarListaTarefa {
	
	@Autowired
	private TarefaRepositorio repositorio_tarefa;

	public void salvarAtreladoNivel(List<DadosTarefaAtualizacao> listaDadosTarefaAtualizacao, NivelSubProjeto nivelSubProjeto) {
		listaDadosTarefaAtualizacao.forEach((dadosTarefa)->{
			repositorio_tarefa.save(new Tarefa(dadosTarefa, nivelSubProjeto));
		});
	}
	
	public void salvarAtreladoSubProjeto(List<DadosTarefaAtualizacao> listaDadosTarefaAtualizacaos, SubProjeto subProjeto) {
		listaDadosTarefaAtualizacaos.forEach((dadosTarefa)->{
			repositorio_tarefa.save(new Tarefa(dadosTarefa, subProjeto));
		});
	}
	
	
}
