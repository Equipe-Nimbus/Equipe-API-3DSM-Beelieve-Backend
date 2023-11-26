package com.api.beelieve.entidades.projeto.dto;

import java.util.List;

public record DadosListagemProjetoNodesEdges(
		DadosListagemProjeto projeto,
		List<DadosArvoreProjetoBox> listaNodes,
		List<DadosArvoreProjetoLigacao> listaEdges		
		) {

}
