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
@Table(name = "moduloSubProjeto")
public class ModuloSubProjeto implements tipoProjeto {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long moduloSubProjetoId;
	
	@Column
	private String nomeModuloSubProjeto;
	
	@OneToMany(mappedBy = "atreladoModuloSubProjeto")
	private List<Tarefa> tarefas;
	
	@Column
	private Date prazoModuloSubProjeto;
	
	@Column
	private BigDecimal progresso;
	
	@Column
	private BigDecimal orcamentoModuloSubProjeto;
	
	@Column
	private BigDecimal horaModuloHomemSubProjeto;

	@ManyToOne
	@JoinColumn(name = "subProjetoId")
	private SubProjeto atreladoSubProjeto;
	
	
	
	
	
	public SubProjeto getAtreladoSubProjeto() {
		return atreladoSubProjeto;
	}

	public void setAtreladoSubProjeto(SubProjeto atreladoSubProjeto) {
		this.atreladoSubProjeto = atreladoSubProjeto;
	}

	
	public Long getModuloSubProjetoId() {
		return moduloSubProjetoId;
	}

	public void setModuloSubProjetoId(Long moduloSubProjetoId) {
		this.moduloSubProjetoId = moduloSubProjetoId;
	}

	public String getNomeModuloSubProjeto() {
		return nomeModuloSubProjeto;
	}

	public void setNomeModuloSubProjeto(String nomeModuloSubProjeto) {
		this.nomeModuloSubProjeto = nomeModuloSubProjeto;
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	public Date getPrazoModuloSubProjeto() {
		return prazoModuloSubProjeto;
	}

	public void setPrazoModuloSubProjeto(Date prazoModuloSubProjeto) {
		this.prazoModuloSubProjeto = prazoModuloSubProjeto;
	}

	public BigDecimal getProgresso() {
		return progresso;
	}

	public void setProgresso(BigDecimal progresso) {
		this.progresso = progresso;
	}

	public BigDecimal getOrcamentoModuloSubProjeto() {
		return orcamentoModuloSubProjeto;
	}

	public void setOrcamentoModuloSubProjeto(BigDecimal orcamentoModuloSubProjeto) {
		this.orcamentoModuloSubProjeto = orcamentoModuloSubProjeto;
	}

	public BigDecimal getHoraModuloHomemSubProjeto() {
		return horaModuloHomemSubProjeto;
	}

	public void setHoraModuloHomemSubProjeto(BigDecimal horaModuloHomemSubProjeto) {
		this.horaModuloHomemSubProjeto = horaModuloHomemSubProjeto;
	}

	
	
	
}
