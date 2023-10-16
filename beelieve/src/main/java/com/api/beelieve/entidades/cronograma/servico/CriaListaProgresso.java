package com.api.beelieve.entidades.cronograma.servico;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.api.beelieve.entidades.cronograma.Progresso;
import com.api.beelieve.entidades.cronograma.dto.DadosPlanejamento;
import com.api.beelieve.entidades.projeto.Projeto;
import com.api.beelieve.entidades.subprojeto.SubProjeto;

@Service
public class CriaListaProgresso {

	public List<Progresso> criarListaProgressoProjeto(Projeto projeto) {
		List<Progresso> niveis = new ArrayList<Progresso>();
		niveis.add(new Progresso(
				new DadosPlanejamento(
						"projeto",
						projeto.getId_projeto(),
						projeto.getOrdem_projeto(),
						projeto.getNome_projeto(),
						0.0
						)));
		if(projeto.getSub_projetos() != null) {
			projeto.getSub_projetos().forEach((subprojeto)->{
				niveis.add(new Progresso(
						new DadosPlanejamento(
								"subprojeto",
								subprojeto.getSub_projeto_id(),
								subprojeto.getOrdem_sub_projeto(),
								subprojeto.getNomeSubProjeto(),
								0.0
								)));
				if(subprojeto.getNivelSubProjeto() != null) {
					subprojeto.getNivelSubProjeto().forEach((nivelSubProjeto)->{
						niveis.add(new Progresso(
								new DadosPlanejamento(
										"nivelsubprojeto",
										nivelSubProjeto.getId_nivel_sub_projeto(),
										nivelSubProjeto.getOrdem_nivel_sub_projeto(),
										nivelSubProjeto.getNome_nivel_sub_projeto(),
										0.0
										)));
					});
				}
			});
		}
		return niveis;
	}
	
	public List<Progresso> criarListaInsertProgresso(List<SubProjeto> subProjetos, List<Progresso> listaInsertProgresso) {
		List<Progresso> listaProgresso = new ArrayList<Progresso>();
		subProjetos.forEach((subProjeto)->{
			listaProgresso.add(new Progresso(subProjeto));
			subProjeto.getNivelSubProjeto().forEach((nivel)->{
				Progresso novoProgresso = new Progresso(nivel);
				if(!listaInsertProgresso.contains(novoProgresso)) {
					listaProgresso.add(novoProgresso);
				}
			});
		});
		return listaProgresso;
	
	}
}
