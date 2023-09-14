package com.api.beelieve.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.beelieve.entidades.SubProjeto;
import com.api.beelieve.repositorio.SubProjetoRepositorio;

@RestController
@RequestMapping("/sub_projeto")
public class ControleSubProjeto {
	
	@Autowired
	private SubProjetoRepositorio repositorio_sub_projeto;
	
	@PostMapping("/cadastrar")
	public void cadastrar(@RequestBody SubProjeto sub_projeto) {
		repositorio_sub_projeto.save(sub_projeto);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<SubProjeto>> listar() {
		var lista_sub_projeto = repositorio_sub_projeto.findAll();
		return ResponseEntity.ok(lista_sub_projeto);
	}
}
