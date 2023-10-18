package com.api.beelieve.entidades.usuario.dto;

public record DadosUsuarioCadastro(
		String nome,
		String cpf,
		String email,
		String senha,
		String cargo
		) {
}
