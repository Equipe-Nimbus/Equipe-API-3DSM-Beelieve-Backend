package com.api.beelieve.entidades.projeto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


import com.api.beelieve.entidades.subprojeto.DadosSubProjetoAtualizacao;

public record DadosProjetoAtualizacao(
		Long projeto_id,
		String nomeProjeto,
		String chefeProjeto,
		Date prazoProjeto,
		BigDecimal orcamentoProjeto,
		BigDecimal horaHumanoTotal,
		List<DadosSubProjetoAtualizacao> subProjetos
		) 
{
	
}
