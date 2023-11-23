package com.api.beelieve.entidades.projeto.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.beelieve.entidades.projeto.Projeto;
import com.api.beelieve.entidades.projeto.dto.DadosProjetoCadastro;
import com.api.beelieve.entidades.subprojeto.servico.CadastroSubProjeto;
import com.api.beelieve.entidades.usuario.Usuario;
import com.api.beelieve.repositorio.ProjetoRepositorio;
import com.api.beelieve.repositorio.UsuarioRepositorio;

@Service
public class CadastroProjeto {

	@Autowired
	private ProjetoRepositorio repositorio_projeto;
	
	@Autowired
	private UsuarioRepositorio repositorio_usuario;
	
	@Autowired
	private CadastroSubProjeto cadastroCascataSubProjeto;
	
	public Projeto cadastrarCascata(DadosProjetoCadastro dadosProjeto) {
		Projeto projeto = new Projeto(dadosProjeto);
		Usuario engenheiroAtribuido = repositorio_usuario.findById(dadosProjeto.id_usuario()).get();
		projeto.setChefe_projeto(engenheiroAtribuido);
		repositorio_projeto.save(projeto);
		if(projeto.getSub_projetos() != null) {
			cadastroCascataSubProjeto.cadastroCascata(projeto.getSub_projetos());
		}
		return projeto;
	}
	
}
