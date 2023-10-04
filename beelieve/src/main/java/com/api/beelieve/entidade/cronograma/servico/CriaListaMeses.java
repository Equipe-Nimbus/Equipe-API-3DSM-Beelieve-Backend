package com.api.beelieve.entidade.cronograma.servico;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.api.beelieve.entidade.cronograma.Mes;
import com.api.beelieve.entidade.cronograma.Progresso;

@Service
public class CriaListaMeses {

	public List<Mes> criarListaMeses(Integer prazo, List<Progresso> niveis){
		List<Mes> meses = new ArrayList<Mes>();
		for(int mes=1; mes<=prazo; mes++) {
			String nome_mes = "Mes " + mes;
			meses.add(new Mes(nome_mes, mes, niveis));
		}
		return meses;
	}
}
