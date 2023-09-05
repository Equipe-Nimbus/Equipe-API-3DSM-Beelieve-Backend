package controles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entidades.ModuloSubProjeto;
import entidades.Projeto;
import entidades.SubProjeto;
import entidades.Tarefa;
import repositorio.ModuloSubProjetoRepositorio;
import repositorio.ProjetoRepositorio;
import repositorio.SubProjetoRepositorio;
import repositorio.TarefaRepositorio;

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
