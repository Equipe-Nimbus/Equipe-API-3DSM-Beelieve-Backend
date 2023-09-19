package com.api.beelieve.controles;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.beelieve.entidades.nivelsubprojeto.NivelSubProjeto;
import com.api.beelieve.entidades.subprojeto.SubProjeto;
import com.api.beelieve.entidades.tarefa.DadosListaTarefasAtualizacao;
import com.api.beelieve.entidades.tarefa.LeituraListaTarefa;
import com.api.beelieve.entidades.tarefa.Tarefa;
import com.api.beelieve.repositorio.NivelSubProjetoRepositorio;
import com.api.beelieve.repositorio.SubProjetoRepositorio;
import com.api.beelieve.repositorio.TarefaRepositorio;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/tarefa")
public class ControleTarefa {
	
	@Autowired
	private TarefaRepositorio repositorio_tarefa;
	
	@Autowired
	private SubProjetoRepositorio repositorio_subprojeto;
	
	@Autowired
	private LeituraListaTarefa leituraListaTarefa;
	
	@Autowired
	private NivelSubProjetoRepositorio repositorio_nivelsubProjetoRepositorio;
	
	@PostMapping("/cadastrar")
	public void cadastrar(@RequestBody Tarefa tarefa) {
		repositorio_tarefa.save(tarefa);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<Tarefa>> listar() {
		var lista_tarefa = repositorio_tarefa.findAll();
		return ResponseEntity.ok(lista_tarefa);
	}
	
	@PutMapping("/atualizar")
	@Transactional
	public ResponseEntity<List<Tarefa>> atualizar(@RequestBody DadosListaTarefasAtualizacao listaTarefas) {
		List<Tarefa> tarefasResultado = new ArrayList<Tarefa>();
		
		if("subprojeto".equals(listaTarefas.tipo_pai())) {
			SubProjeto nivelPai = repositorio_subprojeto.findById(listaTarefas.id_pai()).get();
			leituraListaTarefa.atualizarListaSubProjeto(listaTarefas.lista_tarefas(), nivelPai);
		}
		else if ("nivelsubprojeto".equals(listaTarefas.tipo_pai())) {
			NivelSubProjeto nivelPai = repositorio_nivelsubProjetoRepositorio.findById(listaTarefas.id_pai()).get();
			leituraListaTarefa.atualizarListaNivel(listaTarefas.lista_tarefas(), nivelPai);
		}
		
		return ResponseEntity.ok(tarefasResultado);
	}
}
