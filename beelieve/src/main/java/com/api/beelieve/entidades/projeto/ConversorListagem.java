package com.api.beelieve.entidades.projeto;

import java.util.ArrayList;
import java.util.List;

import com.api.beelieve.entidades.nivelsubprojeto.DadosListagemNivelSubProjeto;
import com.api.beelieve.entidades.nivelsubprojeto.NivelSubProjeto;
import com.api.beelieve.entidades.subprojeto.DadosListagemSubProjeto;
import com.api.beelieve.entidades.subprojeto.SubProjeto;
import com.api.beelieve.entidades.tarefa.DadosListagemTarefa;
import com.api.beelieve.entidades.tarefa.Tarefa;

public class ConversorListagem {
	
	public DadosListagemProjeto converterListagemProjeto(Projeto projeto) {
		DadosListagemProjeto dadosListagemProjeto = new DadosListagemProjeto(
				projeto.getId_projeto(),
				projeto.getOrdem_projeto(),
				projeto.getNome_projeto(),
				projeto.getChefe_projeto(),
				projeto.getProgresso_projeto(),
				projeto.getPrazo_projeto(),
				projeto.getDescricao_projeto(),
				projeto.getData_inicio_projeto(),
				projeto.getOrcamento_projeto(),
				projeto.getHora_humano_total(),
				projeto.getHora_valor_projeto(),
				this.converterListaSubProjeto(projeto.getSub_projetos()));
		
		return dadosListagemProjeto;
	}
	
	private List<DadosListagemSubProjeto> converterListaSubProjeto(List<SubProjeto> listaSubProjetoOriginal) {
		List<DadosListagemSubProjeto> dadosListaSubProjetos = new ArrayList<DadosListagemSubProjeto>();
		if(listaSubProjetoOriginal != null) {
			listaSubProjetoOriginal.forEach((subProjeto)->{
				dadosListaSubProjetos.add(new DadosListagemSubProjeto(
						subProjeto.getSub_projeto_id(),
						subProjeto.getOrdem_sub_projeto(),
						subProjeto.getNomeSubProjeto(),
						subProjeto.getChefeSubProjeto(),
						subProjeto.getPrazoSubProjeto(),
						subProjeto.getProgresso(),
						subProjeto.getOrcamentoSubProjeto(),
						subProjeto.getHoraHomemSubprojeto(),
						this.converterListaNivelSubProjeto(subProjeto.getNivelSubProjeto()),
						this.converterListaTarefa(subProjeto.getTarefas()))
						);
			});
		}
		return dadosListaSubProjetos;
	}

	private List<DadosListagemTarefa> converterListaTarefa(List<Tarefa> listaTarefaOriginal) {
		List<DadosListagemTarefa> dadosListagemTarefa = new ArrayList<DadosListagemTarefa>();
		if(listaTarefaOriginal != null) {
			listaTarefaOriginal.forEach((tarefa)->{
				dadosListagemTarefa.add(new DadosListagemTarefa(
						tarefa.getTarefa_id(),
						tarefa.getDescricaoAtividade(),
						tarefa.getResultadoEsperado(),
						tarefa.getPeso_tarefa(),
						tarefa.getStatus(),
						tarefa.getPrazo_tarefa()));
			});
		}
		
		return dadosListagemTarefa;
	}

	private List<DadosListagemNivelSubProjeto> converterListaNivelSubProjeto(List<NivelSubProjeto> listaNivelSubProjetoOriginal) {
		List<DadosListagemNivelSubProjeto> dadosListagemNivel = new ArrayList<DadosListagemNivelSubProjeto>();
		if(listaNivelSubProjetoOriginal != null) {
			listaNivelSubProjetoOriginal.forEach((nivelSubProjeto)->{
				dadosListagemNivel.add(new DadosListagemNivelSubProjeto(
						nivelSubProjeto.getId_nivel_sub_projeto(),
						nivelSubProjeto.getOrdem_nivel_sub_projeto(),
						nivelSubProjeto.getNome_nivel_sub_projeto(),
						nivelSubProjeto.getPrazo_nivel_sub_projeto(),
						nivelSubProjeto.getProgresso_nivel_sub_projeto(),
						nivelSubProjeto.getOrcamento_nivel_sub_projeto(),
						nivelSubProjeto.getHora_humano_nivel_sub_projeto(),
						this.converterListaTarefa(nivelSubProjeto.getTarefas())));
			});
		}
		return dadosListagemNivel;
	}
}
