package com.api.beelieve.entidades.projeto;

public record DadosArvoreProjetoBox(
		String id,
		String type,
		Data data,
		Position position
		) {
	
	public record Data(String label) {
		
	}
	
	public record Position(Integer x, Integer y) {
		
	}
}
