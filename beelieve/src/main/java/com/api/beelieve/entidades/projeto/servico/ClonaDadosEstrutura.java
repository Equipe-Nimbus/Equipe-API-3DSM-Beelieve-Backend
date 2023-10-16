package com.api.beelieve.entidades.projeto.servico;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.api.beelieve.entidades.nivelsubprojeto.dto.DadosEstruturaNivelSubProjetoAtualizacao;
import com.api.beelieve.entidades.projeto.dto.DadosEstruturaProjetoAtualizacao;
import com.api.beelieve.entidades.subprojeto.dto.DadosEstruturaSubProjetoAtualizacao;

@Service
public class ClonaDadosEstrutura {
	
	public DadosEstruturaProjetoAtualizacao clonar(DadosEstruturaProjetoAtualizacao dadosOriginal) {
		List<DadosEstruturaSubProjetoAtualizacao> listaSub = new ArrayList<DadosEstruturaSubProjetoAtualizacao>();
		
		dadosOriginal.sub_projetos().forEach((subProj)->{
			List<DadosEstruturaNivelSubProjetoAtualizacao> listaNivel = new ArrayList<DadosEstruturaNivelSubProjetoAtualizacao>();
			subProj.nivel_sub_projeto().forEach((nivel)->{
				listaNivel.add(new DadosEstruturaNivelSubProjetoAtualizacao(nivel.id_nivel_sub_projeto(), nivel.nome_nivel_sub_projeto(), nivel.ordem_nivel_sub_projeto(), null));
			});
			listaSub.add(new DadosEstruturaSubProjetoAtualizacao(subProj.id_sub_projeto(), subProj.nome_sub_projeto(), subProj.ordem_sub_projeto(), subProj.orcamento_sub_projeto(), subProj.hora_humano_sub_projeto(), subProj.materiais_sub_projeto(), listaNivel));
		});
		
		DadosEstruturaProjetoAtualizacao dadoClonado = new DadosEstruturaProjetoAtualizacao(dadosOriginal.id_projeto(), dadosOriginal.ordem_projeto(), dadosOriginal.nome_projeto(), dadosOriginal.orcamento_projeto(), dadosOriginal.hora_humano_total(), dadosOriginal.materiais_projeto(), listaSub);
		
		
		return dadoClonado;
		
	}
}
