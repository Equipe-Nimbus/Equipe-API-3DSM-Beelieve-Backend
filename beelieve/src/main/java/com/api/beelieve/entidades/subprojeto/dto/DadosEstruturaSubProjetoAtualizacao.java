package com.api.beelieve.entidades.subprojeto.dto;

import java.util.List;

import com.api.beelieve.entidades.nivelsubprojeto.dto.DadosEstruturaNivelSubProjetoAtualizacao;

public record DadosEstruturaSubProjetoAtualizacao(
		Long id_sub_projeto,
		String nome_sub_projeto,
		String ordem_sub_projeto,
		List<DadosEstruturaNivelSubProjetoAtualizacao> nivel_sub_projeto
		) 
{

}
