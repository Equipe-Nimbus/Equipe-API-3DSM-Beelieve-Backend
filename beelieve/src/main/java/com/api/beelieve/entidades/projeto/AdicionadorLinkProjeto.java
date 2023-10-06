package com.api.beelieve.entidades.projeto;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import com.api.beelieve.controles.ControleProjeto;

public class AdicionadorLinkProjeto implements AdicionarLink<Projeto>{

	@Override
	public void adicionarLink(List<Projeto> lista) {
		for(Projeto projeto : lista) {
			Link linkProprio = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(ControleProjeto.class)
							.listar())
					.withSelfRel();
		}
		
	}

	@Override
	public void adicionarLink(Projeto objeto) {
		Link linkProprio = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(ControleProjeto.class)
						.listar())
				.withSelfRel();
		
	}
	

}
