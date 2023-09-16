package com.api.beelieve.entidades.subprojeto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.beelieve.entidades.projeto.Projeto;
import com.api.beelieve.repositorio.SubProjetoRepositorio;

@Service
public class SalvarListaSubProjeto {
	
	@Autowired
	private SubProjetoRepositorio repositorio_subprojeto;
	
	public void salvar(List<DadosSubProjetoAtualizacao> listaDadosNovosSubProjetos, Projeto projetoPai) {
		listaDadosNovosSubProjetos.forEach((dadosSubNivel)->{
			repositorio_subprojeto.save(new SubProjeto(dadosSubNivel, projetoPai));
		});
		
	}
}
