package com.api.beelieve.entidades.usuario.servico;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.beelieve.entidades.projeto.Projeto;
import com.api.beelieve.entidades.usuario.dto.DadosUsuariosAnalistasAtribuidos;
import com.api.beelieve.entidades.usuario.dto.DadosUsuariosAtribuidosAoProjeto;
import com.api.beelieve.entidades.usuario.dto.DadosUsuariosLideresAtribuidos;
import com.api.beelieve.repositorio.ProjetoRepositorio;

@Service
public class ListaUsuariosAtribuidosAoProjeto {
	
	@Autowired
	private ProjetoRepositorio repositorio_projeto;
	
	
	public DadosUsuariosAtribuidosAoProjeto listar(Long id) {
		Projeto projeto = repositorio_projeto.findById(id).get();
		List<DadosUsuariosLideresAtribuidos> lideresProjeto = this.resgatarLideres(projeto);
		List<DadosUsuariosAnalistasAtribuidos> analistaProjeto = this.resgatarAnalistas(projeto);
		DadosUsuariosAtribuidosAoProjeto atribuidos = new DadosUsuariosAtribuidosAoProjeto(lideresProjeto, analistaProjeto);
		return atribuidos;
	}
	
	private List<DadosUsuariosAnalistasAtribuidos> resgatarAnalistas(Projeto projeto){
		List<DadosUsuariosAnalistasAtribuidos> analistaProjeto = new ArrayList<DadosUsuariosAnalistasAtribuidos>();

		projeto.getAnalistasAtribuidos().forEach((relacaoAnalistaProjeto)->{
			analistaProjeto.add(new DadosUsuariosAnalistasAtribuidos(
					relacaoAnalistaProjeto.getAnalista().getNome(),
					relacaoAnalistaProjeto.getAnalista().getEmail()));
		});
		
		
		return analistaProjeto;
	}
	
	private DadosUsuariosLideresAtribuidos resgatarEngeinheiro(Projeto projeto) {
		return new DadosUsuariosLideresAtribuidos(
				projeto.getOrdem_projeto(),
				projeto.getNome_projeto(),
				projeto.getChefe_projeto().getNome(),
				projeto.getChefe_projeto().getCargo(),
				projeto.getChefe_projeto().getEmail());
	}
	
	private List<DadosUsuariosLideresAtribuidos> resgatarLideres(Projeto projeto) {
		List<DadosUsuariosLideresAtribuidos> lideresProjeto = new ArrayList<DadosUsuariosLideresAtribuidos>();
		lideresProjeto.add(this.resgatarEngeinheiro(projeto));
		projeto.getSub_projetos().forEach((subProjeto)->{
			
			if(subProjeto.getChefe_sub_projeto() != null) {
				lideresProjeto.add(new DadosUsuariosLideresAtribuidos(
						subProjeto.getOrdem_sub_projeto(),
						subProjeto.getNomeSubProjeto(),
						subProjeto.getChefe_sub_projeto().getNome(),
						subProjeto.getChefe_sub_projeto().getCargo(),
						subProjeto.getChefe_sub_projeto().getEmail()));
			}
		});
	
		return lideresProjeto;
	}
	
}
