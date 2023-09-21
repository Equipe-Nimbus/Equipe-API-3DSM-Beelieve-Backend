package com.api.beelieve.entidades.projeto;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.beelieve.entidades.subprojeto.EstruturaSubProjetoAtualizacao;
import com.api.beelieve.repositorio.ProjetoRepositorio;

@Service
public class AtualizarEstruturaProjetoNiveis {
	
	@Autowired
	private ProjetoRepositorio repositorio_projeto;
	
	@Autowired
	private EstruturaSubProjetoAtualizacao atualizaEstruturaProjeto;
	
	
	public void atualizarProjeto(Long id, DadosEstruturaProjetoAtualizacao dadosAtualizacao) {
		Projeto projetoAtual = repositorio_projeto.findById(id).get();
		projetoAtual.setNome_projeto(dadosAtualizacao.nome_projeto());
		if(dadosAtualizacao.sub_projeto() != null && !dadosAtualizacao.sub_projeto().isEmpty()) {
			atualizaEstruturaProjeto.atualizarEstrutura(dadosAtualizacao.sub_projeto(), projetoAtual);
		}
	}

}
