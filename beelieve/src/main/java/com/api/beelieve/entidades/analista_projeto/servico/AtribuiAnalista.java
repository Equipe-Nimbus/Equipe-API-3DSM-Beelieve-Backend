package com.api.beelieve.entidades.analista_projeto.servico;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.beelieve.entidades.analista_projeto.AnalistaProjeto;
import com.api.beelieve.entidades.projeto.Projeto;
import com.api.beelieve.entidades.usuario.Usuario;
import com.api.beelieve.entidades.usuario.dto.DadosAtribuicaoAnalista;
import com.api.beelieve.repositorio.Analista_ProjetoRepositorio;
import com.api.beelieve.repositorio.ProjetoRepositorio;
import com.api.beelieve.repositorio.UsuarioRepositorio;

import jakarta.transaction.Transactional;

@Service
public class AtribuiAnalista {
	
	@Autowired
	private UsuarioRepositorio repositorio_usuario;
	
	@Autowired
	private ProjetoRepositorio repositorio_projeto;
	
	@Autowired
	private Analista_ProjetoRepositorio repositorio_relacao_analista;
	

	
	@Transactional
	public void atribuir(DadosAtribuicaoAnalista atribuiAnalista) {
		Projeto projeto = repositorio_projeto.findById(atribuiAnalista.id_projeto()).get();
		Usuario analista = repositorio_usuario.findById(atribuiAnalista.id_analista()).get();
		AnalistaProjeto analista_projeto = new AnalistaProjeto();
		analista_projeto.setAnalista(analista);
		analista_projeto.setProjeto(projeto);
		repositorio_relacao_analista.save(analista_projeto);
	}
	
}
