package com.api.beelieve.controles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.beelieve.entidade.cronograma.Cronograma;
import com.api.beelieve.entidade.cronograma.dto.DadosCronogramaPlanejamento;
import com.api.beelieve.repositorio.CronogramaRepositorio;

@RestController
@RequestMapping("/cronograma")
public class ControleCronograma {
	
	@Autowired
	private CronogramaRepositorio cronograma_repositorio;

	@PostMapping("/teste")
	public void cadastro(@RequestBody DadosCronogramaPlanejamento cronograma) {
		cronograma_repositorio.save(new Cronograma(cronograma));
	}
	
}
