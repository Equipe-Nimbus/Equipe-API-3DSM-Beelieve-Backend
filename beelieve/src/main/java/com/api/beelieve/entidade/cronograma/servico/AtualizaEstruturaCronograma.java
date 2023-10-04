package com.api.beelieve.entidade.cronograma.servico;

import java.util.Collections;
import java.util.List;
import java.util.Comparator;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.beelieve.entidade.cronograma.Cronograma;
import com.api.beelieve.entidade.cronograma.Mes;
import com.api.beelieve.entidade.cronograma.Progresso;
import com.api.beelieve.entidades.projeto.dto.DadosEstruturaProjetoAtualizacao;
import com.api.beelieve.entidades.subprojeto.dto.DadosEstruturaSubProjetoAtualizacao;
import com.api.beelieve.repositorio.CronogramaRepositorio;

@Service
public class AtualizaEstruturaCronograma {

	@Autowired
	private CronogramaRepositorio cronograma_repositorio;
	
	public List<Progresso> atualizaEstrutura(DadosEstruturaProjetoAtualizacao dadosEstrutura, List<Progresso> novosNiveis) {
		Cronograma cronograma = cronograma_repositorio.findById(dadosEstrutura.id_projeto()).get();
		Mes mesOriginal = cronograma.getLista_cronograma().get(0);
		Mes cloneMes = new Mes(mesOriginal);
		List<Progresso> niveisProgresso = cloneMes.getNiveis();

		
		
		//Atualização
		cronograma.getLista_cronograma().forEach((mes)->{
			mes.getNiveis().forEach((nivel)->{
				if(nivel.getTipo().equals("projeto")) {
					niveisProgresso.remove(nivel);
					nivel.setNome_nivel(dadosEstrutura.nome_projeto());
				}
				else {
					if(dadosEstrutura.sub_projetos() != null) {
						Iterator<DadosEstruturaSubProjetoAtualizacao> iteratorSubProjeto = dadosEstrutura.sub_projetos().iterator();
						dadosEstrutura.sub_projetos().forEach((subprojeto)->{
							if(nivel.getTipo().equals("subprojeto") && nivel.getId_nivel() == subprojeto.id_sub_projeto()) {
								niveisProgresso.remove(nivel);
								nivel.setNome_nivel(subprojeto.nome_sub_projeto());
								nivel.setOrdem_nivel(subprojeto.ordem_sub_projeto());
							}
							else {
								if(subprojeto.nivel_sub_projeto() != null) {
									subprojeto.nivel_sub_projeto().forEach((nivelSubProjeto)->{
										if(nivel.getId_nivel() == nivelSubProjeto.id_nivel_sub_projeto()) {
											niveisProgresso.remove(nivel);
											nivel.setNome_nivel(nivelSubProjeto.nome_nivel_sub_projeto());
											nivel.setOrdem_nivel(nivelSubProjeto.ordem_nivel_sub_projeto());
							
										}
									});
								}
							}
						});
					}				
				}
			});
		});
		
		System.out.println(cronograma);
		
		Iterator<Mes> mesIterator = cronograma.getLista_cronograma().iterator();
		while(mesIterator.hasNext()) {
			Mes mes = mesIterator.next();
			Iterator<Progresso> progressoIterator = mes.getNiveis().iterator();
			while(progressoIterator.hasNext()){
				Progresso nivel = progressoIterator.next();
				if(niveisProgresso != null) {
					niveisProgresso.forEach((deletaveis)->{
						if(nivel.getId_nivel() == deletaveis.getId_nivel() && nivel.getTipo().equals(deletaveis.getTipo())) {
							progressoIterator.remove();
						}
					});
				}
			}
			
		}
		cronograma.getLista_cronograma().forEach((mes)->{
			System.out.println(novosNiveis);
			if(!novosNiveis.isEmpty()) {
				mes.getNiveis().addAll(novosNiveis);
				Collections.sort(mes.getNiveis(), Comparator.comparing(Progresso::getOrdem_nivel));
			}
		});
		
		
		cronograma_repositorio.save(cronograma);
		
		return niveisProgresso;
	
	}
}
