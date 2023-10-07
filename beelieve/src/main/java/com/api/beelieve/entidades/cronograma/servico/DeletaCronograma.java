package com.api.beelieve.entidades.cronograma.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.beelieve.entidades.cronograma.Cronograma;
import com.api.beelieve.repositorio.CronogramaRepositorio;

@Service
public class DeletaCronograma {
	
	@Autowired
	private CronogramaRepositorio repositorio_cronograma;
	
	
	public void deletar(Long id) {
		Cronograma cronogramaEscolhido = repositorio_cronograma.findById(id).get();
		repositorio_cronograma.delete(cronogramaEscolhido);
	}
}
