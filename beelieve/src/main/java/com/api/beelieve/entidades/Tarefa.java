package com.api.beelieve.entidades;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.ToString;

@Entity
@ToString
@Table(name = "tarefa")
public class Tarefa {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_tarefa;
	
	@Column
	private String descricao_atividade_tarefa;
	
	@Column
	private String resultado_esperado_tarefa;
	
	@Column
	private Integer peso_tarefa;
	
	@Column
	private Integer status_tarefa;
	
	@Column
	private Date prazo_tarefa;
	
	@ManyToOne
	@JoinColumn(name = "sub_projeto_id")
	private SubProjeto sub_projeto;
	
	@ManyToOne
	@JoinColumn(name = "nivel_sub_projeto_id")
	private NivelSubProjeto nivel_sub_projeto;

	public Long getId_tarefa() {
		return id_tarefa;
	}

	public void setId_tarefa(Long id_tarefa) {
		this.id_tarefa = id_tarefa;
	}

	public String getDescricao_atividade_tarefa() {
		return descricao_atividade_tarefa;
	}

	public void setDescricao_atividade_tarefa(String descricao_atividade_tarefa) {
		this.descricao_atividade_tarefa = descricao_atividade_tarefa;
	}

	public String getResultado_esperado_tarefa() {
		return resultado_esperado_tarefa;
	}

	public void setResultado_esperado_tarefa(String resultado_esperado_tarefa) {
		this.resultado_esperado_tarefa = resultado_esperado_tarefa;
	}

	public Integer getPeso_tarefa() {
		return peso_tarefa;
	}

	public void setPeso_tarefa(Integer peso_tarefa) {
		this.peso_tarefa = peso_tarefa;
	}

	public Integer getStatus_tarefa() {
		return status_tarefa;
	}

	public void setStatus_tarefa(Integer status_tarefa) {
		this.status_tarefa = status_tarefa;
	}

	public Date getPrazo_tarefa() {
		return prazo_tarefa;
	}

	public void setPrazo_tarefa(Date prazo_tarefa) {
		this.prazo_tarefa = prazo_tarefa;
	}

	public SubProjeto getSub_projeto() {
		return sub_projeto;
	}

	public void setSub_projeto(SubProjeto sub_projeto) {
		this.sub_projeto = sub_projeto;
	}

	public NivelSubProjeto getNivel_sub_projeto() {
		return nivel_sub_projeto;
	}

	public void setNivel_sub_projeto(NivelSubProjeto nivel_sub_projeto) {
		this.nivel_sub_projeto = nivel_sub_projeto;
	}

	
}
