package com.api.beelieve.entidades.tarefa.servico;

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
import com.api.beelieve.entidades.subprojeto.servico.AtualizaProgressoSubProjeto;
import com.api.beelieve.repositorio.NivelSubProjetoRepositorio;
import com.api.beelieve.repositorio.ProjetoRepositorio;
import com.api.beelieve.repositorio.SubProjetoRepositorio;

@Service
public class AtualizaProgressoPorTarefa {

	
	
	@Autowired
	private NivelSubProjetoRepositorio nivel_subprojeto_repositorio;
	
	@Autowired
	private SubProjetoRepositorio subprojeto_repositorio;
	
	@Autowired
	private AtualizaProgressoProjeto atualizaProgressoProjeto;
	
	@Autowired
	private AtualizaProgressoSubProjeto atualizaProgressoSubProjeto;
	

	@Autowired
	private AtualizaProgressoRealCronograma atualizaCronograma;
	

	public void atualizarProgressoSubProjeto(Double progresso_sub_projeto, SubProjeto subProjeto) {
		BigDecimal progressoSub = BigDecimal.valueOf(progresso_sub_projeto);
		progressoSub = progressoSub.setScale(2, RoundingMode.HALF_EVEN);
		subProjeto.setProgresso_sub_projeto(progressoSub.doubleValue());
		Projeto projetoPai = subProjeto.getProjeto();
		List<SubProjeto> subProjetosIrmãos = projetoPai.getSub_projetos();
		atualizaProgressoProjeto.atualizarProgresso(subProjetosIrmãos, projetoPai);

		
		Long id_projeto = projetoPai.getId_projeto();
		
		subprojeto_repositorio.save(subProjeto);
		atualizaCronograma.atualizarProgressoCronograma(id_projeto, "subprojeto", subProjeto.getId_sub_projeto(), progresso_sub_projeto);

	}
	
	public void atualizarProgressoNivelSubProjeto(Double progresso_nivel_sub_projeto, NivelSubProjeto nivelSubProj) {
		BigDecimal progressoNivel = BigDecimal.valueOf(progresso_nivel_sub_projeto);
		progressoNivel = progressoNivel.setScale(2, RoundingMode.HALF_EVEN);
		nivelSubProj.setProgresso_nivel_sub_projeto(progressoNivel.doubleValue());
		SubProjeto subProjetoPai = nivelSubProj.getSubProjeto();
		List<NivelSubProjeto> nivelSubIrmaos = subProjetoPai.getNivel_sub_projeto();
		atualizaProgressoSubProjeto.atualizaProgresso(nivelSubIrmaos, subProjetoPai);
		

		Long id_projeto = subProjetoPai.getProjeto().getId_projeto();
		
		nivel_subprojeto_repositorio.save(nivelSubProj);
		atualizaCronograma.atualizarProgressoCronograma(id_projeto, "nivelsubprojeto", nivelSubProj.getId_nivel_sub_projeto(), progresso_nivel_sub_projeto);

	}
	
	

}
