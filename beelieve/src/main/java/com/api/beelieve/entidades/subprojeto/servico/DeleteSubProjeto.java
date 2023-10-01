package com.api.beelieve.entidades.subprojeto.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.beelieve.entidades.nivelsubprojeto.servico.DeleteNivelSubProjeto;
import com.api.beelieve.entidades.subprojeto.SubProjeto;
import com.api.beelieve.repositorio.SubProjetoRepositorio;
import com.api.beelieve.repositorio.TarefaRepositorio;

@Service
public class DeleteSubProjeto {
	
	@Autowired
	private SubProjetoRepositorio repositorio_subprojeto;
	
	@Autowired
	private TarefaRepositorio repositorio_tarefa;
	
	@Autowired
	private DeleteNivelSubProjeto deleteNivel;

	public void deleteCascata(List<SubProjeto> sub_projetos) {
		sub_projetos.forEach((sub_projeto)->{
			if(sub_projeto.getNivelSubProjeto() != null) {
				deleteNivel.deleteCascata(sub_projeto.getNivelSubProjeto());
			}
			else if (sub_projeto.getTarefas() != null) {
				repositorio_tarefa.deleteAll(sub_projeto.getTarefas());
			}
		});	
		repositorio_subprojeto.deleteAll(sub_projetos);
	}

}
