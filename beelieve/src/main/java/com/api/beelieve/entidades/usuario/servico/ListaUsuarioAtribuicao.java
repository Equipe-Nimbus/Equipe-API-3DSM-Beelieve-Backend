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
		List<DadosListagemUsuarioAtribuicao> listaAnalista = new ArrayList<DadosListagemUsuarioAtribuicao>();
		for(Usuario usuario: listaUsuarios) {
			DadosListagemUsuarioAtribuicao atributosUsuario = new DadosListagemUsuarioAtribuicao(
					usuario.getIdUsuario(),
					usuario.getNome(),
					usuario.getCargo()
					);
			if(atributosUsuario.cargo().equals("Engenheiro Chefe")) {
				listaEngenheiro.add(atributosUsuario);
			}
			else if (atributosUsuario.cargo().equals("Lider de Pacote de Trabalho")){
				listaChefe.add(atributosUsuario);
			}
			else if (atributosUsuario.cargo().equals("Analista")){
				listaAnalista.add(atributosUsuario);
			}
			
		}
		DadosUsuariosAtribuicaoSeparado atribuicao = new DadosUsuariosAtribuicaoSeparado(listaEngenheiro, listaChefe, listaAnalista);
		return atribuicao;
	}
}