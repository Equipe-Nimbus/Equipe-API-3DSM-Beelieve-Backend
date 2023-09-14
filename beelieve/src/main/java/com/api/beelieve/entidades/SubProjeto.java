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
@Table(name = "subProjeto")
@ToString
public class SubProjeto {

	@EqualsAndHashCode.Include
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_sub_projeto;
	
	@Column
	private String ordem_sub_projeto;
	
	@Column
	private String nome_sub_projeto;
	
	@OneToMany(mappedBy = "sub_projeto", cascade = CascadeType.PERSIST)
	private List<Tarefa> tarefas;
	
	@OneToMany(mappedBy = "sub_projeto", cascade = CascadeType.PERSIST)
	private List<NivelSubProjeto> nivel_sub_projeto;
	
	@Column
	private String chefe_sub_projeto;
	
	@Column
	private Date prazo_sub_projeto;
	
	@Column
	private Double progresso_sub_projeto;
	
	@Column
	private BigDecimal orcamento_sub_projeto;
	
	@Column
	private BigDecimal hora_humano_sub_projeto;

	@ManyToOne
	@JoinColumn(name = "id_porjeto")
	private Projeto projeto;
	
	@PrePersist
	public void persistenciaChaveEstrangeira() {
		if (tarefas != null) {
			tarefas.forEach((tarefa)->{
				tarefa.setSub_projeto(this);
			});
		}
		else if (nivel_sub_projeto != null) {
			nivel_sub_projeto.forEach((modulo)->{
				modulo.setSub_projeto(this);
			});
		}
			
	}

	
	public Long getId_sub_projeto() {
		return id_sub_projeto;
	}

	public void setId_sub_projeto(Long id_sub_projeto) {
		this.id_sub_projeto = id_sub_projeto;
	}

	public String getOrdem_sub_projeto() {
		return ordem_sub_projeto;
	}

	public void setOrdem_sub_projeto(String ordem_sub_projeto) {
		this.ordem_sub_projeto = ordem_sub_projeto;
	}

	public String getNome_sub_projeto() {
		return nome_sub_projeto;
	}

	public void setNome_sub_projeto(String nome_sub_projeto) {
		this.nome_sub_projeto = nome_sub_projeto;
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	public List<NivelSubProjeto> getNivel_sub_projeto() {
		return nivel_sub_projeto;
	}

	public void setNivel_sub_projeto(List<NivelSubProjeto> nivel_sub_projeto) {
		this.nivel_sub_projeto = nivel_sub_projeto;
	}

	public String getChefe_sub_projeto() {
		return chefe_sub_projeto;
	}

	public void setChefe_sub_projeto(String chefe_sub_projeto) {
		this.chefe_sub_projeto = chefe_sub_projeto;
	}

	public Date getPrazo_sub_projeto() {
		return prazo_sub_projeto;
	}

	public void setPrazo_sub_projeto(Date prazo_sub_projeto) {
		this.prazo_sub_projeto = prazo_sub_projeto;
	}

	public Double getProgresso_sub_projeto() {
		return progresso_sub_projeto;
	}

	public void setProgresso_sub_projeto(Double progresso_sub_projeto) {
		this.progresso_sub_projeto = progresso_sub_projeto;
	}

	public BigDecimal getOrcamento_sub_projeto() {
		return orcamento_sub_projeto;
	}

	public void setOrcamento_sub_projeto(BigDecimal orcamento_sub_projeto) {
		this.orcamento_sub_projeto = orcamento_sub_projeto;
	}

	public BigDecimal getHora_humano_sub_projeto() {
		return hora_humano_sub_projeto;
	}

	public void setHora_humano_sub_projeto(BigDecimal hora_humano_sub_projeto) {
		this.hora_humano_sub_projeto = hora_humano_sub_projeto;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
}
