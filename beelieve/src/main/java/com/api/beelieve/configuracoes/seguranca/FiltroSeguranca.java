package com.api.beelieve.configuracoes.seguranca;

import java.io.IOException;
import java.util.Enumeration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.api.beelieve.entidades.usuario.Usuario;
import com.api.beelieve.repositorio.UsuarioRepositorio;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FiltroSeguranca extends OncePerRequestFilter {

	@Autowired
	private ServicoToken servicoToken;
	
	@Autowired
	private UsuarioRepositorio repositorio_usuario;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		String tokenJWT = recuperarToken(request);
		//System.out.println(tokenJWT);
		if(tokenJWT != null) {
			String login = servicoToken.validaToken(tokenJWT);
			UserDetails usuarioDetails = repositorio_usuario.findByEmail(login);
			Authentication autenticacao = new UsernamePasswordAuthenticationToken(usuarioDetails, null, usuarioDetails.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(autenticacao);
			String Uri = request.getRequestURI();
			System.out.println(Uri);
			if(Uri.equals("/projeto/lista/paginada")) {
				Usuario usuario = repositorio_usuario.getByEmail(login);
				request.setAttribute("cargo", usuario.getCargo());
				request.setAttribute("id_usuario", usuario.getIdUsuario());
				
			}
		}
		
		
		
		filterChain.doFilter(request, response);
	}

	private String recuperarToken(HttpServletRequest request) {
		String authorizationHeader = request.getHeader("Authorization");
		if (authorizationHeader != null) {
			return authorizationHeader.replace("Bearer ", "");

		}
		return null;
	}

	
	
}
