package com.api.beelieve.entidades.projeto;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.beelieve.repositorio.ProjetoRepositorio;

@Service
public class AtualizarProjetoNiveis {
	
	@Autowired
	private ProjetoRepositorio repositorio_projeto;
	
	@Autowired
	private AtualizarProjeto atualizarProjeto;
	
	
	public void atualizarProjeto(Long id, DadosProjetoAtualizacao dadosAtualizacao) {
		Optional<Projeto> projetoAtual = repositorio_projeto.findById(id);
		atualizarProjeto.atualizar(projetoAtual.get(), dadosAtualizacao);
	}

}
