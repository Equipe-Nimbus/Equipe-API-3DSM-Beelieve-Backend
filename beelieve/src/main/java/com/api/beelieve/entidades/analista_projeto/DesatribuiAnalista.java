package com.api.beelieve.entidades.analista_projeto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.beelieve.entidades.projeto.Projeto;
import com.api.beelieve.entidades.usuario.Usuario;
import com.api.beelieve.entidades.usuario.dto.DadosAtribuicaoAnalista;
import com.api.beelieve.repositorio.Analista_ProjetoRepositorio;
import com.api.beelieve.repositorio.ProjetoRepositorio;
import com.api.beelieve.repositorio.UsuarioRepositorio;

import jakarta.transaction.Transactional;

@Service
public class DesatribuiAnalista {
	
	@Autowired
	private Analista_ProjetoRepositorio analista_projeto_repositorio;

	
	private AnalistaProjeto relacaoAlvo = null;
	
	@Transactional
	public void desatribuirAnalista(DadosAtribuicaoAnalista dadosDesatribuicao) {
		List<AnalistaProjeto> lista_analista_projeto = analista_projeto_repositorio.findAllByAnalistaIdUsuario(dadosDesatribuicao.id_analista());
		
		lista_analista_projeto.forEach((relacao)->{
			if(relacao.getProjeto().getId_projeto() == dadosDesatribuicao.id_projeto()) {
				relacaoAlvo = relacao;
				relacao.setAnalista(null);
				relacao.setProjeto(null);
				analista_projeto_repositorio.delete(relacaoAlvo);
			}
		});

	}
}
