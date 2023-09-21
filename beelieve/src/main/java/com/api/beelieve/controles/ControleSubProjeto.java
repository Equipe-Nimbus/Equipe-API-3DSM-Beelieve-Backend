package com.api.beelieve.controles;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.beelieve.entidades.projeto.Projeto;
import com.api.beelieve.entidades.subprojeto.DadosSubProjetoCadastro;
import com.api.beelieve.entidades.subprojeto.SubProjeto;
import com.api.beelieve.repositorio.ProjetoRepositorio;
import com.api.beelieve.repositorio.SubProjetoRepositorio;

@RestController
@RequestMapping("/sub_projeto")
public class ControleSubProjeto {
	
	@Autowired
	private SubProjetoRepositorio repositorio_sub_projeto;
	
	@Autowired
	private ProjetoRepositorio repositorio_projeto;
	
	/*@PostMapping("/cadastrar")
	public ResponseEntity<SubProjeto> cadastrar(@RequestBody DadosSubProjetoCadastro sub_projeto) {
		Optional<Projeto> projetoPai = repositorio_projeto.findById(sub_projeto.projeto_id());
		repositorio_sub_projeto.save(new SubProjeto(sub_projeto, projetoPai.get()));
		return ResponseEntity.ok(subProjetoCadastrado);
	}*/
	
	@GetMapping("/listar")
	public ResponseEntity<List<SubProjeto>> listar() {
		var lista_sub_projeto = repositorio_sub_projeto.findAll();
		return ResponseEntity.ok(lista_sub_projeto);
	}
}
