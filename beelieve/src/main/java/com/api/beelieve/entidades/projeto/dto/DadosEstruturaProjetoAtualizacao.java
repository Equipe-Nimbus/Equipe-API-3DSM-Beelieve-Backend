package com.api.beelieve.entidades.projeto.dto;


import java.math.BigDecimal;
import java.util.List;

import com.api.beelieve.entidades.subprojeto.dto.DadosEstruturaSubProjetoAtualizacao;



public record DadosEstruturaProjetoAtualizacao(
		Long id_projeto,
		String ordem_projeto,
		String nome_projeto,
		BigDecimal orcamento_projeto,
		BigDecimal hora_humano_total,
		BigDecimal materiais_projeto,
		List<DadosEstruturaSubProjetoAtualizacao> sub_projetos
		) 
{
	
}
