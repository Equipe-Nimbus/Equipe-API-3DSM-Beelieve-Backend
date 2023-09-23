package com.api.beelieve.entidades.projeto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.api.beelieve.entidades.nivelsubprojeto.DadosListagemNivelSubProjeto;
import com.api.beelieve.entidades.projeto.DadosArvoreProjetoBox.Position;
import com.api.beelieve.entidades.subprojeto.DadosListagemSubProjeto;

@Service
public class MontarArvoreProjeto {

	public List<DadosArvoreProjetoBox> montarArvoreProjetoBox(DadosListagemProjeto projetoSelecionado) {
		List<DadosArvoreProjetoBox> quadradoArvore = new ArrayList<DadosArvoreProjetoBox>();
		DadosListagemProjeto projeto = projetoSelecionado;
		List<DadosListagemSubProjeto> listaSubProjeto = projeto.sub_projetos();
		List<DadosListagemNivelSubProjeto> listaNivelSubProjeto = new ArrayList<DadosListagemNivelSubProjeto>();
		DadosArvoreProjetoBox noProjeto = null;
		DadosArvoreProjetoBox noSubProjeto = null;
		DadosArvoreProjetoBox noNivelSubProjeto = null;
		Position posicao = new DadosArvoreProjetoBox.Position(0, 0);
		noProjeto = new DadosArvoreProjetoBox(
				projeto.ordem_projeto(),
				"input",
				new DadosArvoreProjetoBox.Data(projeto.nome_projeto()),
				posicao
				);
		quadradoArvore.add(noProjeto);
		for (DadosListagemSubProjeto subProjeto : listaSubProjeto) {
			listaNivelSubProjeto.addAll(subProjeto.nivel_sub_projeto());
			if (listaNivelSubProjeto.isEmpty()) {
				noSubProjeto = new DadosArvoreProjetoBox(
						subProjeto.ordem_sub_projeto(),
						"output",
						new DadosArvoreProjetoBox.Data(subProjeto.nome_sub_projeto()),
						posicao
						);
				quadradoArvore.add(noSubProjeto);
			} else {
				noSubProjeto = new DadosArvoreProjetoBox(
						subProjeto.ordem_sub_projeto(),
						"null",
						new DadosArvoreProjetoBox.Data(subProjeto.nome_sub_projeto()),
						posicao
						);
				quadradoArvore.add(noSubProjeto);
				for (DadosListagemNivelSubProjeto nivelSubProjeto : listaNivelSubProjeto) {
					noNivelSubProjeto = new DadosArvoreProjetoBox(
							nivelSubProjeto.ordem_nivel_sub_projeto(),
							"output",
							new DadosArvoreProjetoBox.Data(nivelSubProjeto.nome_nivel_sub_projeto()),
							posicao							
						);
					quadradoArvore.add(noNivelSubProjeto);
				};
				
			};
				
		};		
		return quadradoArvore;
	};
	
	public List<DadosArvoreProjetoLigacao> ligacaoArvoreProjeto (DadosListagemProjeto projetoSelecionado){
		List<DadosArvoreProjetoLigacao> ligacaooArvore = new ArrayList<DadosArvoreProjetoLigacao>();
		DadosListagemProjeto projeto = projetoSelecionado;
		List<DadosListagemSubProjeto> listaSubProjeto = projeto.sub_projetos();
		List<DadosListagemNivelSubProjeto> listaNivelSubProjeto = new ArrayList<DadosListagemNivelSubProjeto>();
		DadosArvoreProjetoLigacao ligacaoProjeto = null;
		DadosArvoreProjetoLigacao ligacaoSubProjeto = null;
		DadosArvoreProjetoLigacao ligacaoNivelSubProjeto = null;
		String type = "smoothstep";
		for (DadosListagemSubProjeto subProjeto : listaSubProjeto) {
			ligacaoProjeto = new DadosArvoreProjetoLigacao(
					"e" + projeto.ordem_projeto() + "-" + subProjeto.ordem_sub_projeto(),
					projeto.ordem_projeto(),
					subProjeto.ordem_sub_projeto(),
					type
					);
			for (DadosListagemNivelSubProjeto nivelSubProjeto : listaNivelSubProjeto) {
				String ordemNivelSubProjeto = nivelSubProjeto.ordem_nivel_sub_projeto();
				
			}
		}
		return ligacaooArvore;
	}
}