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

import com.api.beelieve.entidades.AtualizaOrcamento;
import com.api.beelieve.entidades.projeto.AtualizarEstruturaProjetoNiveis;
import com.api.beelieve.entidades.projeto.DadosEstruturaProjetoAtualizacao;
import com.api.beelieve.entidades.projeto.DadosListagemProjeto;
import com.api.beelieve.entidades.projeto.DadosOrcamentoProjeto;
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
	private AtualizaOrcamento atualizaOrcamento;

	@Autowired
	private AtualizarEstruturaProjetoNiveis atualizaEstruturaProjeto;
	
	@PostMapping("/cadastrar")
	@Transactional
	public void cadastrar(@RequestBody DadosProjetoCadastro projeto) {
		repositorio_projeto.save(new Projeto(projeto));
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<DadosListagemProjeto>> listar() {
		List<DadosListagemProjeto> listaProjeto = repositorio_projeto.acharTodosProjetos();
		return ResponseEntity.ok(listaProjeto);
	}

	@GetMapping("/listar/{id}")
	public ResponseEntity<DadosListagemProjeto> listarId(@PathVariable Long id){
		DadosListagemProjeto projeto = repositorio_projeto.acharProjeto(id);
		return ResponseEntity.ok(projeto);
	}
	
	
	@PutMapping("/atualizar/estrutura")
	@Transactional
	public ResponseEntity<DadosListagemProjeto> atualizarEstrutura(@RequestBody DadosEstruturaProjetoAtualizacao dadosAtualizacao){
		atualizaEstruturaProjeto.atualizarProjeto(dadosAtualizacao.id_projeto(), dadosAtualizacao);
		DadosListagemProjeto projetoAtualizado = repositorio_projeto.acharProjeto(dadosAtualizacao.id_projeto());
		return ResponseEntity.ok(projetoAtualizado);
	}
	
	@PutMapping("/atualizar/orcamento")
	@Transactional
	public ResponseEntity<DadosListagemProjeto> atualizarOrcamento(@RequestBody DadosOrcamentoProjeto dadoOrcamentoProduto){
		atualizaOrcamento.atualizaOrcamento(dadoOrcamentoProduto);
		DadosListagemProjeto projetoAtualizado = repositorio_projeto.acharProjeto(dadoOrcamentoProduto.id_projeto());
		return ResponseEntity.ok(projetoAtualizado);
	}
}
