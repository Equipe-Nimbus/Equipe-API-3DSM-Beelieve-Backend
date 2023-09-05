package com.api.beelieve.entidades;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "subProjeto")
public class SubProjeto implements tipoProjeto{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long subProjetoId;
	
	@Column
	private String nomeSubProjeto;
	
	@OneToMany(mappedBy = "atreladoSubProjeto")
	private List<Tarefa> tarefas;
	
	@OneToMany(mappedBy = "atreladoSubProjeto")
	private List<ModuloSubProjeto> moduloSubProjeto;
	
	@Column
	private String chefeSubProjeto;
	
	@Column
	private Date prazoSubProjeto;
	
	@Column
	private BigDecimal progresso;
	
	@Column
	private BigDecimal orcamentoSubProjeto;
	
	@Column
	private BigDecimal horaHomemSubprojeto;

	@ManyToOne
	@JoinColumn(name = "projetoId")
	private Projeto atreladoProjeto;
	
	
	
	public Projeto getAtreladoProjeto() {
		return atreladoProjeto;
	}

	public void setAtreladoProjeto(Projeto atreladoProjeto) {
		this.atreladoProjeto = atreladoProjeto;
	}

	public Long getSubProjetoId() {
		return subProjetoId;
	}

	public void setSubProjetoId(Long subProjetoId) {
		this.subProjetoId = subProjetoId;
	}

	public String getNomeSubProjeto() {
		return nomeSubProjeto;
	}

	public void setNomeSubProjeto(String nomeSubProjeto) {
		this.nomeSubProjeto = nomeSubProjeto;
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	public List<ModuloSubProjeto> getModuloSubProjeto() {
		return moduloSubProjeto;
	}

	public void setModuloSubProjeto(List<ModuloSubProjeto> moduloSubProjeto) {
		this.moduloSubProjeto = moduloSubProjeto;
	}



	public String getChefeSubProjeto() {
		return chefeSubProjeto;
	}

	public void setChefeSubProjeto(String chefeSubProjeto) {
		this.chefeSubProjeto = chefeSubProjeto;
	}

	public Date getPrazoSubProjeto() {
		return prazoSubProjeto;
	}

	public void setPrazoSubProjeto(Date prazoSubProjeto) {
		this.prazoSubProjeto = prazoSubProjeto;
	}

	public BigDecimal getProgresso() {
		return progresso;
	}

	public void setProgresso(BigDecimal progresso) {
		this.progresso = progresso;
	}

	public BigDecimal getOrcamentoSubProjeto() {
		return orcamentoSubProjeto;
	}

	public void setOrcamentoSubProjeto(BigDecimal orcamentoSubProjeto) {
		this.orcamentoSubProjeto = orcamentoSubProjeto;
	}

	public BigDecimal getHoraHomemSubprojeto() {
		return horaHomemSubprojeto;
	}

	public void setHoraHomemSubprojeto(BigDecimal horaHomemSubprojeto) {
		this.horaHomemSubprojeto = horaHomemSubprojeto;
	}
	
	
}
