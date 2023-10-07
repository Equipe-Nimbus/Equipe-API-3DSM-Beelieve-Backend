package com.api.beelieve.entidades.subprojeto.servico;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.beelieve.entidades.cronograma.servico.AtualizaProgressoRealCronograma;
import com.api.beelieve.entidades.nivelsubprojeto.NivelSubProjeto;
import com.api.beelieve.entidades.projeto.Projeto;
import com.api.beelieve.entidades.projeto.servico.AtualizaProgressoProjeto;
import com.api.beelieve.entidades.subprojeto.SubProjeto;
import com.api.beelieve.repositorio.SubProjetoRepositorio;


@Service
public class AtualizaProgressoSubProjeto {

	
	private BigDecimal divisor;
	private BigDecimal dividendo;
	private BigDecimal resultado;
	
	@Autowired
	private AtualizaProgressoProjeto atualizaProgressoProjeto;
	
	@Autowired
	private SubProjetoRepositorio subprojeto_repositorio;
	
	@Autowired
	private AtualizaProgressoRealCronograma atualizaCronograma;
	
	public void atualizaProgresso(List<NivelSubProjeto> niveisSubProj, SubProjeto subProjetoPai) {
		divisor = BigDecimal.valueOf(0);
		dividendo = BigDecimal.valueOf(0);
		resultado = BigDecimal.ZERO;
		
		niveisSubProj.forEach((nivel)->{
			divisor = divisor.add(BigDecimal.valueOf(1));
			dividendo = dividendo.add(BigDecimal.valueOf(nivel.getProgresso_nivel_sub_projeto()));
		});
		
		if(divisor.compareTo(BigDecimal.ZERO) > 0) {
			resultado = dividendo.divide(divisor);
		}
		
		resultado = resultado.setScale(2, RoundingMode.HALF_UP);
		
		subProjetoPai.setProgresso_sub_projeto(resultado.doubleValue());
		
		subprojeto_repositorio.save(subProjetoPai);
		
		atualizaCronograma.atualizarProgressoCronograma(subProjetoPai.getProjeto().getId_projeto(), "subprojeto", subProjetoPai.getId_sub_projeto(), resultado.doubleValue());
		
		Projeto projetoPai = subProjetoPai.getProjeto();
		List<SubProjeto> subProjetosImaos = projetoPai.getSub_projetos();
		
		atualizaProgressoProjeto.atualizarProgresso(subProjetosImaos, projetoPai);
		
	}
}
