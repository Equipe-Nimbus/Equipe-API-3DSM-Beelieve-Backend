package com.api.beelieve.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.beelieve.entidades.usuario.Usuario;
import com.api.beelieve.entidades.usuario.dto.DadosListagemUsuario;
import com.api.beelieve.entidades.usuario.servico.ListaUsuarioGeral;
import com.api.beelieve.repositorio.UsuarioRepositorio;

@RestController
@RequestMapping("/usuario")
public class ControleUsuario {
	@Autowired
	private UsuarioRepositorio repositorio_usuario;
	
	@Autowired
	private ListaUsuarioGeral listaUsuarioGeral;
	
	
	@GetMapping("/listar")
	public ResponseEntity<List<DadosListagemUsuario>> listar() {
		List<Usuario> listaUsuario = repositorio_usuario.findAll();
		List<DadosListagemUsuario> listaUsuarioModificada = listaUsuarioGeral.listarUsuarios(listaUsuario);
		System.out.println(listaUsuarioModificada);
		return ResponseEntity.ok(listaUsuarioModificada);
	}
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<DadosListagemUsuario> listarId(@PathVariable Long id){
		DadosListagemUsuario usuario = repositorio_usuario.acharUsuario(id);
		return ResponseEntity.ok(usuario);
	};
	
}
