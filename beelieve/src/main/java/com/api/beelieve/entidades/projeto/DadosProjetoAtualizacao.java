package com.api.beelieve.entidades.projeto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


import com.api.beelieve.entidades.subprojeto.DadosSubProjetoAtualizacao;

public record DadosProjetoAtualizacao(
		Long id_projeto,
		String nome_projeto,
		String chefe_projeto,
		Date prazo_projeto,
		BigDecimal orcamento_projeto,
		BigDecimal hora_humano_total,
		List<DadosSubProjetoAtualizacao> sub_projetos
		) 
{
	
}
