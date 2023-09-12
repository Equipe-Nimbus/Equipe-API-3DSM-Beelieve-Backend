package com.api.beelieve.entidades;

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
	private Long tarefa_id;
	
	@Column
	private String descricaoAtividade;
	
	@Column
	private String resultadoEsperado;
	
	@Column
	private Boolean status;
	
	@ManyToOne
	@JoinColumn(name = "sub_projeto_id")
	private SubProjeto subProjeto;
	
	@ManyToOne
	@JoinColumn(name = "nivel_sub_projeto_id")
	private NivelSubProjeto nivelSubProjeto;

	
	
	




	public Long getTarefa_id() {
		return tarefa_id;
	}

	public void setTarefa_id(Long tarefa_id) {
		this.tarefa_id = tarefa_id;
	}

	public SubProjeto getSubProjeto() {
		return subProjeto;
	}

	public void setSubProjeto(SubProjeto subProjeto) {
		this.subProjeto = subProjeto;
	}

	public NivelSubProjeto getModuloSubProjeto() {
		return nivelSubProjeto;
	}

	public void setNivelSubProjeto(NivelSubProjeto nivelSubProjeto) {
		this.nivelSubProjeto = nivelSubProjeto;
	}

	public String getDescricaoAtividade() {
		return descricaoAtividade;
	}

	public void setDescricaoAtividade(String descricaoAtividade) {
		this.descricaoAtividade = descricaoAtividade;
	}

	public String getResultadoEsperado() {
		return resultadoEsperado;
	}

	public void setResultadoEsperado(String resultadoEsperado) {
		this.resultadoEsperado = resultadoEsperado;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	




}
