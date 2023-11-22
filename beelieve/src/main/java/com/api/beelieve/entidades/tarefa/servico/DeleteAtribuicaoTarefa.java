package com.api.beelieve.entidades.tarefa.servico;

import org.springframework.stereotype.Service;

import com.api.beelieve.entidades.tarefa.Tarefa;

@Service
public class DeleteAtribuicaoTarefa {
	
	public void deleteAtribuicao(Tarefa tarefa) {
		if(tarefa.getAtribuicao() != null) {
			tarefa.setAtribuicao(null);
		}
	}
}
