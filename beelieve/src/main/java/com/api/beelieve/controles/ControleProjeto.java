package com.api.beelieve.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.beelieve.entidades.Projeto;
import com.api.beelieve.repositorio.ProjetoRepositorio;

@RestController
@RequestMapping("/projeto")
public class ControleProjeto {
	
	@Autowired
	private ProjetoRepositorio repositorio_projeto;
	
	@PostMapping("/cadastrar")
	public void cadastrar(@RequestBody Projeto projeto) {
		repositorio_projeto.save(projeto);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<Projeto>> listar() {
		var listaProjeto = repositorio_projeto.findAll();
		return ResponseEntity.ok(listaProjeto);
	}
}
