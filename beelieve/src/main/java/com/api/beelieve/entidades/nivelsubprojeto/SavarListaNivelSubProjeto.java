package com.api.beelieve.entidades.nivelsubprojeto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.beelieve.entidades.subprojeto.SubProjeto;
import com.api.beelieve.repositorio.NivelSubProjetoRepositorio;

@Service
public class SavarListaNivelSubProjeto {
	
	@Autowired
	private NivelSubProjetoRepositorio repositorio_nivel;

	public void salvar(List<DadosNivelSubProjetoAtualizacao> listaDadosNivelSubProjeto, SubProjeto subProjeto) {
		listaDadosNivelSubProjeto.forEach((dadosNivel)->{
			repositorio_nivel.save(new NivelSubProjeto(dadosNivel, subProjeto));
		});
		
	}

}
