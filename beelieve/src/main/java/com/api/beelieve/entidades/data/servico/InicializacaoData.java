package com.api.beelieve.entidades.data.servico;






import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.api.beelieve.entidades.data.DataAtualAplicacao;


@Component
public class InicializacaoData implements ApplicationListener<ApplicationReadyEvent>{
	
	
	@Autowired
	private DataAtualAplicacao dataAtualAplicacao;
	
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
	    // Lógica a ser executada antes de iniciar a aplicação
	    System.out.println("Executando lógica antes de iniciar a aplicação...");
	    // Chame sua função aqui
	    inicioData();
	}
	
	public void inicioData() {
		dataAtualAplicacao.data = new Date();
		System.out.println(dataAtualAplicacao.data);
	}
	
	
}
