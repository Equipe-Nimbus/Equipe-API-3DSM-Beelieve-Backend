package com.api.beelieve.entidades.usuario.servico;

import org.springframework.stereotype.Service;

import com.api.beelieve.entidades.usuario.Usuario;
import com.api.beelieve.entidades.usuario.dto.DadosListagemUsuario;

@Service
public class ConversorListagem {
	
	public DadosListagemUsuario converterListagemUsuario(Usuario usuario) {
		DadosListagemUsuario dadosListagemUsuario = new DadosListagemUsuario(
				usuario.getId_usuario(),
				usuario.getNome(),
				usuario.getCpf(),
				usuario.getEmail(),
				usuario.getSenha(),
				usuario.getCargo()
				);	
		
		return dadosListagemUsuario;
	}
}
