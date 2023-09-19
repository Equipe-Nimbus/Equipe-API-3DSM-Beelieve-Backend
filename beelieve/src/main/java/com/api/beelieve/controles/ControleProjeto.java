package com.api.beelieve.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.beelieve.entidades.projeto.AtualizarProjetoNiveis;
import com.api.beelieve.entidades.projeto.DadosProjetoAtualizacao;
import com.api.beelieve.entidades.projeto.DadosProjetoCadastro;
import com.api.beelieve.entidades.projeto.Projeto;
import com.api.beelieve.repositorio.ProjetoRepositorio;

import jakarta.transaction.Transactional;


@RestController
@RequestMapping("/projeto")
public class ControleProjeto {
	
	@Autowired
	private ProjetoRepositorio repositorio_projeto;
	

	@Autowired
	private AtualizarProjetoNiveis atualizaProjeto;
	
	@PostMapping("/cadastrar")
	@Transactional
	public void cadastrar(@RequestBody DadosProjetoCadastro projeto) {
		repositorio_projeto.save(new Projeto(projeto));
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<Projeto>> listar() {
		var listaProjeto = repositorio_projeto.findAll();
		return ResponseEntity.ok(listaProjeto);
	}

	
	@PutMapping("/atualizar/{id}")
	@Transactional
	public ResponseEntity atualizar(@PathVariable Long id, @RequestBody DadosProjetoAtualizacao dadosAtualizacao){
		System.out.println(dadosAtualizacao);
		atualizaProjeto.atualizarProjeto(id, dadosAtualizacao);
		
		return ResponseEntity.ok().build();
	}

}
