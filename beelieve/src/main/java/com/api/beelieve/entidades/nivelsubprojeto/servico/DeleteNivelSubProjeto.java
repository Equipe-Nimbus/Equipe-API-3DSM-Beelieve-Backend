package com.api.beelieve.entidades.nivelsubprojeto.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.beelieve.entidades.nivelsubprojeto.NivelSubProjeto;
import com.api.beelieve.entidades.tarefa.servico.DeleteAtribuicaoTarefa;
import com.api.beelieve.repositorio.NivelSubProjetoRepositorio;
import com.api.beelieve.repositorio.TarefaRepositorio;

@Service
public class DeleteNivelSubProjeto {
	
	@Autowired
	private NivelSubProjetoRepositorio repositorio_nivel;
	
	@Autowired
	private TarefaRepositorio repositorio_tarefa;
	
	@Autowired
	private DeleteAtribuicaoTarefa delete_atribuicao;
	
	public void deleteCascata(List<NivelSubProjeto> nivelSubProjeto) {
		nivelSubProjeto.forEach((nivel)->{
			if(nivel.getTarefas() != null) {
				nivel.getTarefas().forEach((tarefa)->{
					delete_atribuicao.deleteAtribuicao(tarefa);
					repositorio_tarefa.deleteById(tarefa.getTarefa_id());
				});
			}
		});
		
		repositorio_nivel.deleteAll(nivelSubProjeto);
	}

}
