package com.api.beelieve.entidades.subprojeto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.api.beelieve.entidades.nivelsubprojeto.LeituraListaNivelSubProjeto;
import com.api.beelieve.entidades.nivelsubprojeto.NivelSubProjeto;
import com.api.beelieve.entidades.projeto.Projeto;
import com.api.beelieve.entidades.tarefa.LeituraListaTarefa;
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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@EqualsAndHashCode
@Table(name = "subProjeto")
@ToString
@NoArgsConstructor
public class SubProjeto{
	
	@EqualsAndHashCode.Include
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_sub_projeto;
	
	@Column
	private String ordem_sub_projeto;
	
	@Column
	private String nome_sub_projeto;
	
	@OneToMany(mappedBy = "subProjeto", cascade = CascadeType.PERSIST)
	private List<Tarefa> tarefas;
	
	@OneToMany(mappedBy = "subProjeto", cascade = CascadeType.PERSIST)
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
	
	
	public SubProjeto() {
		
	}
	
	public SubProjeto(DadosSubProjetoCadastro dadosSubProjeto, Projeto projetoPai) {
		this.nome_sub_projeto = dadosSubProjeto.nome_sub_projeto();
		this.chefe_sub_projeto = dadosSubProjeto.chefe_sub_projeto();
		this.prazo_sub_projeto = dadosSubProjeto.prazo_sub_projeto();
		this.progresso_sub_projeto = dadosSubProjeto.progresso_sub_projeto();
		this.orcamento_sub_projeto = dadosSubProjeto.orcamento_sub_projeto();
		this.hora_humano_sub_projeto = dadosSubProjeto.hora_humano_sub_projeto();
		this.projeto = projetoPai;
		if(dadosSubProjeto.nivel_sub_projetos() != null) {
			List<NivelSubProjeto> nivelSubProjetos = new ArrayList<NivelSubProjeto>();
			dadosSubProjeto.nivel_sub_projetos().forEach((nivelSubProj)->{
				nivelSubProjetos.add(new NivelSubProjeto(nivelSubProj, this)); 
			});
			this.nivel_sub_projeto = nivelSubProjetos;
				
		}
		else if(dadosSubProjeto.tarefas() != null) {
			List<Tarefa> tarefas = new ArrayList<Tarefa>();
			dadosSubProjeto.tarefas().forEach((tarefa)->{
				tarefas.add(new Tarefa(tarefa, this));
			});
			this.tarefas = tarefas;
		}
	}

	public SubProjeto(DadosSubProjetoAtualizacao dadosSubProjeto, Projeto projetoPai) {
			this.nome_sub_projeto = dadosSubProjeto.nome_sub_projeto();
			this.chefe_sub_projeto = dadosSubProjeto.chefe_sub_projeto();
			this.prazo_sub_projeto = dadosSubProjeto.prazo_sub_projeto();
			this.progresso_sub_projeto = dadosSubProjeto.progresso_sub_projeto();
			this.orcamento_sub_projeto = dadosSubProjeto.orcamento_sub_projeto();
			this.hora_humano_sub_projeto = dadosSubProjeto.hora_humano_sub_projeto();
			this.projeto = projetoPai;
			//Conversão de listas de DadosNivelSubProjetoAtualizacao e DadosTarefaAtualizacao para listas de NivelSubProjeto e de Tarefa
			if(!dadosSubProjeto.nivel_sub_projetos().isEmpty()) {
				List<NivelSubProjeto> listaNivelSubProjetos = new ArrayList<NivelSubProjeto>();
				dadosSubProjeto.nivel_sub_projetos().forEach((dadosNivelSubProjeto)->{
					listaNivelSubProjetos.add(new NivelSubProjeto(dadosNivelSubProjeto, this));
				});
			}
			else if (!dadosSubProjeto.tarefas().isEmpty()) {
				List<Tarefa> listaTarefas = new ArrayList<Tarefa>();
				dadosSubProjeto.tarefas().forEach((dadosTarefa)->{
					listaTarefas.add(new Tarefa(dadosTarefa, this));
				});
				this.tarefas = listaTarefas;
			};
			
	}



	
	


	public Long getSub_projeto_id() {
		return id_sub_projeto;
	}

	public void setSub_projeto_id(Long sub_projeto_id) {
		this.id_sub_projeto = sub_projeto_id;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public String getNomeSubProjeto() {
		return nome_sub_projeto;
	}

	public void setNomeSubProjeto(String nomeSubProjeto) {
		this.nome_sub_projeto = nomeSubProjeto;
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	public List<NivelSubProjeto> getNivelSubProjeto() {
		return nivel_sub_projeto;
	}

	public void setNivelSubProjeto(List<NivelSubProjeto> nivelSubProjeto) {
		this.nivel_sub_projeto = nivelSubProjeto;
	}



	public String getChefeSubProjeto() {
		return chefe_sub_projeto;
	}

	public void setChefeSubProjeto(String chefeSubProjeto) {
		this.chefe_sub_projeto = chefeSubProjeto;
	}

	public Date getPrazoSubProjeto() {
		return prazo_sub_projeto;
	}

	public void setPrazoSubProjeto(Date prazoSubProjeto) {
		this.prazo_sub_projeto = prazoSubProjeto;
	}

	public Double getProgresso() {
		return progresso_sub_projeto;
	}

	public void setProgresso(Double progresso) {
		this.progresso_sub_projeto = progresso;
	}

	public BigDecimal getOrcamentoSubProjeto() {
		return orcamento_sub_projeto;
	}

	public void setOrcamentoSubProjeto(BigDecimal orcamentoSubProjeto) {
		this.orcamento_sub_projeto = orcamentoSubProjeto;
	}

	public BigDecimal getHoraHomemSubprojeto() {
		return hora_humano_sub_projeto;
	}

	public void setHoraHomemSubprojeto(BigDecimal horaHomemSubprojeto) {
		this.hora_humano_sub_projeto = horaHomemSubprojeto;
	}
	
	
}
