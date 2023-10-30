package com.api.beelieve.entidades.projeto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class FiltroProjeto {
	private String nome;
	private String chefe;
	
	public FiltroProjeto (Map<String, String> parametros){
		if(parametros.containsKey("nome")) {
			this.nome = parametros.get("nome");
		}
		if(parametros.containsKey("chefe")) {
			this.chefe = parametros.get("chefe");
		}
	}
	
	public Specification<Projeto> toSpec(){
		return (root, query, builder) -> {
			List<Predicate> listaPredicados = new ArrayList<Predicate>();
			if(StringUtils.hasText(nome)) {
				Path<String> campoNome = root.<String>get("nome_projeto");
				Predicate predicadoNome = builder.like(campoNome, "%"+ nome +"%");
				listaPredicados.add(predicadoNome);
			}
			if(StringUtils.hasText(chefe)) {
				Path<String> campoChefe = root.<String>get("chefe_projeto");
				Predicate predicadoChefe = builder.like(campoChefe, "%"+ chefe +"%");
				listaPredicados.add(predicadoChefe);
			}
			return builder.and(listaPredicados.toArray(new Predicate[0]));
		};
	}
}
