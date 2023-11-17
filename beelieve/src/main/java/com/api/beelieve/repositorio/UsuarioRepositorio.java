package com.api.beelieve.repositorio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.api.beelieve.entidades.usuario.Usuario;
import com.api.beelieve.entidades.usuario.dto.DadosListagemUsuario;
import com.api.beelieve.entidades.usuario.servico.ConversorListagemUsuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{
	
	public static final ConversorListagemUsuario conversorUsuario = new ConversorListagemUsuario();
	
	public default DadosListagemUsuario acharUsuario(Long id_usuario) {
		Usuario usuario = this.findById(id_usuario).get();
		DadosListagemUsuario dadosUsuario = conversorUsuario.converterListagemUsuario(usuario);
		return dadosUsuario;
	}
	
	public default List<DadosListagemUsuario> acharTodosUsuarios() {
		List<Usuario> listaUsuarios = this.findAll();
		
		List<DadosListagemUsuario> listaDadosUsuario = new ArrayList<DadosListagemUsuario>();
		if(listaUsuarios != null) {
			listaUsuarios.forEach((usuario)->{
				listaDadosUsuario.add(conversorUsuario.converterListagemUsuario(usuario));
			});
		}
		
		return listaDadosUsuario;
	}

	
	public Usuario findByCpf (String cpf);
	
	public Usuario getByEmail (String email);


	
	public UserDetails findByEmail(String email);
	

}