package com.api.beelieve.controles;


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
import com.api.beelieve.entidades.tarefa.Tarefa;
import com.api.beelieve.entidades.tarefa.dto.DadosListaTarefasAtualizacao;
import com.api.beelieve.entidades.tarefa.servico.AtualizaProgressoPorTarefa;
import com.api.beelieve.entidades.tarefa.servico.LeituraListaTarefa;
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
	
	@Autowired AtualizaProgressoPorTarefa atualizaProgresso;
	
	@PostMapping("/cadastrar")
	public void cadastrar(@RequestBody Tarefa tarefa) {
		repositorio_tarefa.save(tarefa);
	}
	
	@GetMapping("/listar")
	public List<Tarefa> listar() {
		List<Tarefa> lista_tarefa = repositorio_tarefa.findAll();
		System.out.println(lista_tarefa);
		return lista_tarefa;
	}
	
	@PutMapping("/atualizar")
	@Transactional
	public ResponseEntity<List<Tarefa>> atualizar(@RequestBody DadosListaTarefasAtualizacao listaTarefas) {
		
		
		if("subprojeto".equals(listaTarefas.tipo_pai())) {
			SubProjeto nivelPai = repositorio_subprojeto.findById(listaTarefas.id_pai()).get();
			leituraListaTarefa.atualizarListaSubProjeto(listaTarefas.lista_tarefas(), nivelPai);
			if(listaTarefas.progresso_pai() != null) {
				atualizaProgresso.atualizarProgressoSubProjeto(listaTarefas.progresso_pai(), nivelPai);
			}
			
		}
		else if ("nivelsubprojeto".equals(listaTarefas.tipo_pai())) {
			NivelSubProjeto nivelPai = repositorio_nivelsubProjetoRepositorio.findById(listaTarefas.id_pai()).get();
			leituraListaTarefa.atualizarListaNivel(listaTarefas.lista_tarefas(), nivelPai);
			if(listaTarefas.progresso_pai() != null) {
				atualizaProgresso.atualizarProgressoNivelSubProjeto(listaTarefas.progresso_pai(), nivelPai);
			}
		}
		
		return ResponseEntity.ok().build();
	}
}
