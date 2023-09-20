package com.api.beelieve.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.api.beelieve.entidades.nivelsubprojeto.NivelSubProjeto;
import com.api.beelieve.entidades.subprojeto.SubProjeto;
import com.api.beelieve.entidades.tarefa.Tarefa;

public interface TarefaRepositorio extends JpaRepository<Tarefa, Long>{

	List<Tarefa> findByNivelSubProjeto(NivelSubProjeto nivel_sub_projeto);

	List<Tarefa> findBySubProjeto(SubProjeto sub_projeto);
	

}
