package com.api.beelieve.entidades.nivelsubprojeto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.api.beelieve.entidades.tipoProjeto;
import com.api.beelieve.entidades.subprojeto.SubProjeto;
import com.api.beelieve.entidades.tarefa.Tarefa;

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
import lombok.NoArgsConstructor;

@Entity
@Table(name = "nivelSubProjeto")
@NoArgsConstructor
public class NivelSubProjeto implements tipoProjeto {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long nivel_sub_projeto_id;
	
	@Column
	private String nomeNivelSubProjeto;
	
	@OneToMany(mappedBy = "nivelSubProjeto", cascade = CascadeType.ALL)
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
	
	
	public NivelSubProjeto() {
		
	}
	
	public NivelSubProjeto(DadosNivelSubProjetoAtualizacao dadosNivelSubProjeto, SubProjeto subProjeto) {
		this.nomeNivelSubProjeto = dadosNivelSubProjeto.nomeNivelSubProjeto();
		this.orcamentoNivelSubProjeto = dadosNivelSubProjeto.orcamentoNivelSubProjeto();
		this.horaNivelHomemSubProjeto = dadosNivelSubProjeto.horaHomemNivelSubProjeto();
		this.prazoNivelSubProjeto = dadosNivelSubProjeto.prazoNivelSubProjeto();
		this.subProjeto = subProjeto;
		if (!dadosNivelSubProjeto.tarefas().isEmpty()) {
			List<Tarefa> listaTarefas = new ArrayList<Tarefa>();
			dadosNivelSubProjeto.tarefas().forEach((dadosTarefa)->{
				listaTarefas.add(new Tarefa(dadosTarefa, this));
			});
			this.tarefas = listaTarefas;
		};
	}





	public NivelSubProjeto(DadosNivelSubProjetoCadastro nivelSubProj, SubProjeto subProjeto) {
		this.nomeNivelSubProjeto = nivelSubProj.nomeNivelSubProjeto();
		this.horaNivelHomemSubProjeto = nivelSubProj.horaNivelHomemSubProjeto();
		this.orcamentoNivelSubProjeto = nivelSubProj.orcamentoNivelSubProjeto();
		this.prazoNivelSubProjeto = nivelSubProj.prazoNivelSubProjeto();
		this.subProjeto = subProjeto;
		if(nivelSubProj.tarefas() != null) {
			List<Tarefa> tarefas = new ArrayList<Tarefa>();
			nivelSubProj.tarefas().forEach((tarefa)->{
				tarefas.add(new Tarefa(tarefa, this));
			});
			this.tarefas = tarefas;
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
