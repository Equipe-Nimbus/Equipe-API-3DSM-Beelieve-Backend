package com.api.beelieve.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.beelieve.entidades.tarefa.Tarefa;
import com.api.beelieve.repositorio.TarefaRepositorio;

@RestController
@RequestMapping("/tarefa")
public class ControleTarefa {
	
	@Autowired
	private TarefaRepositorio repositorio_tarefa;
	
	@PostMapping("/cadastrar")
	public void cadastrar(@RequestBody Tarefa tarefa) {
		repositorio_tarefa.save(tarefa);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<Tarefa>> listar() {
		var lista_tarefa = repositorio_tarefa.findAll();
		return ResponseEntity.ok(lista_tarefa);
	}
	

}
