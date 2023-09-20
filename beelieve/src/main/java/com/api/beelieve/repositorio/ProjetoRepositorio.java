package com.api.beelieve.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.api.beelieve.entidades.projeto.Projeto;
import com.api.beelieve.entidades.tarefa.Tarefa;

public interface ProjetoRepositorio extends JpaRepository<Projeto, Long> {

	public default Projeto acharProjeto(Long projeto_id) {
		Projeto projeto = this.findById(projeto_id).get();
		projeto.getSub_projetos().forEach((subProjeto)->{
			subProjeto.setProjeto(null);
			subProjeto.getNivelSubProjeto().forEach((nivelSub)->{
				nivelSub.setSubProjeto(null);
				nivelSub.getTarefas().forEach((tarefa)->{
					tarefa.setNivelSubProjeto(null);
				});
			});
			subProjeto.getTarefas().forEach((tarefa)->{
				tarefa.setSubProjeto(null);
			});
		});
		return projeto;
	}
	
	
	public default List<Projeto> acharTodosProjetos() {
		List<Projeto> listaProjetos = this.findAll();
		listaProjetos.forEach((projeto)->{
			projeto.getSub_projetos().forEach((subProjeto)->{
				subProjeto.setProjeto(null);
				subProjeto.getNivelSubProjeto().forEach((nivelSub)->{
					nivelSub.setSubProjeto(null);
					nivelSub.getTarefas().forEach((tarefa)->{
						tarefa.setNivelSubProjeto(null);
					});
				});
				subProjeto.getTarefas().forEach((tarefa)->{
					tarefa.setSubProjeto(null);
				});
			});
		});
		return listaProjetos;
	}
}
