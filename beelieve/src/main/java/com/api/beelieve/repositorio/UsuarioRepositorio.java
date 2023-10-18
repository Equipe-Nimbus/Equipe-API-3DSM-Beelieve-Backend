package com.api.beelieve.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.beelieve.entidades.usuario.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{

}
