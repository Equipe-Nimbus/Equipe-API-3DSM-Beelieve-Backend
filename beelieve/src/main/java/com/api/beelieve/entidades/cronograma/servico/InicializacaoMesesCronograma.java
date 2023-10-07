package com.api.beelieve.entidades.cronograma.servico;

import java.util.Date;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.beelieve.entidades.cronograma.Cronograma;
import com.api.beelieve.repositorio.CronogramaRepositorio;

@Service
public class InicializacaoMesesCronograma {

	@Autowired
	private CronogramaRepositorio cronograma_repositorio;
	
	private int numeroMes;
	
	public void inicializarCronograma(Date dataInicio, Long id_projeto) {
		Cronograma cronograma = cronograma_repositorio.findById(id_projeto).get();
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(dataInicio);
		calendario.add(Calendar.DAY_OF_MONTH, 1);
		numeroMes = calendario.get(calendario.MONTH) + 1;

		cronograma.getLista_cronograma().forEach((mes)->{
			mes.setMes_cronograma(converteNumeroMes(numeroMes));
			if(numeroMes <= 11) {
				numeroMes += 1;
			}
			else {
				numeroMes = 1;
			}
		});
		
		cronograma_repositorio.save(cronograma);
		numeroMes = 0;
	}
	
	public String converteNumeroMes(int numeroMes) {
		String mes = null;
		if(numeroMes == 1) {
			mes = "Janeiro";
		}
		else if (numeroMes == 2) {
			mes = "Fevereiro";
		}
		else if (numeroMes == 3) {
			mes = "Março";
		}
		else if (numeroMes == 4) {
			mes = "Abril";
		}
		else if (numeroMes == 5) {
			mes = "Maio";
		}
		else if (numeroMes == 6) {
			mes = "Junho";
		}
		else if (numeroMes == 7) {
			mes = "Julho";
		}
		else if (numeroMes == 8) {
			mes = "Agosto";
		}
		else if (numeroMes == 9) {
			mes = "Setembro";
		}
		else if (numeroMes == 10) {
			mes = "Outubro";
		}
		else if (numeroMes == 11) {
			mes = "Novembro";
		}
		else if (numeroMes == 12) {
			mes = "Dezembro";
		}
		return mes;
	}
}
