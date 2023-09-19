package com.api.beelieve.entidades.projeto;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SelecionarProjeto {
	
	public Projeto selecionar(List<Projeto> projetos, Long id) {
		Projeto escolhido = null;
		for (Projeto projeto : projetos) {
			if (projeto.getId_projeto() == id) {
				escolhido = projeto;
			}
		}
		
		return escolhido;
	}
}
