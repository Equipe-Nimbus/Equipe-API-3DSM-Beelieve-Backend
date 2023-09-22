package com.api.beelieve.entidades.subprojeto;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

import com.api.beelieve.entidades.nivelsubprojeto.DadosEstruturaNivelSubProjetoAtualizacao;
import com.api.beelieve.entidades.tarefa.DadosTarefaAtualizacao;

public record DadosEstruturaSubProjetoAtualizacao(
		Long id_sub_projeto,
		String nome_sub_projeto,
		String ordem_sub_projeto,
		List<DadosEstruturaNivelSubProjetoAtualizacao> nivel_sub_projeto
		) 
{

}
