package com.api.beelieve.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.beelieve.entidades.Projeto;
import com.api.beelieve.repositorio.ProjetoRepositorio;

@RestController
@RequestMapping("/listaProjetos")
public class ListagemControle {
	
	@Autowired
	private ProjetoRepositorio projetoRepositorio;
	
	@GetMapping("/projeto")
	public ResponseEntity<List<Projeto>> ListarProjeto() {
		var lista = projetoRepositorio.findAll();
		return ResponseEntity.ok(lista);
	}
}
