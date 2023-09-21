package com.api.beelieve.entidades.projeto;


import java.util.List;


import com.api.beelieve.entidades.subprojeto.DadosEstruturaSubProjetoAtualizacao;



public record DadosEstruturaProjetoAtualizacao(
		Long id_projeto,
		String ordem_projeto,
		String nome_projeto,
		List<DadosEstruturaSubProjetoAtualizacao> sub_projeto
		) 
{
	
}
