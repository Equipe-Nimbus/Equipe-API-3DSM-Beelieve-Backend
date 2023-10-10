package com.api.beelieve.entidades.cronograma.servico;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.beelieve.entidades.cronograma.Cronograma;
import com.api.beelieve.entidades.data.DataAtualAplicacao;
import com.api.beelieve.entidades.projeto.Projeto;
import com.api.beelieve.repositorio.CronogramaRepositorio;
import com.api.beelieve.repositorio.ProjetoRepositorio;

@Service
public class AtualizaProgressoRealCronograma {
	
	@Autowired
	private CronogramaRepositorio cronograma_repositorio;
	
	@Autowired
	private InicializacaoMesesCronograma mesesCronograma;
	
	@Autowired
	private DataAtualAplicacao dataAtualAplicacao;
	
	private int diferencaAno;

	public void atualizarProgressoCronograma(Long id_projeto, String tipo_entidade, Long id_entidade, Double progresso_real) {
		diferencaAno = 0;
		Cronograma cronograma = cronograma_repositorio.findById(id_projeto).get();
		Calendar calendarioInicial = Calendar.getInstance();
		Calendar calendarioAtual = Calendar.getInstance();
		calendarioInicial.setTime(cronograma.getInicio_projeto());
		calendarioAtual.setTime(dataAtualAplicacao.data);
		int numeroMes = calendarioAtual.get(calendarioAtual.MONTH) + 1;
		String mesProgresso = mesesCronograma.converteNumeroMes(numeroMes);
		
		diferencaAno = Math.abs(calendarioAtual.get(calendarioAtual.YEAR) - calendarioInicial.get(calendarioInicial.YEAR));
		System.out.println("Data atual: " + calendarioAtual.get(calendarioAtual.YEAR));
		System.out.println("Data inicial: " + calendarioInicial.get(calendarioInicial.YEAR));
		System.out.println("Diferença " + diferencaAno);
		
		cronograma.getLista_cronograma().forEach((mes)->{
			if(mesProgresso.equals(mes.getMes_cronograma())) {
				mes.getNiveis().forEach((entidade)->{
					if(entidade.getId_nivel() == id_entidade && entidade.getTipo().equals(tipo_entidade)) {
						if(diferencaAno == 0) {
							entidade.setProgresso_real(progresso_real * 100);
						}
						else {
							diferencaAno -= 1;
						}
					}
				});
			}
		});
		cronograma_repositorio.save(cronograma);
	}
}
