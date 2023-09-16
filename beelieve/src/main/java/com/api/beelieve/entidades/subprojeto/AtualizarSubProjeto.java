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
		if(dadosSubProjeto.chefe_sub_projeto() != null) {
			subProjetoAtual.setChefeSubProjeto(dadosSubProjeto.chefe_sub_projeto());
		}
		if(dadosSubProjeto.hora_humano_sub_projeto() != null) {
			subProjetoAtual.setHoraHomemSubprojeto(dadosSubProjeto.hora_humano_sub_projeto());
		}
		if(dadosSubProjeto.nome_sub_projeto() != null) {
			subProjetoAtual.setNomeSubProjeto(dadosSubProjeto.nome_sub_projeto());
		}
		if(dadosSubProjeto.orcamento_sub_projeto() != null) {
			subProjetoAtual.setOrcamentoSubProjeto(dadosSubProjeto.orcamento_sub_projeto());
		}
		if(dadosSubProjeto.prazo_sub_projeto() != null) {
			subProjetoAtual.setPrazoSubProjeto(dadosSubProjeto.prazo_sub_projeto());
		}
		if(dadosSubProjeto.nivel_sub_projetos() != null) {
			lerListaDadosNivelSubProjeto.atualizarLista(dadosSubProjeto.nivel_sub_projetos(), subProjetoAtual);
			subProjetoAtual.setTarefas(null);
		}
		else if(dadosSubProjeto.tarefas() != null) {
			lerListaTarefa.atualizarListaSubProjeto(dadosSubProjeto.tarefas(), subProjetoAtual);
		}
		
		
	}

}
