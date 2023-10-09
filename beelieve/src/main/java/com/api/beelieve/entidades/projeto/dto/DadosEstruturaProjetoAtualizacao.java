package com.api.beelieve.entidades.projeto.dto;


import java.util.List;

import com.api.beelieve.entidades.subprojeto.dto.DadosEstruturaSubProjetoAtualizacao;



public record DadosEstruturaProjetoAtualizacao(
		Long id_projeto,
		String ordem_projeto,
		String nome_projeto,
		List<DadosEstruturaSubProjetoAtualizacao> sub_projetos
		) 
{
	
}
