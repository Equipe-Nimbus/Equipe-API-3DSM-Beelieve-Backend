package com.api.beelieve.entidades.projeto.servico;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.beelieve.entidades.projeto.Projeto;
import com.api.beelieve.entidades.projeto.dto.DadosEstruturaProjetoAtualizacao;
import com.api.beelieve.entidades.subprojeto.servico.EstruturaSubProjetoAtualizacao;
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
		if(dadosAtualizacao.sub_projetos() != null) {
			atualizaEstruturaProjeto.atualizarEstrutura(dadosAtualizacao.sub_projetos(), projetoAtual);
		}
	}

}
