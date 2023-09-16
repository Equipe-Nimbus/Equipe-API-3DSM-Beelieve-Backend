package com.api.beelieve.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.beelieve.entidades.projeto.Projeto;
import com.api.beelieve.entidades.subprojeto.SubProjeto;

public interface SubProjetoRepositorio extends JpaRepository<SubProjeto, Long>{

	List<SubProjeto> findByProjeto(Projeto projeto);
}
