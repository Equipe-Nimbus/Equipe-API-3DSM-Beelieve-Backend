package com.api.beelieve.entidades.nivelsubprojeto;


import java.util.List;

import com.api.beelieve.entidades.tarefa.DadosTarefaAtualizacao;

public record DadosEstruturaNivelSubProjetoAtualizacao(
		Long id_nivel_sub_projeto,
		String nome_nivel_sub_projeto,
		String ordem_nivel_sub_projeto,
		List<DadosTarefaAtualizacao> tarefas
		) 
{

}
