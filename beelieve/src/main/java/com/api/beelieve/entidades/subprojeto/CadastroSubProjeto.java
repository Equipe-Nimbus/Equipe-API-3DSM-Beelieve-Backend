package com.api.beelieve.entidades.subprojeto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.beelieve.repositorio.NivelSubProjetoRepositorio;
import com.api.beelieve.repositorio.SubProjetoRepositorio;
import com.api.beelieve.repositorio.TarefaRepositorio;

@Service
public class CadastroSubProjeto {
	
	@Autowired
	private SubProjetoRepositorio repositorio_subprojeto;
	
	@Autowired
	private NivelSubProjetoRepositorio repositorio_nivelsubprojeto;
	
	@Autowired
	private TarefaRepositorio repositorio_tarefa;
	

	public void cadastroCascata(List<SubProjeto> sub_projetos) {
		repositorio_subprojeto.saveAll(sub_projetos);
		
		sub_projetos.forEach((sub_projeto)->{
			if(sub_projeto.getNivelSubProjeto() != null) {
				repositorio_nivelsubprojeto.saveAll(sub_projeto.getNivelSubProjeto());
			}
			else if (sub_projeto.getTarefas() != null) {
				repositorio_tarefa.saveAll(sub_projeto.getTarefas());
			}
		});
		
	}

}
