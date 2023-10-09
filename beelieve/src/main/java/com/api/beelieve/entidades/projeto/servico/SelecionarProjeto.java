package com.api.beelieve.entidades.projeto.servico;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.beelieve.entidades.nivelsubprojeto.NivelSubProjeto;
import com.api.beelieve.entidades.projeto.Projeto;
import com.api.beelieve.entidades.subprojeto.SubProjeto;
import com.api.beelieve.entidades.tarefa.Tarefa;

@Service
public class SelecionarProjeto {
	
	public Projeto selecionar(Projeto projeto) {
		List<SubProjeto> listaSubProjeto = projeto.getSub_projetos();
		for (SubProjeto subProjeto : listaSubProjeto) {
			subProjeto.setProjeto(null);
			List<NivelSubProjeto> ListaNivelSubProjeto = subProjeto.getNivelSubProjeto();
			for (NivelSubProjeto nivelSubProjeto : ListaNivelSubProjeto) {
				nivelSubProjeto.setSubProjeto(null);
				List<Tarefa> listaTarefa = nivelSubProjeto.getTarefas();
				for (Tarefa tarefa : listaTarefa) {
					tarefa.setNivelSubProjeto(null);
				}
			}
			List<Tarefa> listaTarefa = subProjeto.getTarefas();
			for (Tarefa tarefa : listaTarefa) {
				tarefa.setNivelSubProjeto(null);
			}
		}
		return projeto;
	}
}
