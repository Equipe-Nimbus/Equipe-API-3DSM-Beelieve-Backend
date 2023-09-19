package com.api.beelieve.entidades.subprojeto;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.beelieve.entidades.projeto.Projeto;
import com.api.beelieve.repositorio.SubProjetoRepositorio;

@Service
public class LeituraListaSubProjetoAtualizacao {

	@Autowired
	private AtualizarSubProjeto atualizaSubProjeto;
	
	@Autowired
	private SubProjetoRepositorio repositorio_subprojeto;
	
	@Autowired
	private SalvarListaSubProjeto salvarListaSubProjeto; 
	
	public List<SubProjeto> atualizarLista(List<DadosSubProjetoAtualizacao> listaSubProjeto, Projeto projeto){
		List<SubProjeto> listaSubProjetoAtual = repositorio_subprojeto.findByProjeto(projeto);
		
		//Atualizando elementos que existem no banco
		Iterator<DadosSubProjetoAtualizacao> iteratorDadosSubProjetoAtualizacao = listaSubProjeto.iterator();
		while(iteratorDadosSubProjetoAtualizacao.hasNext()) {
			DadosSubProjetoAtualizacao dadosSub = iteratorDadosSubProjetoAtualizacao.next();
			Iterator<SubProjeto> iteratorSubProjetoAtual = listaSubProjetoAtual.iterator();
			while(iteratorSubProjetoAtual.hasNext()) {
				SubProjeto subProjeto = iteratorSubProjetoAtual.next();
				if(dadosSub.id_sub_projeto() == subProjeto.getSub_projeto_id()) {
					atualizaSubProjeto.atualizar(subProjeto, dadosSub);
					iteratorDadosSubProjetoAtualizacao.remove();
					iteratorSubProjetoAtual.remove();
				}
			}
		}
		//Criando elementos não encontrados no banco mas que estão no JSON
		System.out.println(!listaSubProjeto.isEmpty());
		if(!listaSubProjeto.isEmpty()) {
			salvarListaSubProjeto.salvar(listaSubProjeto, projeto);
		};
		//Deletando elementos que não estão no JSON
		if(!listaSubProjetoAtual.isEmpty()) {
			listaSubProjetoAtual.forEach((subProj)->{
				repositorio_subprojeto.delete(subProj);
			});
		}
	
		return listaSubProjetoAtual;
	}
}