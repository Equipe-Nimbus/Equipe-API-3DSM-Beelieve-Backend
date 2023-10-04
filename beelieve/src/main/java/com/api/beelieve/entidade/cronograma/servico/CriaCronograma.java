package com.api.beelieve.entidade.cronograma.servico;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.beelieve.entidade.cronograma.Cronograma;
import com.api.beelieve.entidade.cronograma.Mes;
import com.api.beelieve.entidade.cronograma.Progresso;
import com.api.beelieve.entidades.projeto.Projeto;
import com.api.beelieve.entidades.projeto.dto.DadosProjetoCadastro;
import com.api.beelieve.repositorio.CronogramaRepositorio;

@Service
public class CriaCronograma {
	
	@Autowired
	private CronogramaRepositorio cronograma_repositorio;
	
	@Autowired
	private CriaListaProgresso criaListaProgresso;
	
	@Autowired
	private CriaListaMeses criaMeses;

	public void criarCronograma(Projeto projeto, Integer prazo) {
		List<Progresso> niveis = criaListaProgresso.criarListaProgresso(projeto);
		Object criaListaMeses;
		List<Mes> meses = criaMeses.criarListaMeses(prazo, niveis);
		cronograma_repositorio.insert(new Cronograma(projeto.getId_projeto(), meses));
		
	}
}
