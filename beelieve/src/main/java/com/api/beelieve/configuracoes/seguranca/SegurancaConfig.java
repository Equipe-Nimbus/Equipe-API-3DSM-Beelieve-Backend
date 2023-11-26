package com.api.beelieve.configuracoes.seguranca;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SegurancaConfig {
	
	@Autowired
	private FiltroSeguranca filtro;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.cors(Customizer.withDefaults())
			.csrf(csrf -> csrf.disable())
			.sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.authorizeHttpRequests(req -> {
                req.requestMatchers(HttpMethod.POST, "/usuario/login").permitAll();
                req.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll();
                req.anyRequest().authenticated();
            })
			.addFilterBefore(filtro, UsernamePasswordAuthenticationFilter.class)
			.headers(headers -> {
	            headers.addHeaderWriter((request, response) -> {
	                response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
	                response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
	                response.setHeader("Access-Control-Allow-Headers", "authorization, content-type");
	                response.setHeader("Access-Control-Allow-Credentials", "true");
	            });
	        });
		
		return http.build();
//	    http.csrf(csrf -> csrf.disable())
//		            .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//		            .authorizeHttpRequests(req -> {
//		                req.requestMatchers(HttpMethod.POST, "/usuario/login").permitAll();
//		                req.anyRequest().authenticated();
//		            })
//		            .addFilterBefore(filtro, UsernamePasswordAuthenticationFilter.class)
//			    	.build();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
	
	@Bean
	public PasswordEncoder criptografiaSenha() {
		return new BCryptPasswordEncoder();
	}
	
}
