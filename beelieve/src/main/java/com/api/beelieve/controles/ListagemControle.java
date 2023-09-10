package com.api.beelieve.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.beelieve.entidades.Projeto;
import com.api.beelieve.entidades.SubProjeto;
import com.api.beelieve.entidades.Tarefa;
import com.api.beelieve.entidades.tipoProjeto;
import com.api.beelieve.repositorio.ModuloSubProjetoRepositorio;
import com.api.beelieve.repositorio.ProjetoRepositorio;
import com.api.beelieve.repositorio.SubProjetoRepositorio;
import com.api.beelieve.repositorio.TarefaRepositorio;

@RestController
@RequestMapping("/listagens")
public class ListagemControle {
	
	@Autowired
	private ProjetoRepositorio projetoRepositorio;
	
	@Autowired
	private SubProjetoRepositorio subProjetoRepositorio;
	
	@Autowired
	private TarefaRepositorio tarefaRepositorio;
	
	@GetMapping("/projetos")
	public ResponseEntity<List<Projeto>> ListarProjeto() {
		var listaProjeto = projetoRepositorio.findAll();
		return ResponseEntity.ok(listaProjeto);
	}
	
	@GetMapping("/subprojetos")
	public ResponseEntity<List<SubProjeto>> ListarSubProjeto() {
		var listaSubProjeto = subProjetoRepositorio.findAll();
		return ResponseEntity.ok(listaSubProjeto);
	}
	
	@GetMapping("/tarefas")
	public ResponseEntity<List<Tarefa>> ListarTarefa() {
		var listaTarefa = tarefaRepositorio.findAll();
		return ResponseEntity.ok(listaTarefa);
	}
	
}
