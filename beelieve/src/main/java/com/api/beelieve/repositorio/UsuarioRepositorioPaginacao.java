package com.api.beelieve.repositorio;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.api.beelieve.entidades.usuario.Usuario;

public interface UsuarioRepositorioPaginacao extends PagingAndSortingRepository<Usuario, Long>, JpaSpecificationExecutor<Usuario> {

}
