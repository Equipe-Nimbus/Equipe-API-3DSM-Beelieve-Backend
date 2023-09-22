package com.api.beelieve.entidades.projeto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.beelieve.entidades.subprojeto.DeleteSubProjeto;
import com.api.beelieve.repositorio.ProjetoRepositorio;

@Service
public class DeleteProjeto {
	
	@Autowired
	private DeleteSubProjeto deleteSubProjeto;

	@Autowired
	private ProjetoRepositorio repositorio_projeto;

	public void deleteCascata(Projeto projeto) {
		if(projeto.getSub_projetos() != null) {
			deleteSubProjeto.deleteCascata(projeto.getSub_projetos());
		}
		repositorio_projeto.delete(projeto);
	}
}
