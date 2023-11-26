package com.api.beelieve.entidades.usuario.dto;

import java.util.List;

public record DadosUsuariosAtribuicaoSeparado(
			List<DadosListagemUsuarioAtribuicao> EngenheirosChefe,
			List<DadosListagemUsuarioAtribuicao> LideresPacotes,
			List<DadosListagemUsuarioAtribuicao> Analista
		) {
	
}
