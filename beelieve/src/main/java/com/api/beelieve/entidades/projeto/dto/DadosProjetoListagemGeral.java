package com.api.beelieve.entidades.projeto.dto;

import java.util.Date;

public record DadosProjetoListagemGeral(
	Long id_projeto,
	String nome_projeto,
	String descricao_projeto,
	String chefe_projeto,
	Double progresso_projeto,
	Date data_inicio_projeto
	) {
	
}
