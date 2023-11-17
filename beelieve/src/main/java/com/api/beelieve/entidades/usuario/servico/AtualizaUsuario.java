package com.api.beelieve.entidades.usuario.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.beelieve.entidades.usuario.Usuario;
import com.api.beelieve.entidades.usuario.dto.DadosAtualizaUsuario;
import com.api.beelieve.repositorio.UsuarioRepositorio;

import jakarta.transaction.Transactional;

@Service
public class AtualizaUsuario {
	
	@Autowired
	private UsuarioRepositorio repositorio_usuario;

	@Transactional
	public void atualizarUsuario(DadosAtualizaUsuario dadoAtualizado) {
		Usuario usuario = repositorio_usuario.findById(dadoAtualizado.id_usuario()).get();
	
		if(dadoAtualizado.nome() != null) {
			usuario.setNome(dadoAtualizado.nome());
		}
		if(dadoAtualizado.cargo() != null) {
			usuario.setCargo(dadoAtualizado.cargo());
		}
		if(dadoAtualizado.departamento() != null) {
			usuario.setDepartamento(dadoAtualizado.departamento());
		}
		if(dadoAtualizado.email() != null) {
			usuario.setEmail(dadoAtualizado.email());
		}
		if(dadoAtualizado.senha() != null) {
			usuario.setSenha(new BCryptPasswordEncoder().encode(dadoAtualizado.senha()));
		}
		if(dadoAtualizado.telefone() != null) {
			usuario.setTelefone(dadoAtualizado.telefone());
		}
		if(dadoAtualizado.is_active() != null) {
			usuario.setIs_active(dadoAtualizado.is_active());
		}
	}
	
}
