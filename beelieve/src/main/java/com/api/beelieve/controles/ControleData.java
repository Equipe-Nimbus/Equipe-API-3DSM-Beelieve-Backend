package com.api.beelieve.controles;





import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.beelieve.entidades.cronograma.Cronograma;
import com.api.beelieve.entidades.cronograma.servico.InicializacaoMesesCronograma;
import com.api.beelieve.entidades.data.DataAtualAplicacao;
import com.api.beelieve.entidades.data.dto.DadosMudancaDataAplicacao;
import com.api.beelieve.entidades.data.servico.AdicionaUmDia;

import jakarta.persistence.Transient;



@RestController
@RequestMapping("/data")
public class ControleData {
	
	@Autowired
	private AdicionaUmDia manipulaData;
	
	@Autowired
	private InicializacaoMesesCronograma mesesCronograma;
	
	@Autowired
	private DataAtualAplicacao dataAtualAplicacao;
	
	
	@PostMapping("/muda")
	@Transient
	public void mudaHora(@RequestBody DadosMudancaDataAplicacao dataNova) {
		System.out.println(dataNova.dataNova());
		dataAtualAplicacao.data = dataNova.dataNova();
		System.out.println("Data mudada: " + dataAtualAplicacao.data);
	}
	
}
