package com.api.beelieve.entidades.projeto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.beelieve.entidades.subprojeto.LeituraListaSubProjetoAtualizacao;
import com.api.beelieve.entidades.subprojeto.SubProjeto;

@Service
public class AtualizarProjeto {
	
	@Autowired
	private LeituraListaSubProjetoAtualizacao listaSubNivel;
	
	public void atualizar(Projeto projetoAtual, DadosProjetoAtualizacao dadosAtualizacao) {
		if(dadosAtualizacao.nome_projeto() != null) {
			projetoAtual.setNome_projeto(dadosAtualizacao.nome_projeto());
		}
		if(dadosAtualizacao.chefe_projeto() != null) {
			projetoAtual.setChefe_projeto(dadosAtualizacao.chefe_projeto());
		}
		if(dadosAtualizacao.prazo_projeto() != null) {
			projetoAtual.setPrazo_projeto(dadosAtualizacao.prazo_projeto());
		}
		if(dadosAtualizacao.orcamento_projeto() != null) {
			projetoAtual.setOrcamento_projeto(dadosAtualizacao.orcamento_projeto());
		}
		if(dadosAtualizacao.hora_humano_total() != null) {
			projetoAtual.setHora_humano_total(dadosAtualizacao.hora_humano_total());
		}
		if(dadosAtualizacao.sub_projetos() != null) {
			List<SubProjeto> listaSubProjeto = listaSubNivel.atualizarLista(dadosAtualizacao.sub_projetos(), projetoAtual);
			projetoAtual.setSub_projetos(listaSubProjeto);
		}
		
	}
}
