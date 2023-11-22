package com.api.beelieve.entidades.analista_projeto.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.beelieve.entidades.analista_projeto.AnalistaProjeto;
import com.api.beelieve.entidades.projeto.Projeto;
import com.api.beelieve.repositorio.Analista_ProjetoRepositorio;

import jakarta.transaction.Transactional;

@Service
public class DeleteAtribuicaoAnalista {
	
	@Autowired
	private Analista_ProjetoRepositorio repositorio_relacao_analista;
	
	
	@Transactional
	public void deleteAtribuicao(Projeto projeto) {
		List<AnalistaProjeto> analistas = projeto.getAnalistasAtribuidos();
		
		analistas.forEach((analistaAtribuido)->{
			Long relaçãoId = analistaAtribuido.getId_relacao_analista_projeto();
			repositorio_relacao_analista.deleteById(relaçãoId);
		});
	}
}
