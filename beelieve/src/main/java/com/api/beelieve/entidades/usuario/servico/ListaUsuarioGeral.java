package com.api.beelieve.entidades.usuario.servico;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.api.beelieve.entidades.usuario.Usuario;
import com.api.beelieve.entidades.usuario.dto.DadosListagemUsuario;

@Service
public class ListaUsuarioGeral {
	
	public List<DadosListagemUsuario> listarUsuarios(List<Usuario> listaUsuarios){
		List<DadosListagemUsuario> listaFinal = new ArrayList<DadosListagemUsuario>();
		for(Usuario usuario: listaUsuarios) {
			DadosListagemUsuario atributosUsuario = new DadosListagemUsuario(
					usuario.getId_usuario(),
					usuario.getNome(),
					usuario.getMatricula(),
					usuario.getEmail(),
					usuario.getSenha(),
					usuario.getCargo(),
					usuario.getDepartamento()
					);
			listaFinal.add(atributosUsuario);
		}
		System.out.println(listaFinal);

		return listaFinal;
	}
}