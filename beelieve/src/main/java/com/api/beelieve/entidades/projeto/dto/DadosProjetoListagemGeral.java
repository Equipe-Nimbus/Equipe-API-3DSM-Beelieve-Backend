package com.api.beelieve.entidades.projeto.dto;

public record DadosProjetoListagemGeral(
	Long id_projeto,
	String nome_projeto,
	String descricao_projeto,
	String chefe_projeto,
	Double progresso_projeto
	) {
	
}
