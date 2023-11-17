package com.api.beelieve.configuracoes.seguranca;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.api.beelieve.entidades.usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

@Service
public class ServicoToken {
	
	public String gerarToken(Usuario usuario) {
		try {
		    Algorithm algoritimo = Algorithm.HMAC256("senhaToken");
		    return JWT.create()
		        .withIssuer("beelieve")
		        .withSubject(usuario.getEmail())
		        .withClaim("id", usuario.getIdUsuario())
		        .withClaim("cargo", usuario.getCargo())
		        .withExpiresAt(dataExpiracao())
		        .sign(algoritimo);
		} catch (JWTCreationException exception){
		    throw new RuntimeException("Não foi possível gerar o token", exception);
		}
	}
	
	public String validaToken(String tokenJWT) {
		try {
		    Algorithm algorithm = Algorithm.HMAC256("senhaToken");
		    return JWT.require(algorithm)
		        .withIssuer("beelieve")
		        .build()
		        .verify(tokenJWT)
		        .getSubject();
		        

		} catch (JWTVerificationException exception){
		    throw new RuntimeException("Token invalido ou expirado", exception);
		}
	}
	
	private Instant dataExpiracao() {
		return LocalDateTime.now().plusHours(3).toInstant(ZoneOffset.of("-03:00"));
	}
	
}
