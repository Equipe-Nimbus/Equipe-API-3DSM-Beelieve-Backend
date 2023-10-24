package com.api.beelieve.entidades.usuario.dto;

public record DadosUsuarioCadastro(
		String nome,
		String matricula,
		String email,
		String senha,
		String cargo,
		String departamento,
		String telefone,
		Boolean is_active
		) {
}