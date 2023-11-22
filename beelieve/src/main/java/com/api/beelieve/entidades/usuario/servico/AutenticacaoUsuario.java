package com.api.beelieve.entidades.usuario.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.api.beelieve.repositorio.UsuarioRepositorio;

@Service
public class AutenticacaoUsuario implements UserDetailsService{

	@Autowired
	private UsuarioRepositorio usuario_repositorio;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return usuario_repositorio.findByEmail(email);
	}

}
