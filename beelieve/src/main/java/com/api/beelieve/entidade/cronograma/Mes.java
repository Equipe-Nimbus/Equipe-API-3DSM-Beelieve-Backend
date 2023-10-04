package com.api.beelieve.entidade.cronograma;

import java.util.ArrayList;
import java.util.List;

import com.api.beelieve.entidade.cronograma.dto.DadosMes;

public class Mes {
	private String mes_cronograma;
	private Double ordem_mes_cronograma;
	private List<Progresso> niveis;
	
	public Mes() {};
	
	public Mes(DadosMes mes) {
		this.mes_cronograma = mes.mes_cronograma();
		this.ordem_mes_cronograma = mes.ordem_mes_cronograma();
		List<Progresso> niveis = new ArrayList<Progresso>();
		mes.niveis().forEach((nivel)->{
			niveis.add(new Progresso(nivel));
		});
		this.niveis = niveis;
	}
}
