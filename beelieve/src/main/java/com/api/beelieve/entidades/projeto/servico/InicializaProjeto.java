package com.api.beelieve.entidades.projeto.servico;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.beelieve.entidades.projeto.Projeto;
import com.api.beelieve.repositorio.ProjetoRepositorio;


@Service
public class InicializaProjeto {
	
	@Autowired
	private ProjetoRepositorio repositorio_projeto;
	
	public Optional<String> setaData(Long id, String data) throws Exception {
		Date date = null;
		Optional<Projeto> foundProject = repositorio_projeto.findById(id);
		if (foundProject.isEmpty()) {
			throw new Exception(String.format("Projeto com id %d não existe", id));
		}
		
		var formatter = new SimpleDateFormat("MM-yyyy");
		try {
			var projeto = foundProject.get();
			date = formatter.parse(data);
			projeto.setData_inicio_projeto(date);
			repositorio_projeto.save(projeto);
			return Optional.of(date.toString());
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
}

