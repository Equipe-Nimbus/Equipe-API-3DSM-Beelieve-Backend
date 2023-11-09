package com.api.beelieve.entidades.nivelsubprojeto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.api.beelieve.entidades.cronograma.Cronograma;
import com.api.beelieve.entidades.nivelsubprojeto.dto.DadosEstruturaNivelSubProjetoAtualizacao;
import com.api.beelieve.entidades.nivelsubprojeto.dto.DadosNivelSubProjetoCadastro;
import com.api.beelieve.entidades.subprojeto.SubProjeto;
import com.api.beelieve.entidades.tarefa.Tarefa;
import com.api.beelieve.entidades.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonBackReference;

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
import lombok.Setter;


@Entity
@Table(name = "nivelSubProjeto")
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
	@OneToMany(mappedBy = "nivelSubProjeto")
	private List<Tarefa> tarefas;
	
	@Column
	private Date prazo_nivel_sub_projeto;
	
	@Column
	private Double progresso_nivel_sub_projeto;
	
	@Column
	private BigDecimal orcamento_nivel_sub_projeto;
	
	@Column
	private BigDecimal hora_humano_nivel_sub_projeto;
	
	@Column
	private BigDecimal materiais_nivel_sub_projeto;

	

	@ManyToOne
	@JoinColumn(name = "id_sub_projeto")
	private SubProjeto subProjeto;
	

	
	public NivelSubProjeto() {
		
	}
	
	public NivelSubProjeto(DadosEstruturaNivelSubProjetoAtualizacao dadosNivelSubProjeto, SubProjeto subProjeto) {
		this.nome_nivel_sub_projeto = dadosNivelSubProjeto.nome_nivel_sub_projeto();
		this.ordem_nivel_sub_projeto = dadosNivelSubProjeto.ordem_nivel_sub_projeto();
		this.subProjeto = subProjeto;
	}





	public NivelSubProjeto(DadosNivelSubProjetoCadastro nivelSubProj, SubProjeto subProjeto) {
		this.nome_nivel_sub_projeto = nivelSubProj.nome_nivel_sub_projeto();
		this.subProjeto = subProjeto;
		this.ordem_nivel_sub_projeto = nivelSubProj.ordem_nivel_sub_projeto();
		this.progresso_nivel_sub_projeto = 0.0;
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
