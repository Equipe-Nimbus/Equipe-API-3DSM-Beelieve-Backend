package com.api.beelieve.entidades.projeto;

import java.math.BigDecimal;
import java.util.List;

import com.api.beelieve.entidades.subprojeto.DadosSubProjetoCadastro;


public record DadosProjetoCadastro(
		String ordem_projeto,
		String nome_projeto,
		String descricao_projeto,
		BigDecimal hora_valor_projeto,
		Double progresso_projeto,
		List<DadosSubProjetoCadastro> sub_projetos

		) {

}
