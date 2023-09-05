package com.api.beelieve.controles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.beelieve.entidades.ModuloSubProjeto;
import com.api.beelieve.entidades.Projeto;
import com.api.beelieve.entidades.SubProjeto;
import com.api.beelieve.entidades.Tarefa;
import com.api.beelieve.repositorio.ModuloSubProjetoRepositorio;
import com.api.beelieve.repositorio.ProjetoRepositorio;
import com.api.beelieve.repositorio.SubProjetoRepositorio;
import com.api.beelieve.repositorio.TarefaRepositorio;

@RestController
@RequestMapping("/cadastrar")
public class CadastroControle {
	
	@Autowired
	private ProjetoRepositorio projetoRepositorio;
	
	@Autowired
	private SubProjetoRepositorio subProjetoRepositorio;
	
	@Autowired
	private ModuloSubProjetoRepositorio moduloSubProjetoRepositorio;
	
	@Autowired
	private TarefaRepositorio tarefaRepositorio;
	
	@PostMapping("/projeto")
	public void cadastrarProjeto(@RequestBody Projeto projeto) {
		projetoRepositorio.save(projeto);
	}
	
	@PostMapping("/subProjeto")
	public void cadastrarSubProjeto(@RequestBody SubProjeto subProjeto) {
		subProjetoRepositorio.save(subProjeto);
	}
	
	@PostMapping("/moduloSubProjeto")
	public void cadastrarModuloSubProjeto(@RequestBody ModuloSubProjeto moduloSubProjeto) {
		moduloSubProjetoRepositorio.save(moduloSubProjeto);
	}
	
	
	@PostMapping("/tarefa")
	public void cadastrarTarefa(@RequestBody Tarefa tarefa) {
		tarefaRepositorio.save(tarefa);
	}

};
