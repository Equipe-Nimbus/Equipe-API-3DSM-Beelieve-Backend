package com.api.beelieve.entidades.projeto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.api.beelieve.entidades.analista_projeto.AnalistaProjeto;

import com.api.beelieve.entidades.subprojeto.SubProjeto;
import com.api.beelieve.entidades.usuario.Usuario;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class FiltroProjeto {
	private String nome;
	private String chefe;
	private String cargo;
	private Long id_usuario;
	
	
	public FiltroProjeto (Map<String, String> parametros, String cargo, Long id_usuario){
		this.cargo = cargo;
		this.id_usuario = id_usuario;
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
				Path<String> campoNome = root.<String>get("nomeProjeto");
				Predicate predicadoNome = builder.like(campoNome, "%"+ nome +"%");
				listaPredicados.add(predicadoNome);

			}
			if(StringUtils.hasText(chefe) || this.cargo.equals("Engenheiro Chefe")) {
				Join<Usuario, Projeto> joinChefe = root.join("chefe_projeto");
				
				if(this.cargo.equals("Engenheiro Chefe")) {
					Path<String> campoIdUsuario = joinChefe.<String>get("idUsuario");
					Predicate predicadoUsuario = builder.equal(campoIdUsuario, this.id_usuario);
					listaPredicados.add(predicadoUsuario);
				}
				else {
					Path<String> campoChefe = joinChefe.<String>get("nome");
					Predicate predicadoChefe = builder.like(campoChefe, "%"+ chefe +"%");
					listaPredicados.add(predicadoChefe);
				}
			}
			if(!cargo.equals("Gerente") && !cargo.equals("Engenheiro Chefe")) {
				if(cargo.equals("Lider de Pacote de Trabalho")) {
					Join<SubProjeto, Projeto> joinUsuario = root.join("sub_projetos");
					Path<String> campoIdUsuario = joinUsuario.get("chefe_sub_projeto").get("idUsuario");
					Predicate predicadoUsuario = builder.equal(campoIdUsuario, this.id_usuario);
					listaPredicados.add(predicadoUsuario);
				}
				else{
					Join<AnalistaProjeto, Projeto> joinUsuario = root.join("analistasAtribuidos");
					Path<String> campoIdUsuario = joinUsuario.get("analista").get("idUsuario");
					Predicate predicadoUsuario = builder.equal(campoIdUsuario, this.id_usuario);
					listaPredicados.add(predicadoUsuario);
				}
			}
			return builder.and(listaPredicados.toArray(new Predicate[0]));
		};
	}
}
