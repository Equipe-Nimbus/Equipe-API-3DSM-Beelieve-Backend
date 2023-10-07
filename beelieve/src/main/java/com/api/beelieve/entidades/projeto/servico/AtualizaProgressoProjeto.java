package com.api.beelieve.entidades.projeto.servico;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.beelieve.entidades.cronograma.servico.AtualizaProgressoRealCronograma;
import com.api.beelieve.entidades.projeto.Projeto;
import com.api.beelieve.entidades.subprojeto.SubProjeto;
import com.api.beelieve.repositorio.ProjetoRepositorio;

@Service
public class AtualizaProgressoProjeto {

	
	@Autowired
	private ProjetoRepositorio projeto_repositorio;
	
	@Autowired
	private AtualizaProgressoRealCronograma atualizaCronograma;
	
	private BigDecimal divisor;
	private BigDecimal dividendo;
	private BigDecimal resultado;
	
	public void atualizarProgresso(List<SubProjeto> subProjetosIrmãos, Projeto projeto) {
		
		divisor = BigDecimal.valueOf(0);
		dividendo = BigDecimal.valueOf(0);
		resultado = BigDecimal.ZERO;
		
		subProjetosIrmãos.forEach((subProj)->{
			//System.out.println(subProj.getOrdem_sub_projeto());
			
			divisor = divisor.add(BigDecimal.valueOf(1));
			dividendo = dividendo.add(BigDecimal.valueOf(subProj.getProgresso_sub_projeto()));

		});
		//System.out.println("Divisor: " + divisor);
		//System.out.println("Dividendo: " + dividendo);
		if(divisor.compareTo(BigDecimal.ZERO) > 0) {
			resultado = dividendo.divide(divisor);
		}
		//System.out.println("Resultado: " + resultado);
		
		resultado = resultado.setScale(2, RoundingMode.HALF_UP);
		projeto.setProgresso_projeto(resultado.doubleValue());
		
		
		projeto_repositorio.save(projeto);
		atualizaCronograma.atualizarProgressoCronograma(projeto.getId_projeto(), "projeto", projeto.getId_projeto(), resultado.doubleValue());
	}

	
	
}
