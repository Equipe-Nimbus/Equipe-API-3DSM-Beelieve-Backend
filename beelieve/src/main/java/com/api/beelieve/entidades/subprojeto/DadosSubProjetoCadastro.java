package com.api.beelieve.entidades.subprojeto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;



import com.api.beelieve.entidades.nivelsubprojeto.DadosNivelSubProjetoCadastro;
import com.api.beelieve.entidades.tarefa.DadosTarefaCadastro;

public record DadosSubProjetoCadastro(
		String nome_sub_projeto,
		String ordem_sub_projeto,
		List<DadosNivelSubProjetoCadastro> nivel_sub_projeto
		) {

}
