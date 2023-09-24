package com.api.beelieve.entidades.projeto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.beelieve.entidades.subprojeto.CadastroSubProjeto;
import com.api.beelieve.repositorio.ProjetoRepositorio;

@Service
public class CadastroProjeto {

	@Autowired
	private ProjetoRepositorio repositorio_projeto;
	
	@Autowired
	private CadastroSubProjeto cadastroCascataSubProjeto;
	
	public void cadastrarCascata(DadosProjetoCadastro dadosProjeto) {
		Projeto projeto = new Projeto(dadosProjeto);
		repositorio_projeto.save(projeto);
		if(projeto.getSub_projetos() != null) {
			cadastroCascataSubProjeto.cadastroCascata(projeto.getSub_projetos());
		}
	}
	
}
