package com.api.beelieve.entidades.subprojeto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.api.beelieve.entidades.nivelsubprojeto.DadosListagemNivelSubProjeto;
import com.api.beelieve.entidades.nivelsubprojeto.NivelSubProjeto;
import com.api.beelieve.entidades.projeto.Projeto;
import com.api.beelieve.entidades.tarefa.DadosListagemTarefa;
import com.api.beelieve.entidades.tarefa.Tarefa;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

public record DadosListagemSubProjeto(
		
		Long id_sub_projeto,
		String ordem_sub_projeto,
		String nome_sub_projeto,
		String chefe_sub_projeto,
		Date prazo_sub_projeto,
		Double progresso_sub_projeto,
		BigDecimal orcamento_sub_projeto,
		BigDecimal hora_humano_sub_projeto,
		List<DadosListagemNivelSubProjeto> nivel_sub_projeto,
		List<DadosListagemTarefa> tarefas
		) {

}
