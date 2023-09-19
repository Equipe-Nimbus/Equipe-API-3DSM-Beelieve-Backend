package com.api.beelieve.entidades.nivelsubprojeto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.api.beelieve.entidades.subprojeto.SubProjeto;
import com.api.beelieve.entidades.tarefa.Tarefa;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "nivelSubProjeto")
@NoArgsConstructor
@Getter
@Setter
public class NivelSubProjeto{


	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_nivel_sub_projeto;
	
	@Column
	private String ordem_nivel_sub_projeto;
	
	@Column
	private String nome_nivel_sub_projeto;
	
	@JsonBackReference
	@OneToMany(mappedBy = "nivelSubProjeto", cascade = CascadeType.ALL)
	private List<Tarefa> tarefas;
	
	@Column
	private Date prazo_nivel_sub_projeto;
	
	@Column
	private Double progresso_nivel_sub_projeto;
	
	@Column
	private BigDecimal orcamento_nivel_sub_projeto;
	
	@Column
	private BigDecimal hora_humano_nivel_sub_projeto;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "sub_projeto_id")
	private SubProjeto subProjeto;
	
	
	public NivelSubProjeto() {
		
	}
	
	public NivelSubProjeto(DadosNivelSubProjetoAtualizacao dadosNivelSubProjeto, SubProjeto subProjeto) {
		this.nome_nivel_sub_projeto = dadosNivelSubProjeto.nome_nivel_sub_projeto();
		this.orcamento_nivel_sub_projeto = dadosNivelSubProjeto.orcamento_nivel_sub_projeto();
		this.hora_humano_nivel_sub_projeto = dadosNivelSubProjeto.hora_humano_nivel_sub_projeto();
		this.prazo_nivel_sub_projeto = dadosNivelSubProjeto.prazo_nivel_sub_projeto();
		this.subProjeto = subProjeto;
		this.progresso_nivel_sub_projeto = dadosNivelSubProjeto.progresso_nivel_sub_projeto();
		if (!dadosNivelSubProjeto.tarefas().isEmpty()) {
			List<Tarefa> listaTarefas = new ArrayList<Tarefa>();
			dadosNivelSubProjeto.tarefas().forEach((dadosTarefa)->{
				listaTarefas.add(new Tarefa(dadosTarefa, this));
			});
			this.tarefas = listaTarefas;
		};
	}





	public NivelSubProjeto(DadosNivelSubProjetoCadastro nivelSubProj, SubProjeto subProjeto) {
		this.nome_nivel_sub_projeto = nivelSubProj.nome_nivel_sub_projeto();
		this.hora_humano_nivel_sub_projeto = nivelSubProj.hora_humano_nivel_sub_projeto();
		this.orcamento_nivel_sub_projeto = nivelSubProj.orcamento_nivel_sub_projeto();
		this.prazo_nivel_sub_projeto = nivelSubProj.prazo_nivel_sub_projeto();
		this.subProjeto = subProjeto;
		this.progresso_nivel_sub_projeto = nivelSubProj.progresso_nivel_sub_projeto();
		this.ordem_nivel_sub_projeto = nivelSubProj.ordem_nivel_sub_projeto();
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
		return id_nivel_sub_projeto;
	}

	public void setNivel_sub_projeto_id(Long nivel_sub_projeto_id) {
		this.id_nivel_sub_projeto = nivel_sub_projeto_id;
	}

	public String getNomeNivelSubProjeto() {
		return nome_nivel_sub_projeto;
	}

	public void setNomeNivelSubProjeto(String nomeNivelSubProjeto) {
		this.nome_nivel_sub_projeto = nomeNivelSubProjeto;
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	public Date getPrazoNivelSubProjeto() {
		return prazo_nivel_sub_projeto;
	}

	public void setPrazoNivelSubProjeto(Date prazoModuloSubProjeto) {
		this.prazo_nivel_sub_projeto = prazoModuloSubProjeto;
	}

	public Double getProgresso() {
		return progresso_nivel_sub_projeto;
	}

	public void setProgresso(Double progresso) {
		this.progresso_nivel_sub_projeto = progresso;
	}

	public BigDecimal getOrcamentoNivelSubProjeto() {
		return orcamento_nivel_sub_projeto;
	}

	public void setOrcamentoNivelSubProjeto(BigDecimal orcamentoNivelSubProjeto) {
		this.orcamento_nivel_sub_projeto = orcamentoNivelSubProjeto;
	}

	public BigDecimal getHoraNivelHomemSubProjeto() {
		return hora_humano_nivel_sub_projeto;
	}

	public void setHoraNivelHomemSubProjeto(BigDecimal horaNivelHomemSubProjeto) {
		this.hora_humano_nivel_sub_projeto = horaNivelHomemSubProjeto;
	}

	
	
	
}
