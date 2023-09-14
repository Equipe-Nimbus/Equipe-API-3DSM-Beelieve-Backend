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
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@EqualsAndHashCode
@Table(name = "nivelSubProjeto")
@ToString
public class NivelSubProjeto {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_nivel_sub_projeto;
	
	@Column
	private String ordem_nivel_sub_projeto;
	
	@Column
	private String nome_nivel_sub_projeto;
	
	@OneToMany(mappedBy = "nivel_sub_projeto", cascade = CascadeType.ALL)
	private List<Tarefa> tarefas;
	
	@Column
	private Date prazo_nivel_sub_projeto;
	
	@Column
	private Double progresso_nivel_sub_projeto;
	
	@Column
	private BigDecimal orcamento_nivel_sub_projeto;
	
	@Column
	private BigDecimal hora_humano_nivel_sub_projeto;

	@ManyToOne
	@JoinColumn(name = "sub_projeto_id")
	private SubProjeto sub_projeto;
	
	
	@PrePersist
	public void persistenciaChaveEstrangeira() {
		if (tarefas != null) {
			tarefas.forEach((tarefa)->{
				tarefa.setNivel_sub_projeto(this);
			});
		}	
	}


	public Long getId_nivel_sub_projeto() {
		return id_nivel_sub_projeto;
	}


	public void setId_nivel_sub_projeto(Long id_nivel_sub_projeto) {
		this.id_nivel_sub_projeto = id_nivel_sub_projeto;
	}


	public String getOrdem_nivel_sub_projeto() {
		return ordem_nivel_sub_projeto;
	}


	public void setOrdem_nivel_sub_projeto(String ordem_nivel_sub_projeto) {
		this.ordem_nivel_sub_projeto = ordem_nivel_sub_projeto;
	}


	public String getNome_nivel_sub_projeto() {
		return nome_nivel_sub_projeto;
	}


	public void setNome_nivel_sub_projeto(String nome_nivel_sub_projeto) {
		this.nome_nivel_sub_projeto = nome_nivel_sub_projeto;
	}


	public List<Tarefa> getTarefas() {
		return tarefas;
	}


	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}


	public Date getPrazo_nivel_sub_projeto() {
		return prazo_nivel_sub_projeto;
	}


	public void setPrazo_nivel_sub_projeto(Date prazo_nivel_sub_projeto) {
		this.prazo_nivel_sub_projeto = prazo_nivel_sub_projeto;
	}


	public Double getProgresso_nivel_sub_projeto() {
		return progresso_nivel_sub_projeto;
	}


	public void setProgresso_nivel_sub_projeto(Double progresso_nivel_sub_projeto) {
		this.progresso_nivel_sub_projeto = progresso_nivel_sub_projeto;
	}


	public BigDecimal getOrcamento_nivel_sub_projeto() {
		return orcamento_nivel_sub_projeto;
	}


	public void setOrcamento_nivel_sub_projeto(BigDecimal orcamento_nivel_sub_projeto) {
		this.orcamento_nivel_sub_projeto = orcamento_nivel_sub_projeto;
	}


	public BigDecimal getHora_humano_nivel_sub_projeto() {
		return hora_humano_nivel_sub_projeto;
	}


	public void setHora_humano_nivel_sub_projeto(BigDecimal hora_humano_nivel_sub_projeto) {
		this.hora_humano_nivel_sub_projeto = hora_humano_nivel_sub_projeto;
	}


	public SubProjeto getSub_projeto() {
		return sub_projeto;
	}


	public void setSub_projeto(SubProjeto sub_projeto) {
		this.sub_projeto = sub_projeto;
	}
}
