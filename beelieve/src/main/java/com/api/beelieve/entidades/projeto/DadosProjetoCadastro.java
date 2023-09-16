package com.api.beelieve.entidades.projeto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.api.beelieve.entidades.subprojeto.DadosSubProjetoCadastro;


public record DadosProjetoCadastro(
		String nome_projeto,
		String chefe_projeto,
		Date prazo_projeto,
		BigDecimal orcamento_projeto,
		BigDecimal hora_humano_total,
		Double progresso_projeto,
		List<DadosSubProjetoCadastro> sub_projeto
		) {

}
