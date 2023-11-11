package com.api.beelieve.entidades.usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class FiltroUsuario {
	private String nome;
	private String email;
	private String cargo;
	private String departamento;
	
	public FiltroUsuario(Map<String, String> parametros) {
		if(parametros.containsKey("nome")) {
			this.nome = parametros.get("nome");
		}
		if(parametros.containsKey("email")) {
			this.email = parametros.get("email");
		}
		if(parametros.containsKey("departamento")) {
			this.departamento = parametros.get("departamento");
		}
		if(parametros.containsKey("cargo")) {
			this.cargo = parametros.get("cargo").replace("_", " ");
		}
	}
	
	public Specification<Usuario> toSpec(){
		return (root, query, builder) -> {
			List<Predicate> listaPredicados = new ArrayList<Predicate>();
			if(StringUtils.hasText(nome)) {
				Path<String> campoNome = root.<String>get("nome");
				Predicate predicadoNome = builder.like(campoNome, "%" + nome + "%");
				listaPredicados.add(predicadoNome);
			}
			if(StringUtils.hasText(cargo)) {
				Path<String> campoCargo = root.<String>get("cargo");
				Predicate predicadoCargo = builder.equal(campoCargo, cargo);
				listaPredicados.add(predicadoCargo);
			}
			if(StringUtils.hasText(departamento)) {
				Path<String> campoDepartamento = root.<String>get("departamento");
				Predicate predicadoDepartamento = builder.like(campoDepartamento, "%" + departamento + "%");
				listaPredicados.add(predicadoDepartamento);
			}
			if(StringUtils.hasText(email)) {
				Path<String> campoEmail = root.<String>get("email");
				Predicate predicadoEmail = builder.like(campoEmail, "%" + email + "%");
				listaPredicados.add(predicadoEmail);
			}
			Path<String> campoIs_active = root.<String>get("is_active");
			Predicate predicadoAtivo = builder.equal(campoIs_active, true);
			listaPredicados.add(predicadoAtivo);
			
			return builder.and(listaPredicados.toArray(new Predicate[0]));
		};
	}
}
