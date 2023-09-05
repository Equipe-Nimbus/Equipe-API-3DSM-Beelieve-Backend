package com.api.beelieve.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tarefa")
public class Tarefa {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tarefaId;
	
	@Column
	private String descricaoAtividade;
	
	@Column
	private String resultadoEsperado;
	
	@Column
	private Boolean status;
	
	@ManyToOne
	@JoinColumn(name = "subProjetoId")
	private SubProjeto atreladoSubProjeto;
	
	@ManyToOne
	@JoinColumn(name = "moduloSubProjetoId")
	private ModuloSubProjeto atreladoModuloSubProjeto;

	
	
	
	public Long getTarefaId() {
		return tarefaId;
	}

	public void setTarefaId(Long tarefaId) {
		this.tarefaId = tarefaId;
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

	public SubProjeto getAtreladoSubProjeto() {
		return atreladoSubProjeto;
	}

	public void setAtreladoSubProjeto(SubProjeto atreladoSubProjeto) {
		this.atreladoSubProjeto = atreladoSubProjeto;
	}

	public ModuloSubProjeto getAtreladoModuloSubProjeto() {
		return atreladoModuloSubProjeto;
	}

	public void setAtreladoModuloSubProjeto(ModuloSubProjeto atreladoModuloSubProjeto) {
		this.atreladoModuloSubProjeto = atreladoModuloSubProjeto;
	}

	




}
