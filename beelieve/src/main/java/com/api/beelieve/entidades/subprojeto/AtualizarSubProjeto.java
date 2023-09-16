package com.api.beelieve.entidades.subprojeto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.beelieve.entidades.nivelsubprojeto.LeituraListaNivelSubProjeto;
import com.api.beelieve.entidades.tarefa.LeituraListaTarefa;

import jakarta.transaction.Transactional;

@Service
public class AtualizarSubProjeto {

	@Autowired
	private LeituraListaNivelSubProjeto lerListaDadosNivelSubProjeto;
	
	@Autowired
	private LeituraListaTarefa lerListaTarefa;
	
	@Transactional
	public void atualizar(SubProjeto subProjetoAtual, DadosSubProjetoAtualizacao dadosSubProjeto) {
		if(dadosSubProjeto.chefeSubProjeto() != null) {
			subProjetoAtual.setChefeSubProjeto(dadosSubProjeto.chefeSubProjeto());
		}
		if(dadosSubProjeto.horaHumanoSubProjeto() != null) {
			subProjetoAtual.setHoraHomemSubprojeto(dadosSubProjeto.horaHumanoSubProjeto());
		}
		if(dadosSubProjeto.nomeSubProjeto() != null) {
			subProjetoAtual.setNomeSubProjeto(dadosSubProjeto.nomeSubProjeto());
		}
		if(dadosSubProjeto.orcamentoSubProjeto() != null) {
			subProjetoAtual.setOrcamentoSubProjeto(dadosSubProjeto.orcamentoSubProjeto());
		}
		if(dadosSubProjeto.prazoSubProjeto() != null) {
			subProjetoAtual.setPrazoSubProjeto(dadosSubProjeto.prazoSubProjeto());
		}
		if(dadosSubProjeto.nivelSubProjetos() != null) {
			lerListaDadosNivelSubProjeto.atualizarLista(dadosSubProjeto.nivelSubProjetos(), subProjetoAtual);
			subProjetoAtual.setTarefas(null);
		}
		else if(dadosSubProjeto.tarefas() != null) {
			lerListaTarefa.atualizarListaSubProjeto(dadosSubProjeto.tarefas(), subProjetoAtual);
		}
		
		
	}

}
