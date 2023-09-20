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
import com.api.beelieve.entidades.projeto.DadosProjetoListagemGeral;
import com.api.beelieve.entidades.projeto.ListaProjetoGeral;
import com.api.beelieve.entidades.projeto.Projeto;
import com.api.beelieve.entidades.projeto.SelecionarProjeto;
import com.api.beelieve.repositorio.ProjetoRepositorio;

import jakarta.transaction.Transactional;


@RestController
@RequestMapping("/projeto")
public class ControleProjeto {
	
	@Autowired
	private ProjetoRepositorio repositorio_projeto;
	
	@Autowired
	private ListaProjetoGeral listaProjeto;

	@Autowired
	private AtualizarProjetoNiveis atualizaProjeto;
	
	@Autowired
	private SelecionarProjeto selecionaProjeto;
	
	@PostMapping("/cadastrar")
	@Transactional
	public void cadastrar(@RequestBody DadosProjetoCadastro projeto) {
		repositorio_projeto.save(new Projeto(projeto));
	}
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<Projeto> listarProjetoUnico(@PathVariable Long id) {
		Projeto projetoSelecionado = repositorio_projeto.findById(id).get();
		Projeto  projetoTratado = selecionaProjeto.selecionar(projetoSelecionado);
		return ResponseEntity.ok(projetoTratado);
	}
	
	@GetMapping("/listar")
	@Transactional
	public ResponseEntity<List<DadosProjetoListagemGeral>> listar() {
		List<DadosProjetoListagemGeral> resultado = listaProjeto.listarProjetos(repositorio_projeto.findAll());
		return ResponseEntity.ok(resultado);
	}

	
	@PutMapping("/atualizar/{id}")
	@Transactional
	public ResponseEntity<Projeto> atualizar(@PathVariable Long id, @RequestBody DadosProjetoAtualizacao dadosAtualizacao){
		//System.out.println(dadosAtualizacao);
		atualizaProjeto.atualizarProjeto(id, dadosAtualizacao);
		
		return ResponseEntity.ok().build();
	}

}
