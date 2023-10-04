package com.api.beelieve.entidade.cronograma;

import com.api.beelieve.entidade.cronograma.dto.DadosPlanejamento;
import com.api.beelieve.entidades.nivelsubprojeto.NivelSubProjeto;
import com.api.beelieve.entidades.subprojeto.SubProjeto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Progresso {
	
	private String tipo;
	private String ordem_nivel;
	private String nome_nivel; 
	private Long id_nivel;
	private Double progresso_planejado;
	private Double progresso_real;
	
	public Progresso() {}
	
	public Progresso(SubProjeto subProjeto) {
		this.tipo = "subprojeto";
		this.ordem_nivel = subProjeto.getOrdem_sub_projeto();
		this.nome_nivel = subProjeto.getNomeSubProjeto();
		this.id_nivel = subProjeto.getSub_projeto_id();
		this.progresso_planejado = 0.0;
		this.progresso_real = 0.0;
	}
	
	public Progresso(NivelSubProjeto nivelSubProjeto) {
		this.tipo = "nivelsubprojeto";
		this.ordem_nivel = nivelSubProjeto.getOrdem_nivel_sub_projeto();
		this.nome_nivel = nivelSubProjeto.getNome_nivel_sub_projeto();
		this.id_nivel = nivelSubProjeto.getId_nivel_sub_projeto();
		this.progresso_planejado = 0.0;
		this.progresso_real = 0.0;
	}
	
	public Progresso(DadosPlanejamento nivel) {
		this.tipo = nivel.tipo();
		this.ordem_nivel = nivel.ordem_nivel();
		this.nome_nivel = nivel.nome_nivel();
		this.id_nivel = nivel.id_nivel();
		this.progresso_planejado = nivel.progresso_planejado();
		this.progresso_real = 0.0;
	}

	public Progresso(Progresso nivel) {
		this.tipo = nivel.tipo;
		this.ordem_nivel = nivel.ordem_nivel;
		this.nome_nivel = nivel.nome_nivel;
		this.id_nivel = nivel.id_nivel;
		this.progresso_planejado = nivel.progresso_planejado;
		this.progresso_real = nivel.progresso_real;
	}
}
