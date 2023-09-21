package com.api.beelieve.entidades.subprojeto;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.api.beelieve.entidades.nivelsubprojeto.DadosEstruturaNivelSubProjetoAtualizacao;
import com.api.beelieve.entidades.nivelsubprojeto.EstruturaNivelSubProjetoAtualizacao;
import com.api.beelieve.entidades.projeto.Projeto;
import com.api.beelieve.repositorio.SubProjetoRepositorio;

@Service
public class EstruturaSubProjetoAtualizacao{

	
	@Autowired
	private SubProjetoRepositorio repositorio_subprojeto;
	
	@Autowired
	private EstruturaNivelSubProjetoAtualizacao estruturaNivelAtualizacao; 
	
	public void atualizarEstrutura(List<DadosEstruturaSubProjetoAtualizacao> listaSubProjeto, Projeto projeto){
		List<SubProjeto> listaSubProjetoAtual = repositorio_subprojeto.findByProjeto(projeto);
		
		//Atualizando elementos que existem no banco
		Iterator<DadosEstruturaSubProjetoAtualizacao> iteratorDadosSubProjetoAtualizacao = listaSubProjeto.iterator();
		while(iteratorDadosSubProjetoAtualizacao.hasNext()) {
			DadosEstruturaSubProjetoAtualizacao dadosSub = iteratorDadosSubProjetoAtualizacao.next();
			Iterator<SubProjeto> iteratorSubProjetoAtual = listaSubProjetoAtual.iterator();
			while(iteratorSubProjetoAtual.hasNext()) {
				SubProjeto subProjeto = iteratorSubProjetoAtual.next();
				if(dadosSub.id_sub_projeto() == subProjeto.getSub_projeto_id() && dadosSub.id_sub_projeto() != null) {
					subProjeto.setNomeSubProjeto(dadosSub.nome_sub_projeto());
					if(!dadosSub.nivel_sub_projetos().isEmpty()) {
						subProjeto.setTarefas(null);
						estruturaNivelAtualizacao.atualizarEstrutura(dadosSub.nivel_sub_projetos(), subProjeto);
					}
					iteratorDadosSubProjetoAtualizacao.remove();
					iteratorSubProjetoAtual.remove();
				}
			}
		}
		//Criando elementos não encontrados no banco mas que estão no JSON
		if(!listaSubProjeto.isEmpty()) {
			listaSubProjeto.forEach((subProj)->{
				repositorio_subprojeto.save(new SubProjeto(subProj, projeto));
			});
			
		};
		//Deletando elementos que não estão no JSON
		if(!listaSubProjetoAtual.isEmpty()) {
			listaSubProjetoAtual.forEach((subProj)->{
				repositorio_subprojeto.delete(subProj);
			});
		}

	}



}