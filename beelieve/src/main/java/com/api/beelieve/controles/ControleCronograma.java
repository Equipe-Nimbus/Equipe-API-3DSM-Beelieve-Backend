package com.api.beelieve.controles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.beelieve.entidades.cronograma.Cronograma;
import com.api.beelieve.entidades.cronograma.dto.DadosCronogramaPlanejamento;
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
	
	@GetMapping("/{id}")
	public Cronograma resgataCronograma(@PathVariable Long id) {
		Cronograma cronograma = cronograma_repositorio.findById(id).get();
		System.out.println(cronograma);
		return cronograma;
	}
	
	
}
