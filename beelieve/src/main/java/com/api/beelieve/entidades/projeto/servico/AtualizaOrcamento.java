package com.api.beelieve.entidades.projeto.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.beelieve.entidades.nivelsubprojeto.NivelSubProjeto;
import com.api.beelieve.entidades.nivelsubprojeto.dto.DadosOrcamentoNivelSubProjeto;
import com.api.beelieve.entidades.projeto.Projeto;
import com.api.beelieve.entidades.projeto.dto.DadosOrcamentoProjeto;
import com.api.beelieve.entidades.subprojeto.SubProjeto;
import com.api.beelieve.entidades.subprojeto.dto.DadosOrcamentoSubProjeto;
import com.api.beelieve.repositorio.ProjetoRepositorio;

@Service
public class AtualizaOrcamento {
	
	@Autowired
	ProjetoRepositorio repositorio_projeto;
	
	
	
	public void atualizaOrcamento(DadosOrcamentoProjeto orcamentoProjeto) {
		Projeto projeto = repositorio_projeto.findById(orcamentoProjeto.id_projeto()).get();
		
		projeto.setOrcamento_projeto(orcamentoProjeto.orcamento_projeto());
		projeto.setChefe_projeto(orcamentoProjeto.chefe_projeto());
		projeto.setHora_humano_total(orcamentoProjeto.hora_humano_total());
		projeto.setHora_valor_projeto(orcamentoProjeto.hora_valor_projeto());
		System.out.println(orcamentoProjeto);
		if(orcamentoProjeto.sub_projetos() != null) {
			this.atualizaOrcamentoSubProjeto(orcamentoProjeto.sub_projetos(), projeto.getSub_projetos());
		}
		
		
	}
	
	public void atualizaOrcamentoSubProjeto(List<DadosOrcamentoSubProjeto> listaOrcamentoSub, List<SubProjeto> listaSubProjeto) {
		listaOrcamentoSub.forEach((orcamentoSub)->{
			listaSubProjeto.forEach((subProjeto)->{
				if(orcamentoSub.id_sub_projeto() == subProjeto.getSub_projeto_id()) {
					subProjeto.setOrcamentoSubProjeto(orcamentoSub.orcamento_sub_projeto());
					subProjeto.setHoraHomemSubprojeto(orcamentoSub.hora_humano_sub_projeto());
					subProjeto.setChefeSubProjeto(orcamentoSub.chefe_sub_projeto());
					if(orcamentoSub.nivel_sub_projeto() != null) {
						this.atualizaOrcamentoNivelSubProjeto(orcamentoSub.nivel_sub_projeto(), subProjeto.getNivelSubProjeto());
					}
				}
			});
		});
	}
	
	public void atualizaOrcamentoNivelSubProjeto(List<DadosOrcamentoNivelSubProjeto> listaOrcamentoNivel, List<NivelSubProjeto> listaNivelSub) {
		listaOrcamentoNivel.forEach((orcamentoNivel)->{
			listaNivelSub.forEach((nivelSub)->{
				if(orcamentoNivel.id_nivel_sub_projeto() == nivelSub.getId_nivel_sub_projeto()) {
					nivelSub.setHora_humano_nivel_sub_projeto(orcamentoNivel.hora_humano_nivel_sub_projeto());
					nivelSub.setOrcamento_nivel_sub_projeto(orcamentoNivel.orcamento_nivel_sub_projeto());
					nivelSub.setGrupo_nivel_sub_projeto(orcamentoNivel.grupo_nivel_sub_projeto());
				}
			});
		});
	}
}
