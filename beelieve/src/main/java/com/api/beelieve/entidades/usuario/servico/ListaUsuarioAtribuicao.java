package com.api.beelieve.entidades.usuario.servico;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.api.beelieve.entidades.usuario.Usuario;
import com.api.beelieve.entidades.usuario.dto.DadosListagemUsuario;
import com.api.beelieve.entidades.usuario.dto.DadosListagemUsuarioAtribuicao;
import com.api.beelieve.entidades.usuario.dto.DadosUsuariosAtribuicaoSeparado;

@Service
public class ListaUsuarioAtribuicao {
	
	public DadosUsuariosAtribuicaoSeparado listarUsuarios(List<Usuario> listaUsuarios){
		List<DadosListagemUsuarioAtribuicao> listaChefe = new ArrayList<DadosListagemUsuarioAtribuicao>();
		List<DadosListagemUsuarioAtribuicao> listaEngenheiro = new ArrayList<DadosListagemUsuarioAtribuicao>();
		for(Usuario usuario: listaUsuarios) {
			DadosListagemUsuarioAtribuicao atributosUsuario = new DadosListagemUsuarioAtribuicao(
					usuario.getId_usuario(),
					usuario.getNome(),
					usuario.getCargo()
					);
			if(atributosUsuario.cargo().equals("Engenheiro Chefe")) {
				listaEngenheiro.add(atributosUsuario);
			}
			else {
				
				listaChefe.add(atributosUsuario);
			}
			
		}
		DadosUsuariosAtribuicaoSeparado atribuicao = new DadosUsuariosAtribuicaoSeparado(listaEngenheiro, listaChefe);
		return atribuicao;
	}
}