package com.api.beelieve.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.beelieve.entidade.cronograma.Cronograma;

public interface CronogramaRepositorio extends JpaRepository<Cronograma, Long> {

}
