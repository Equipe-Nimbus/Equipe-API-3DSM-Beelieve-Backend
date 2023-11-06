package com.api.beelieve.entidades.usuario.dto;

public record DadosAtualizaUsuario(
		Long id_usuario,
		String nome,
		String email,
		String senha,
		String cargo,
		String departamento,
		String telefone,
		Boolean is_active
		) {

}
