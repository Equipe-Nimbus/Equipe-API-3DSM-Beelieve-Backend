package com.api.beelieve.entidades.projeto.servico;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.beelieve.entidades.cronograma.Progresso;
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
	
	private List<Progresso> listaProgresso;
	
	public List<Progresso> atualizarProjeto(Long id, DadosEstruturaProjetoAtualizacao dadosAtualizacao) {
		Projeto projetoAtual = repositorio_projeto.findById(id).get();
		projetoAtual.setNome_projeto(dadosAtualizacao.nome_projeto());
		projetoAtual.setOrcamento_projeto(dadosAtualizacao.orcamento_projeto());
		projetoAtual.setHora_humano_total(dadosAtualizacao.hora_humano_total());
		projetoAtual.setMateriais_projeto(dadosAtualizacao.materiais_projeto());
		if(dadosAtualizacao.sub_projetos() != null) {
			listaProgresso = atualizaEstruturaProjeto.atualizarEstrutura(dadosAtualizacao.sub_projetos(), projetoAtual);
		}

		return listaProgresso;
	}

}
