package com.api.beelieve.entidades;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@EqualsAndHashCode
@Table(name = "subProjeto")
@ToString
public class SubProjeto implements tipoProjeto{

	@EqualsAndHashCode.Include
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sub_projeto_id;
	
	@Column
	private String nomeSubProjeto;
	
	@OneToMany(mappedBy = "subProjeto", cascade = CascadeType.PERSIST)
	private List<Tarefa> tarefas;
	
	@OneToMany(mappedBy = "subProjeto", cascade = CascadeType.PERSIST)
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
	@JoinColumn(name = "projeto_id")
	private Projeto projeto;
	
	@PrePersist
	public void persistenciaChaveEstrangeira() {
		if (tarefas != null) {
			tarefas.forEach((tarefa)->{
				tarefa.setSubProjeto(this);
			});
		}
		else if (moduloSubProjeto != null) {
			moduloSubProjeto.forEach((modulo)->{
				modulo.setSubProjeto(this);
			});
		}
			
	}
	
	


	public Long getSub_projeto_id() {
		return sub_projeto_id;
	}

	public void setSub_projeto_id(Long sub_projeto_id) {
		this.sub_projeto_id = sub_projeto_id;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
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
