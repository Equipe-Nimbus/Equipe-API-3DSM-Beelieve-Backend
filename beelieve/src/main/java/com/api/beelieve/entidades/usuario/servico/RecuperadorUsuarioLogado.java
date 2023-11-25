package com.api.beelieve.entidades.usuario.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.api.beelieve.entidades.usuario.Usuario;
import com.api.beelieve.repositorio.UsuarioRepositorio;

@Component
public class RecuperadorUsuarioLogado {
	
	@Autowired
	UsuarioRepositorio repositorio_usuario;
	
	public Long recuperarId(Authentication authentication) {
	    if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
	        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

	        Usuario usuario = repositorio_usuario.getByEmail(userDetails.getUsername());
	        return usuario != null ? usuario.getIdUsuario() : null;
	    }
	    return null;
	}
	
	public String recuperarEmail(Authentication authentication) {
	    if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
	        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

	        Usuario usuario = repositorio_usuario.getByEmail(userDetails.getUsername());
	        return usuario != null ? usuario.getEmail() : null;
	    }
	    return null;
	}
}
