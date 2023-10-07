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
import com.api.beelieve.entidades.data.DataCustomizada;
import com.api.beelieve.entidades.data.servico.AdicionaUmDia;
import com.api.beelieve.repositorio.DataRepositorio;

import jakarta.persistence.Transient;



@RestController
@RequestMapping("/data")
public class ControleData {

	@Autowired
	private DataRepositorio data_repositorio;
	
	@Autowired
	private AdicionaUmDia manipulaData;
	
	@Autowired
	private InicializacaoMesesCronograma mesesCronograma;
	
	
	@PostMapping("/muda")
	@Transient
	public void mudaHora(@RequestBody DataCustomizada dataMudanca) {
		System.out.println(dataMudanca);
		DataCustomizada data = data_repositorio.findById(Long.valueOf(1)).get();
		data.setData(manipulaData.adicionaDia(dataMudanca.getData()));
		data_repositorio.save(data);
		System.out.println(data);
	}
	
	@PostMapping("/teste")
	public String teste(@RequestBody DataCustomizada data) {
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(data.getData());
		calendario.add(Calendar.DAY_OF_MONTH, 1);
		int numeroMes = calendario.get(Calendar.MONTH) + 1;
		mesesCronograma.inicializarCronograma(data.getData(), Long.valueOf(1));
		return mesesCronograma.converteNumeroMes(numeroMes);
		
	}
}
