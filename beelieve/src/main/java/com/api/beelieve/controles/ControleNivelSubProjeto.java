package com.api.beelieve.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.beelieve.entidades.NivelSubProjeto;
import com.api.beelieve.repositorio.NivelSubProjetoRepositorio;

@RestController
@RequestMapping("/nivel_sub_projeto")
public class ControleNivelSubProjeto {
	
	@Autowired
	private NivelSubProjetoRepositorio repositorio_nivel_sub_projeto;
	
	@PostMapping("/cadastrar")
	public void cadastrar(@RequestBody NivelSubProjeto nivel_sub_projeto) {
		repositorio_nivel_sub_projeto.save(nivel_sub_projeto);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<NivelSubProjeto>> listar() {
		var listar_nivel_sub_projeto = repositorio_nivel_sub_projeto.findAll();
		return ResponseEntity.ok(listar_nivel_sub_projeto);
	}
}
