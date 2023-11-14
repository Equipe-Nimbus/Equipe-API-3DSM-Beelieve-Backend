package com.api.beelieve.entidades.usuario.dto;

import java.util.List;

public record DadosUsuariosAtribuidosAoProjeto(
		List<DadosUsuariosLideresAtribuidos> lideresAtribuidos,
		List<DadosUsuariosAnalistasAtribuidos> analistasAtribuidos
		
		) {
	
}
