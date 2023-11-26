package com.api.beelieve.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.beelieve.entidades.analista_projeto.AnalistaProjeto;




public interface Analista_ProjetoRepositorio extends JpaRepository<AnalistaProjeto, Long>{

	List<AnalistaProjeto> findAllByAnalistaIdUsuario(Long id_analista);

}
