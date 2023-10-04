package com.api.beelieve.entidade.cronograma;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.api.beelieve.entidade.cronograma.dto.DadosCronogramaPlanejamento;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;



@Data
@ToString
@Document(collection = "Cronograma")
public class Cronograma {

	@Id
	private Long _id;
	
	private List<Mes> lista_cronograma;
	
	public Cronograma() {};
	
	public Cronograma(DadosCronogramaPlanejamento cronogramaPlanejamento){
		this._id = cronogramaPlanejamento.id_projeto();
		List<Mes> lista_cronograma = new ArrayList<Mes>();
		cronogramaPlanejamento.lista_cronograma().forEach((cronograma)->{
			lista_cronograma.add(new Mes(cronograma));
		});
		
		this.lista_cronograma = lista_cronograma;
			
	}

	public Cronograma(Long id_projeto, List<Mes> meses) {
		this._id = id_projeto;
		this.lista_cronograma = meses;
	}
}
