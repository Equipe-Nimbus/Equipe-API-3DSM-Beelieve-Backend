package com.api.beelieve.repositorio;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.api.beelieve.entidade.cronograma.Cronograma;

public interface CronogramaRepositorio extends MongoRepository<Cronograma, Long> {

}
