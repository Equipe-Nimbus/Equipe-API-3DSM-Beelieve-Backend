package com.api.beelieve.controles;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.beelieve.configuracoes.seguranca.DadosToken;
import com.api.beelieve.configuracoes.seguranca.Perfil;
import com.api.beelieve.configuracoes.seguranca.ServicoToken;
import com.api.beelieve.entidades.usuario.FiltroUsuario;
import com.api.beelieve.entidades.usuario.Usuario;
import com.api.beelieve.entidades.usuario.dto.DadosAtualizaUsuario;
import com.api.beelieve.entidades.usuario.dto.DadosListagemUsuario;
import com.api.beelieve.entidades.usuario.dto.DadosLoginUsuario;
import com.api.beelieve.entidades.usuario.dto.DadosUsuarioCadastro;
import com.api.beelieve.entidades.usuario.dto.DadosUsuariosAtribuicaoSeparado;
import com.api.beelieve.entidades.usuario.dto.DadosUsuariosAtribuidosAoProjeto;
import com.api.beelieve.entidades.usuario.servico.AtualizaUsuario;
import com.api.beelieve.entidades.usuario.servico.ListaUsuarioAtribuicao;
import com.api.beelieve.entidades.usuario.servico.ListaUsuarioPaginado;
import com.api.beelieve.entidades.usuario.servico.ListaUsuariosAtribuidosAoProjeto;
import com.api.beelieve.entidades.usuario.servico.RecuperadorUsuarioLogado;
import com.api.beelieve.repositorio.UsuarioRepositorio;

@RestController
@RequestMapping("/usuario")
public class ControleUsuario {
	@Autowired
	private UsuarioRepositorio repositorio_usuario;
	
	@Autowired
	private ListaUsuarioAtribuicao listaUsuarioGeral;
	
	@Autowired
	private AtualizaUsuario atualizaUsuario;
	
	@Autowired
	private ListaUsuarioPaginado listaPaginada;
	
	@Autowired

	private ListaUsuariosAtribuidosAoProjeto resgataAtribuidos;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private ServicoToken servicoToken;
	
	@Autowired
	private RecuperadorUsuarioLogado recuperadorUsuarioLogado;
	
	
	
	@PostMapping("/cadastrar")
	@PreAuthorize("hasAuthority('ROLE_GERENTE')")
	public ResponseEntity<String> cadastrar(@RequestBody DadosUsuarioCadastro usuario) {
		Usuario criaUsuario = new Usuario(usuario);
		Usuario consultaUsuarioEmail = repositorio_usuario.getByEmail(criaUsuario.getEmail());
		Usuario consultaUsuarioCpf = repositorio_usuario.findByCpf(criaUsuario.getCpf());
		if(consultaUsuarioEmail != null) {
			return ResponseEntity.badRequest().body("Já existe um usuário cadastrado com esse email!");
		}  else if(consultaUsuarioCpf != null) {
			return ResponseEntity.badRequest().body("Já existe um usuário cadastrado com esse cpf!");
		} else {
			if(criaUsuario.getCargo().equals("Gerente")) {
				criaUsuario.getListaPerfil().add(Perfil.ROLE_GERENTE);
				criaUsuario.getListaPerfil().add(Perfil.ROLE_ENGENHEIRO);
				criaUsuario.getListaPerfil().add(Perfil.ROLE_LIDER);
				criaUsuario.getListaPerfil().add(Perfil.ROLE_ANALISTA);			
			} else if (criaUsuario.getCargo().equals("Engenheiro Chefe")) {
				criaUsuario.getListaPerfil().add(Perfil.ROLE_ENGENHEIRO);
				criaUsuario.getListaPerfil().add(Perfil.ROLE_LIDER);
				criaUsuario.getListaPerfil().add(Perfil.ROLE_ANALISTA);
			} else if (criaUsuario.getCargo().equals("Lider de Pacote de Trabalho")) {
				criaUsuario.getListaPerfil().add(Perfil.ROLE_LIDER);
				criaUsuario.getListaPerfil().add(Perfil.ROLE_ANALISTA);
			} else {
				criaUsuario.getListaPerfil().add(Perfil.ROLE_ANALISTA);
			}
			repositorio_usuario.save(criaUsuario);
			return ResponseEntity.ok().build();
		}
	};
	
	@GetMapping("/listar/atribuicao")
	@PreAuthorize("hasAnyRole('ROLE_LIDER')")
	public ResponseEntity<DadosUsuariosAtribuicaoSeparado> listar() {
		List<Usuario> listaUsuario = repositorio_usuario.findAll();
		DadosUsuariosAtribuicaoSeparado listaUsuarioModificada = listaUsuarioGeral.listarUsuarios(listaUsuario);
		System.out.println(listaUsuarioModificada);
		return ResponseEntity.ok(listaUsuarioModificada);
	};
	
	@GetMapping("/atribuidos/projeto/{id}")
	@PreAuthorize("hasAnyRole('ROLE_ANALISTA')")
	public ResponseEntity<DadosUsuariosAtribuidosAoProjeto> listarUsuariosAtribuidos(@PathVariable Long id) {
		DadosUsuariosAtribuidosAoProjeto dadosProjetoAtribuidos = resgataAtribuidos.listar(id);
		return ResponseEntity.ok(dadosProjetoAtribuidos);
	}
	
	@GetMapping("/listar/{id}")
	@PreAuthorize("hasAnyRole('ROLE_GERENTE')")
	public ResponseEntity<DadosListagemUsuario> listarId(@PathVariable Long id){
		DadosListagemUsuario usuario = repositorio_usuario.acharUsuario(id);
		return ResponseEntity.ok(usuario);
	};
	
	
	@GetMapping("/lista/paginada")
	@PreAuthorize("hasAnyRole('ROLE_ANALISTA')")
	public ResponseEntity<Page<DadosListagemUsuario>> listaPaginada(@RequestParam Map<String, String> filtro, Pageable infoPaginacao){
		filtro.forEach((chave, valor)->{
			System.out.println("Chave: " + chave + " Valor: " + valor);
		});
		FiltroUsuario filtroUsuario = new FiltroUsuario(filtro);
		Page<Usuario> paginacao = listaPaginada.listaPaginada(filtroUsuario, infoPaginacao);
		var usuarios = paginacao.map(p -> new DadosListagemUsuario(
				p.getIdUsuario(), 
				p.getNome(), 
				p.getMatricula(), 
				p.getCpf(), 
				p.getEmail(), 
				p.getSenha(), 
				p.getCargo(), 
				p.getDepartamento(), 
				p.getTelefone(), 
				p.getIs_active()));
		System.out.println("Usuarios: " + usuarios);
		return ResponseEntity.ok(usuarios);
	};
	
	@PutMapping("/atualizar")
	@PreAuthorize("hasAnyRole('ROLE_GERENTE')")
	public ResponseEntity<String> atualizaUsuario(@RequestBody DadosAtualizaUsuario dadosAtualizacao) {
	    
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Long idUsuarioLogado = recuperadorUsuarioLogado.recuperarId(authentication);
		String emailUsuarioLogado = recuperadorUsuarioLogado.recuperarEmail(authentication);
		
		Usuario consultaUsuario = repositorio_usuario.getByEmail(dadosAtualizacao.email());
		
		boolean loggout = false;
		if(idUsuarioLogado.equals(dadosAtualizacao.id_usuario()) && !emailUsuarioLogado.equals(dadosAtualizacao.email())) {
			loggout = true;
		}
		
		String responseBody = "{\"loggout\": " + loggout + "}";
		
		if (consultaUsuario != null) {
			if (consultaUsuario.getIdUsuario() == dadosAtualizacao.id_usuario()) {
				atualizaUsuario.atualizarUsuario(dadosAtualizacao);
				
				return ResponseEntity.ok(responseBody);
			} else {
				return ResponseEntity.badRequest().body("Já existe um usuário cadastrado com esse email!");
			}							
		}			
		else {
			atualizaUsuario.atualizarUsuario(dadosAtualizacao);
			return ResponseEntity.ok(responseBody);
		}
	    
	}


	@PutMapping("/deletar")
	@PreAuthorize("hasAuthority('ROLE_GERENTE')")
	public ResponseEntity<?> deletaUsuario(@RequestBody DadosAtualizaUsuario usuarioDelete){
		atualizaUsuario.atualizarUsuario(usuarioDelete);
		return ResponseEntity.ok().build();
	};
	
	
	
	@PostMapping("/login")
	public ResponseEntity<DadosToken> login(@RequestBody DadosLoginUsuario login) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(login.login(), login.senha()); 
		Authentication autenticacao = authenticationManager.authenticate(token);
		Usuario usuario = (Usuario) autenticacao.getPrincipal();
		if(usuario.getEmail().equals(login.login())) {
			DadosToken tokenJWT = new DadosToken(servicoToken.gerarToken(usuario), usuario.getCargo(), usuario.getNome());
			
			return ResponseEntity.ok(tokenJWT);
		}
		else {
			return ResponseEntity.badRequest().build();
		}
	}
}
