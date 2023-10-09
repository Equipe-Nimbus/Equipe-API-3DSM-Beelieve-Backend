package com.api.beelieve.entidades.projeto.servico;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.api.beelieve.entidades.projeto.Projeto;
import com.api.beelieve.entidades.projeto.dto.DadosProjetoListagemGeral;


@Service
public class ListaProjetoGeral {	
	
	public List<DadosProjetoListagemGeral> listarProjetos(List<Projeto> listaProjetos) {
		List<DadosProjetoListagemGeral> listaFinal = new ArrayList<DadosProjetoListagemGeral>();
		for (Projeto projeto : listaProjetos) {
			DadosProjetoListagemGeral atributosProjeto = new DadosProjetoListagemGeral(
					projeto.getId_projeto(),
					projeto.getNome_projeto(),
					projeto.getDescricao_projeto(),
					projeto.getChefe_projeto(),
					projeto.getProgresso_projeto(),
					projeto.getData_inicio_projeto()
					);
			listaFinal.add(atributosProjeto);
		}
		System.out.println(listaFinal);
		return listaFinal;
	}
}
