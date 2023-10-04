package com.api.beelieve.entidade.cronograma;

import com.api.beelieve.entidade.cronograma.dto.DadosPlanejamento;

public class Progresso {
	
	private String tipo;
	private String ordem_nivel;
	private String nome_nivel; 
	private Long id_nivel;
	private Double progresso_planejado;
	private Double progresso_real;
	
	public Progresso() {}
	
	public Progresso(DadosPlanejamento nivel) {
		this.tipo = nivel.tipo();
		this.ordem_nivel = nivel.ordem_nivel();
		this.nome_nivel = nivel.nome_nivel();
		this.id_nivel = nivel.id_nivel();
		this.progresso_planejado = nivel.progresso_planejado();
		this.progresso_real = 0.0;
	}
}
