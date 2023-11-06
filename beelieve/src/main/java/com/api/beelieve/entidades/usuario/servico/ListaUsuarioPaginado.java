package com.api.beelieve.entidades.usuario.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.beelieve.entidades.usuario.FiltroUsuario;
import com.api.beelieve.entidades.usuario.Usuario;
import com.api.beelieve.repositorio.UsuarioRepositorioPaginacao;

@Service
public class ListaUsuarioPaginado {

	@Autowired
	private UsuarioRepositorioPaginacao usuarioPaginacao;
	
	public Page<Usuario> listaPaginada(FiltroUsuario filtragemUsuario, Pageable informacaoPagina){
		System.out.println(filtragemUsuario.toSpec().toString());
		return usuarioPaginacao.findAll(filtragemUsuario.toSpec(), informacaoPagina);
	}
}
