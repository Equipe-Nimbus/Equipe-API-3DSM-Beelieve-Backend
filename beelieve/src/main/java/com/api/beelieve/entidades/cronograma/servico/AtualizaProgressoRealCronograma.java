package com.api.beelieve.entidades.cronograma.servico;

import java.text.BreakIterator;
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
	private Boolean alteracaoJaFeita = false;
	private int ordem_mes_cronograma = 0;

	public void atualizarProgressoCronograma(Long id_projeto, String tipo_entidade, Long id_entidade, Double progresso_real) {
		diferencaAno = 0;
		Cronograma cronograma = cronograma_repositorio.findById(id_projeto).get();
		Calendar calendarioInicial = Calendar.getInstance();
		Calendar calendarioAtual = Calendar.getInstance();
		calendarioInicial.setTime(cronograma.getInicio_projeto());
		calendarioAtual.setTime(dataAtualAplicacao.data);
		int numeroMesAtual = calendarioAtual.get(calendarioAtual.MONTH) + 1;
		int numeroMesInicial = calendarioInicial.get(calendarioInicial.MONTH);

		
		System.out.println("numeroMesAtual: " + numeroMesAtual);
		System.out.println("numeroMesInicial" + numeroMesInicial);
		
		
		diferencaAno = Math.abs(calendarioAtual.get(calendarioAtual.YEAR) - calendarioInicial.get(calendarioInicial.YEAR));
		
		
		System.out.println("Diferenca ano: " + diferencaAno);
		
		
		System.out.println("Ordem do mes corrigida: " + ((numeroMesAtual - numeroMesInicial) + (12 * diferencaAno)));
		ordem_mes_cronograma = (numeroMesAtual - numeroMesInicial) + (12 * diferencaAno);
		alteracaoJaFeita = false;
		cronograma.getLista_cronograma().forEach((mes)->{
			if(mes.getOrdem_mes_cronograma() == ordem_mes_cronograma || alteracaoJaFeita) {
				mes.getNiveis().forEach((entidade)->{
					if(entidade.getId_nivel() == id_entidade && entidade.getTipo().equals(tipo_entidade)) {
						if(!alteracaoJaFeita) {
							System.out.println("Foooi");
							entidade.setProgresso_real(progresso_real);
							alteracaoJaFeita = true;
						}
						else{
							entidade.setProgresso_real(progresso_real);
						}
					}
				});
			}
		});
		cronograma_repositorio.save(cronograma);
	}
	

	
}
