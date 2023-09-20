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
		var listaProjeto = repositorio_projeto.acharTodosProjetos();
		return ResponseEntity.ok(listaProjeto);
	}

	@GetMapping("/listar/{id}")
	public ResponseEntity<Projeto> listarId(@PathVariable Long id){
		Projeto projeto = repositorio_projeto.acharProjeto(id);
		return ResponseEntity.ok(projeto);
	}
	
	@PutMapping("/atualizar")
	@Transactional
	public ResponseEntity<Projeto> atualizar(@RequestBody DadosProjetoAtualizacao dadosAtualizacao){
		System.out.println(dadosAtualizacao);
		atualizaProjeto.atualizarProjeto(dadosAtualizacao.id_projeto(), dadosAtualizacao);
		Projeto projetoAtualizado = repositorio_projeto.acharProjeto(dadosAtualizacao.id_projeto());
		return ResponseEntity.ok(projetoAtualizado);
	}
}
