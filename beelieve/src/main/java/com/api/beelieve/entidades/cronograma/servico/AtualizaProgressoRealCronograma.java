package com.api.beelieve.entidades.cronograma.servico;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.beelieve.entidades.cronograma.Cronograma;
import com.api.beelieve.entidades.data.DataCustomizada;
import com.api.beelieve.repositorio.CronogramaRepositorio;
import com.api.beelieve.repositorio.DataRepositorio;

@Service
public class AtualizaProgressoRealCronograma {
	
	@Autowired
	private CronogramaRepositorio cronograma_repositorio;
	
	@Autowired
	private InicializacaoMesesCronograma mesesCronograma;
	
	@Autowired
	private DataRepositorio data_repositorio;

	public void atualizarProgressoCronograma(Long id_projeto, String tipo_entidade, Long id_entidade, Double progresso_real) {
		Cronograma cronograma = cronograma_repositorio.findById(id_projeto).get();
		DataCustomizada dataAtual = data_repositorio.findById(Long.valueOf(1)).get();
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(dataAtual.getData());
		int numeroMes = calendario.get(calendario.MONTH) + 1;
		String mesProgresso = mesesCronograma.converteNumeroMes(numeroMes);
		
		cronograma.getLista_cronograma().forEach((mes)->{
			if(mesProgresso.equals(mes.getMes_cronograma())) {
				mes.getNiveis().forEach((entidade)->{
					if(entidade.getId_nivel() == id_entidade && entidade.getTipo().equals(tipo_entidade)) {
						entidade.setProgresso_real(progresso_real);
					
					}
				});
			}
		});
		cronograma_repositorio.save(cronograma);
	}
}
