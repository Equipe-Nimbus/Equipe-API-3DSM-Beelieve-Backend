package com.api.beelieve.entidades.cronograma.servico;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.api.beelieve.entidades.cronograma.Mes;
import com.api.beelieve.entidades.cronograma.Progresso;

@Service
public class CriaListaMeses {

	public List<Mes> criarListaMeses(Integer prazo, List<Progresso> niveis){
		List<Mes> meses = new ArrayList<Mes>();
		for(int mes=1; mes<=prazo; mes++) {
			String nome_mes = "Mês " + mes;
			meses.add(new Mes(nome_mes, mes, niveis));
		}
		return meses;
	}
}
