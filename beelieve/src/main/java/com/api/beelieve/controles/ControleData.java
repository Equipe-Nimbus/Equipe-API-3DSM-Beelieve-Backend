package com.api.beelieve.controles;





import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.beelieve.entidades.data.DataCustomizada;
import com.api.beelieve.entidades.data.servico.AdicionaUmDia;
import com.api.beelieve.repositorio.DataRepositorio;



@RestController
@RequestMapping("/data")
public class ControleData {

	@Autowired
	private DataRepositorio data_repositorio;
	
	@Autowired
	private AdicionaUmDia manipulaData;
	
	@PostMapping
	public void mudaHora(@RequestBody DataCustomizada dataMudanca) {
		DataCustomizada data = data_repositorio.findById(Long.valueOf(1)).get();
		data.setData(manipulaData.adicionaDia(dataMudanca.getData()));
		data_repositorio.save(data);
		System.out.println(data);
	}
}
