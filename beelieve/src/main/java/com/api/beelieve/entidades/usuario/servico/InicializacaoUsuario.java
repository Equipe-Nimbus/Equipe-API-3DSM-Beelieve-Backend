package com.api.beelieve.entidades.usuario.servico;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.api.beelieve.entidades.usuario.Usuario;
import com.api.beelieve.entidades.usuario.dto.DadosUsuarioCadastro;
import com.api.beelieve.repositorio.UsuarioRepositorio;

@Component
public class InicializacaoUsuario implements ApplicationListener<ApplicationReadyEvent> {

	@Autowired
	private UsuarioRepositorio repositorio_usuario;
	
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		Optional<Usuario> usuario = repositorio_usuario.findById(Long.valueOf(1));
		if(!usuario.isPresent()) {
			DadosUsuarioCadastro dadosUsuario = new DadosUsuarioCadastro("Roberta", null, "111.111.111-11", "1", "1", "Gerente", "Departamento 1", null, true);
			Usuario novoUsuario = new Usuario(dadosUsuario);
			repositorio_usuario.save(novoUsuario);
		}
	}

}
