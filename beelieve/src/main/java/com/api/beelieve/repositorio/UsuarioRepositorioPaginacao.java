package com.api.beelieve.repositorio;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.api.beelieve.entidades.usuario.Usuario;

public interface UsuarioRepositorioPaginacao extends PagingAndSortingRepository<Usuario, Long> {

}
