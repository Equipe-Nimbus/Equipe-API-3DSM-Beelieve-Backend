package com.api.beelieve.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.beelieve.entidades.nivelsubprojeto.NivelSubProjeto;
import com.api.beelieve.entidades.subprojeto.SubProjeto;


public interface NivelSubProjetoRepositorio extends JpaRepository<NivelSubProjeto, Long> {

	List<NivelSubProjeto> findBySubProjeto(SubProjeto subProjeto);

}
