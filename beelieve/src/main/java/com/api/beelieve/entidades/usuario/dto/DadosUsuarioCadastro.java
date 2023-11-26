package com.api.beelieve.entidades.usuario.dto;

import java.util.List;

import com.api.beelieve.configuracoes.seguranca.Perfil;

public record DadosUsuarioCadastro(
		String nome,
		String matricula,
		String cpf,
		String email,
		String senha,
		String cargo,
		String departamento,
		String telefone,
		Boolean is_active
		) {
}