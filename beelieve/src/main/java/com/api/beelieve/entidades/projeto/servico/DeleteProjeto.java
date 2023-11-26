package com.api.beelieve.entidades.projeto.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.beelieve.entidades.analista_projeto.servico.DeleteAtribuicaoAnalista;
import com.api.beelieve.entidades.projeto.Projeto;
import com.api.beelieve.entidades.subprojeto.servico.DeleteSubProjeto;
import com.api.beelieve.repositorio.ProjetoRepositorio;

@Service
public class DeleteProjeto {
	
	@Autowired
	private DeleteSubProjeto deleteSubProjeto;

	@Autowired
	private ProjetoRepositorio repositorio_projeto;
	
	@Autowired
	private DeleteAtribuicaoAnalista deleteAtribuicaoAnalista;

	public void deleteCascata(Projeto projeto) {
		if(projeto.getSub_projetos() != null) {
			deleteSubProjeto.deleteCascata(projeto.getSub_projetos());
		}
		deleteAtribuicaoAnalista.deleteAtribuicao(projeto);
		repositorio_projeto.delete(projeto);
	}
}
