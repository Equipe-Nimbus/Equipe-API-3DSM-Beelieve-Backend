package com.api.beelieve.entidades.projeto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.api.beelieve.entidades.subprojeto.DadosSubProjetoCadastro;


public record DadosProjetoCadastro(
		String nomeProjeto,
		String chefeProjeto,
		Date prazoProjeto,
		BigDecimal orcamentoProjeto,
		BigDecimal horaHomemTotal,
		BigDecimal progressoProjeto,
		List<DadosSubProjetoCadastro> subProjeto
		) {

}
