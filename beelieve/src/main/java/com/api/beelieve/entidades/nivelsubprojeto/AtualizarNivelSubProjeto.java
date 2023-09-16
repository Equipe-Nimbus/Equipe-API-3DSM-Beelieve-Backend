package com.api.beelieve.entidades.nivelsubprojeto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.api.beelieve.entidades.tarefa.LeituraListaTarefa;

@Service
public class AtualizarNivelSubProjeto {
	
	@Autowired
	private LeituraListaTarefa leituraListaTarefa;

	public void atualizar(NivelSubProjeto nivelSubProjetoAtual, DadosNivelSubProjetoAtualizacao dadosNivelSubProjeto) {
		if(dadosNivelSubProjeto.hora_humano_nivel_sub_projeto() != null) {
			nivelSubProjetoAtual.setHoraNivelHomemSubProjeto(dadosNivelSubProjeto.hora_humano_nivel_sub_projeto());
		}
		if(dadosNivelSubProjeto.nome_nivel_sub_projeto() != null) {
			nivelSubProjetoAtual.setNomeNivelSubProjeto(dadosNivelSubProjeto.nome_nivel_sub_projeto());
		}
		if(dadosNivelSubProjeto.orcamento_nivel_sub_projeto() != null) {
			nivelSubProjetoAtual.setOrcamentoNivelSubProjeto(dadosNivelSubProjeto.orcamento_nivel_sub_projeto());
		}
		if(dadosNivelSubProjeto.prazo_nivel_sub_projeto() != null) {
			nivelSubProjetoAtual.setPrazoNivelSubProjeto(dadosNivelSubProjeto.prazo_nivel_sub_projeto());
		}
		if(dadosNivelSubProjeto.tarefas() != null) {
			leituraListaTarefa.atualizarListaNivel(dadosNivelSubProjeto.tarefas(), nivelSubProjetoAtual);
		}
		
		
	}


}
