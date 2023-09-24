package com.api.beelieve.entidades.subprojeto;

import java.util.List;

import com.api.beelieve.entidades.nivelsubprojeto.DadosNivelSubProjetoCadastro;

public record DadosSubProjetoCadastro(

		Long projeto_id,
		String ordem_sub_projeto,
		String nome_sub_projeto,
		List<DadosNivelSubProjetoCadastro> nivel_sub_projeto
		) {

}
