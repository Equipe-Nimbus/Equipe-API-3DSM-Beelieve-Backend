package com.api.beelieve.entidades.data.servico;






import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.api.beelieve.entidades.data.DataCustomizada;
import com.api.beelieve.entidades.data.DataTeste;
import com.api.beelieve.repositorio.DataRepositorio;

@Component
public class InicializacaoData implements ApplicationListener<ApplicationReadyEvent>{
	
	@Autowired
	private DataRepositorio data_repositorio;
	
	@Autowired
	private DataTeste dataTeste;
	
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
	    // Lógica a ser executada antes de iniciar a aplicação
	    System.out.println("Executando lógica antes de iniciar a aplicação...");
	    // Chame sua função aqui
	    inicioData();
	}
	
	public void inicioData() {
		data_repositorio.deleteAll();
		java.util.Date dataSistema = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(dataSistema.getTime());
		DataCustomizada data = new DataCustomizada(sqlDate);
		data_repositorio.save(data); 
		dataTeste.data = data.getData();
		DataCustomizada a = data_repositorio.findById(Long.valueOf(1)).get();
		System.out.println(a);
	}
	
	
}
