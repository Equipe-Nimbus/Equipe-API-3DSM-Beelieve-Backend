package com.api.beelieve.entidade.cronograma;

import java.math.BigDecimal;
import java.util.Date;

import com.api.beelieve.entidades.nivelsubprojeto.NivelSubProjeto;
import com.api.beelieve.entidades.projeto.Projeto;
import com.api.beelieve.entidades.subprojeto.SubProjeto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cronograma")
@Getter
@Setter
public class Cronograma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_cronograma_mes;
	
	@Column
	private String mes_cronograma;
	
	@Column
	private String ordem_mes_cronograma;
	
	@Column
	private String ano_cronograma;
	
	@Column
	private Date data_limite_cronograma;
	
	@Column
	private Double progresso_planejado_cronograma;
	
	@Column
	private Double progresso_real_cronograma;
	
	@ManyToOne
	@JoinColumn(name = "id_projeto")
	private Projeto projeto;
	
	@ManyToOne
	@JoinColumn(name = "id_sub_projeto")
	private SubProjeto sub_projeto;
	
	@ManyToOne
	@JoinColumn(name = "id_nivel_sub_projeto")
	private NivelSubProjeto nivel_sub_projeto;
	
}
