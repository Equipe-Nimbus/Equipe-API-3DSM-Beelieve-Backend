package com.api.beelieve.entidades;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "nivelSubProjeto")
public class NivelSubProjeto implements tipoProjeto {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long nivel_sub_projeto_id;
	
	@Column
	private String nomeNivelSubProjeto;
	
	@OneToMany(mappedBy = "NivelSubProjeto", cascade = CascadeType.ALL)
	private List<Tarefa> tarefas;
	
	@Column
	private Date prazoNivelSubProjeto;
	
	@Column
	private BigDecimal progresso;
	
	@Column
	private BigDecimal orcamentoNivelSubProjeto;
	
	@Column
	private BigDecimal horaNivelHomemSubProjeto;

	@ManyToOne
	@JoinColumn(name = "sub_projeto_id")
	private SubProjeto subProjeto;
	
	
	@PrePersist
	public void persistenciaChaveEstrangeira() {
		if (tarefas != null) {
			tarefas.forEach((tarefa)->{
				tarefa.setNivelSubProjeto(this);
			});
		}	
	}
	
	



	public SubProjeto getSubProjeto() {
		return subProjeto;
	}

	public void setSubProjeto(SubProjeto subProjeto) {
		this.subProjeto = subProjeto;
	}

	

	public Long getNivel_sub_projeto_id() {
		return nivel_sub_projeto_id;
	}

	public void setNivel_sub_projeto_id(Long nivel_sub_projeto_id) {
		this.nivel_sub_projeto_id = nivel_sub_projeto_id;
	}

	public String getNomeNivelSubProjeto() {
		return nomeNivelSubProjeto;
	}

	public void setNomeNivelSubProjeto(String nomeNivelSubProjeto) {
		this.nomeNivelSubProjeto = nomeNivelSubProjeto;
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	public Date getPrazoNivelSubProjeto() {
		return prazoNivelSubProjeto;
	}

	public void setPrazoNivelSubProjeto(Date prazoModuloSubProjeto) {
		this.prazoNivelSubProjeto = prazoModuloSubProjeto;
	}

	public BigDecimal getProgresso() {
		return progresso;
	}

	public void setProgresso(BigDecimal progresso) {
		this.progresso = progresso;
	}

	public BigDecimal getOrcamentoNivelSubProjeto() {
		return orcamentoNivelSubProjeto;
	}

	public void setOrcamentoNivelSubProjeto(BigDecimal orcamentoNivelSubProjeto) {
		this.orcamentoNivelSubProjeto = orcamentoNivelSubProjeto;
	}

	public BigDecimal getHoraNivelHomemSubProjeto() {
		return horaNivelHomemSubProjeto;
	}

	public void setHoraNivelHomemSubProjeto(BigDecimal horaNivelHomemSubProjeto) {
		this.horaNivelHomemSubProjeto = horaNivelHomemSubProjeto;
	}

	
	
	
}
