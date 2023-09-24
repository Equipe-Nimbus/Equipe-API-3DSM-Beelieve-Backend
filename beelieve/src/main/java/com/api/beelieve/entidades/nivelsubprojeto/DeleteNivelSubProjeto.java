package com.api.beelieve.entidades.nivelsubprojeto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.beelieve.repositorio.NivelSubProjetoRepositorio;
import com.api.beelieve.repositorio.TarefaRepositorio;

@Service
public class DeleteNivelSubProjeto {
	
	@Autowired
	private NivelSubProjetoRepositorio repositorio_nivel;
	
	@Autowired
	private TarefaRepositorio repositorio_tarefa;
	
	public void deleteCascata(List<NivelSubProjeto> nivelSubProjeto) {
		nivelSubProjeto.forEach((nivel)->{
			if(nivel.getTarefas() != null) {
				repositorio_tarefa.deleteAll(nivel.getTarefas());
			}
		});
		
		repositorio_nivel.deleteAll(nivelSubProjeto);
	}

}
