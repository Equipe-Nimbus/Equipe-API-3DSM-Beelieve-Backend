package com.api.beelieve.entidades.nivelsubprojeto;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.api.beelieve.entidades.subprojeto.SubProjeto;
import com.api.beelieve.repositorio.NivelSubProjetoRepositorio;
import com.api.beelieve.repositorio.TarefaRepositorio;

@Service
public class EstruturaNivelSubProjetoAtualizacao {
	
	@Autowired
	private NivelSubProjetoRepositorio repositorio_nivel;
	
	@Autowired
	private TarefaRepositorio repositorio_tarefa;
	
	@Autowired
	private DeleteNivelSubProjeto deleteNivelSubProjeto;
	
	
	public void atualizarEstrutura(List<DadosEstruturaNivelSubProjetoAtualizacao> listaDadosNivelSubProjeto, SubProjeto subProjeto) {
		List<NivelSubProjeto> listaNivelSubProjetoAtual = repositorio_nivel.findBySubProjeto(subProjeto);
		
		//Atualizando elementos que existem no banco
		Iterator<DadosEstruturaNivelSubProjetoAtualizacao> iteratorDadosNivel = listaDadosNivelSubProjeto.iterator();
		while(iteratorDadosNivel.hasNext()) {
			DadosEstruturaNivelSubProjetoAtualizacao dadosNivel = iteratorDadosNivel.next();
			Iterator<NivelSubProjeto> iteratorNivelSubProjeto = listaNivelSubProjetoAtual.iterator();
			while(iteratorNivelSubProjeto.hasNext()) {
				NivelSubProjeto nivelSubProj = iteratorNivelSubProjeto.next();
				if(dadosNivel.id_nivel_sub_projeto() == nivelSubProj.getNivel_sub_projeto_id()) {
					nivelSubProj.setNomeNivelSubProjeto(dadosNivel.nome_nivel_sub_projeto());
					nivelSubProj.setOrdem_nivel_sub_projeto(dadosNivel.ordem_nivel_sub_projeto());
					iteratorDadosNivel.remove();
					iteratorNivelSubProjeto.remove();
				}
			}
		}
		//Criando elementos não encontrados no banco mas que estão no JSON
		if(!listaDadosNivelSubProjeto.isEmpty()) {
			listaDadosNivelSubProjeto.forEach((nivelSub)->{
				repositorio_nivel.save(new NivelSubProjeto(nivelSub, subProjeto));
			});
		};
		//Deletando elementos que não estão no JSON
		if(!listaNivelSubProjetoAtual.isEmpty()) {
			deleteNivelSubProjeto.deleteCascata(listaNivelSubProjetoAtual);
		}
	}
	
	
}
