package com.api.beelieve.entidades.subprojeto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.api.beelieve.entidades.nivelsubprojeto.DadosEstruturaNivelSubProjetoAtualizacao;
import com.api.beelieve.entidades.nivelsubprojeto.EstruturaNivelSubProjetoAtualizacao;
import com.api.beelieve.entidades.projeto.DeleteProjeto;
import com.api.beelieve.entidades.projeto.Projeto;
import com.api.beelieve.repositorio.SubProjetoRepositorio;
import com.api.beelieve.repositorio.TarefaRepositorio;

@Service
public class EstruturaSubProjetoAtualizacao{

	
	@Autowired
	private SubProjetoRepositorio repositorio_subprojeto;
	
	@Autowired
	private TarefaRepositorio repositorio_tarefa;
	
	@Autowired
	private EstruturaNivelSubProjetoAtualizacao estruturaNivelAtualizacao; 
	
	@Autowired
	private CadastroSubProjeto cadastroSubProjeto;
	
	@Autowired
	private DeleteSubProjeto deleteSubProjeto;
	
	public void atualizarEstrutura(List<DadosEstruturaSubProjetoAtualizacao> listaSubProjeto, Projeto projeto){
		List<SubProjeto> listaSubProjetoAtual = repositorio_subprojeto.findByProjeto(projeto);
		
		//Atualizando elementos que existem no banco
		Iterator<DadosEstruturaSubProjetoAtualizacao> iteratorDadosSubProjetoAtualizacao = listaSubProjeto.iterator();
		while(iteratorDadosSubProjetoAtualizacao.hasNext()) {
			DadosEstruturaSubProjetoAtualizacao dadosSub = iteratorDadosSubProjetoAtualizacao.next();
			Iterator<SubProjeto> iteratorSubProjetoAtual = listaSubProjetoAtual.iterator();
			while(iteratorSubProjetoAtual.hasNext()) {
				SubProjeto subProjeto = iteratorSubProjetoAtual.next();
				if(dadosSub.id_sub_projeto() == subProjeto.getSub_projeto_id()) {
					subProjeto.setNomeSubProjeto(dadosSub.nome_sub_projeto());
					if(dadosSub.nivel_sub_projeto() != null) {
						repositorio_tarefa.deleteAll(subProjeto.getTarefas());
						estruturaNivelAtualizacao.atualizarEstrutura(dadosSub.nivel_sub_projeto(), subProjeto);
					}
					iteratorDadosSubProjetoAtualizacao.remove();
					iteratorSubProjetoAtual.remove();
				}
			}
		}
		System.out.println(listaSubProjetoAtual);
		System.out.println(!listaSubProjetoAtual.isEmpty());
		//Criando elementos não encontrados no banco mas que estão no JSON
		if(!listaSubProjeto.isEmpty()) {
			List<SubProjeto> subProjetosNovos = new ArrayList<SubProjeto>();
			listaSubProjeto.forEach((subProj)->{
				subProjetosNovos.add(new SubProjeto(subProj, projeto));
			});
			cadastroSubProjeto.cadastroCascata(subProjetosNovos);
		};
		
		//Deletando elementos que não estão no JSON
		if(!listaSubProjetoAtual.isEmpty()) {
			deleteSubProjeto.deleteCascata(listaSubProjetoAtual);
		}

	}



}