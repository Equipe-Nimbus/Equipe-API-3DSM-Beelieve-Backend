package com.api.beelieve.repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.api.beelieve.entidades.nivelsubprojeto.DadosListagemNivelSubProjeto;
import com.api.beelieve.entidades.projeto.ConversorListagem;
import com.api.beelieve.entidades.projeto.DadosListagemProjeto;
import com.api.beelieve.entidades.projeto.Projeto;
import com.api.beelieve.entidades.subprojeto.DadosListagemSubProjeto;
import com.api.beelieve.entidades.subprojeto.SubProjeto;
import com.api.beelieve.entidades.tarefa.DadosListagemTarefa;
import com.api.beelieve.entidades.tarefa.Tarefa;

public interface ProjetoRepositorio extends JpaRepository<Projeto, Long> {

	public static final ConversorListagem conversorProjeto = new ConversorListagem();
	
	public default DadosListagemProjeto acharProjeto(Long projeto_id) {
		Projeto projeto = this.findById(projeto_id).get();
		DadosListagemProjeto dadosProjeto = conversorProjeto.converterListagemProjeto(projeto);
		return dadosProjeto;
	}
	
	public default List<DadosListagemProjeto> acharTodosProjetos() {
		List<Projeto> listaProjetos = this.findAll();
		
		List<DadosListagemProjeto> listaDadosProjeto = new ArrayList<DadosListagemProjeto>();
		if(listaProjetos != null) {
			listaProjetos.forEach((projeto)->{
				listaDadosProjeto.add(conversorProjeto.converterListagemProjeto(projeto));
			});
		}
		
		return listaDadosProjeto;
	}
}
