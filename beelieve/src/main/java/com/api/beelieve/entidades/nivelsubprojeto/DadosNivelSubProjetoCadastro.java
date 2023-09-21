package com.api.beelieve.entidades.nivelsubprojeto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.api.beelieve.entidades.tarefa.DadosTarefaCadastro;

public record DadosNivelSubProjetoCadastro(
		String nome_nivel_sub_projeto,
		String ordem_nivel_sub_projeto
		) {

}
