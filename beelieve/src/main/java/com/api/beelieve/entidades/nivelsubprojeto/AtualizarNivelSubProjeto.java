package com.api.beelieve.entidades.nivelsubprojeto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.api.beelieve.entidades.tarefa.LeituraListaTarefa;

@Service
public class AtualizarNivelSubProjeto {
	
	@Autowired
	private LeituraListaTarefa leituraListaTarefa;

	public void atualizar(NivelSubProjeto nivelSubProjetoAtual, DadosNivelSubProjetoAtualizacao dadosNivelSubProjeto) {
		if(dadosNivelSubProjeto.horaHomemNivelSubProjeto() != null) {
			nivelSubProjetoAtual.setHoraNivelHomemSubProjeto(dadosNivelSubProjeto.horaHomemNivelSubProjeto());
		}
		if(dadosNivelSubProjeto.nomeNivelSubProjeto() != null) {
			nivelSubProjetoAtual.setNomeNivelSubProjeto(dadosNivelSubProjeto.nomeNivelSubProjeto());
		}
		if(dadosNivelSubProjeto.orcamentoNivelSubProjeto() != null) {
			nivelSubProjetoAtual.setOrcamentoNivelSubProjeto(dadosNivelSubProjeto.orcamentoNivelSubProjeto());
		}
		if(dadosNivelSubProjeto.prazoNivelSubProjeto() != null) {
			nivelSubProjetoAtual.setPrazoNivelSubProjeto(dadosNivelSubProjeto.prazoNivelSubProjeto());
		}
		if(dadosNivelSubProjeto.tarefas() != null) {
			leituraListaTarefa.atualizarListaNivel(dadosNivelSubProjeto.tarefas(), nivelSubProjetoAtual);
		}
		
		
	}


}
