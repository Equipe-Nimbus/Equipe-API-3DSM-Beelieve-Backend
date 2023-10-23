package com.api.beelieve.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.beelieve.entidades.usuario.Usuario;
import com.api.beelieve.entidades.usuario.dto.DadosAtualizaUsuario;
import com.api.beelieve.entidades.usuario.dto.DadosListagemUsuario;
import com.api.beelieve.entidades.usuario.dto.DadosUsuarioCadastro;
import com.api.beelieve.entidades.usuario.servico.AtualizaUsuario;
import com.api.beelieve.entidades.usuario.servico.ListaUsuarioGeral;
import com.api.beelieve.entidades.usuario.servico.ListaUsuarioPaginado;
import com.api.beelieve.repositorio.UsuarioRepositorio;

import jakarta.persistence.Transient;

@RestController
@RequestMapping("/usuario")
public class ControleUsuario {
	@Autowired
	private UsuarioRepositorio repositorio_usuario;
	
	@Autowired
	private ListaUsuarioGeral listaUsuarioGeral;
	
	@Autowired
	private AtualizaUsuario atualizaUsuario;
	
	@Autowired
	private ListaUsuarioPaginado listaPaginada;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<?> cadastrar(@RequestBody DadosUsuarioCadastro usuario) {
		Usuario criaUsuario = new Usuario(usuario);
		repositorio_usuario.save(criaUsuario);
		return ResponseEntity.ok().build();
	};
	
	@GetMapping("/listar")
	public ResponseEntity<List<DadosListagemUsuario>> listar() {
		List<Usuario> listaUsuario = repositorio_usuario.findAll();
		List<DadosListagemUsuario> listaUsuarioModificada = listaUsuarioGeral.listarUsuarios(listaUsuario);
		System.out.println(listaUsuarioModificada);
		return ResponseEntity.ok(listaUsuarioModificada);
	};
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<DadosListagemUsuario> listarId(@PathVariable Long id){
		DadosListagemUsuario usuario = repositorio_usuario.acharUsuario(id);
		return ResponseEntity.ok(usuario);
	};
	
	@GetMapping("/lista/paginada")
	public ResponseEntity<Page<Usuario>> listaPaginada(Pageable infoPaginacao){
		Page<Usuario> paginacao = listaPaginada.listaPaginada(infoPaginacao);
		return ResponseEntity.ok(paginacao);
	};
	
	@PutMapping("/atualiza")
	public ResponseEntity<?> atuazaUsuario(@RequestBody DadosAtualizaUsuario dadosAtualizacao){
		atualizaUsuario.atualizarUsuario(dadosAtualizacao);
		return ResponseEntity.ok().build();
	};
	
	
}
