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
		if(dadosAtualizacao.nomeProjeto() != null) {
			projetoAtual.setNomeProjeto(dadosAtualizacao.nomeProjeto());
		}
		if(dadosAtualizacao.chefeProjeto() != null) {
			projetoAtual.setChefeProjeto(dadosAtualizacao.chefeProjeto());
		}
		if(dadosAtualizacao.prazoProjeto() != null) {
			projetoAtual.setPrazoProjeto(dadosAtualizacao.prazoProjeto());
		}
		if(dadosAtualizacao.orcamentoProjeto() != null) {
			projetoAtual.setOrcamentoProjeto(dadosAtualizacao.orcamentoProjeto());
		}
		if(dadosAtualizacao.horaHumanoTotal() != null) {
			projetoAtual.setHoraHomemTotal(dadosAtualizacao.horaHumanoTotal());
		}
		if(dadosAtualizacao.subProjetos() != null) {
			List<SubProjeto> listaSubProjeto = listaSubNivel.atualizarLista(dadosAtualizacao.subProjetos(), projetoAtual);
			projetoAtual.setSubProjeto(listaSubProjeto);
		}
		
	}
}
