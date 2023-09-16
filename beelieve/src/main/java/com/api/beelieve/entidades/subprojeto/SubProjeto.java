package com.api.beelieve.entidades.subprojeto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.api.beelieve.entidades.tipoProjeto;
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
public class SubProjeto implements tipoProjeto{
	
	@EqualsAndHashCode.Include
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sub_projeto_id;
	
	@Column
	private String nomeSubProjeto;
	
	@OneToMany(mappedBy = "subProjeto", cascade = CascadeType.PERSIST)
	private List<Tarefa> tarefas;
	
	@OneToMany(mappedBy = "subProjeto", cascade = CascadeType.PERSIST)
	private List<NivelSubProjeto> nivelSubProjeto;
	
	@Column
	private String chefeSubProjeto;
	
	@Column
	private Date prazoSubProjeto;
	
	@Column
	private BigDecimal progressoSubProjeto;
	
	@Column
	private BigDecimal orcamentoSubProjeto;
	
	@Column
	private BigDecimal horaHomemSubprojeto;

	@ManyToOne
	@JoinColumn(name = "projeto_id")
	private Projeto projeto;
	
	
	
	public SubProjeto() {
		
	}
	
	public SubProjeto(DadosSubProjetoCadastro dadosSubProjeto, Projeto projetoPai) {
		this.nomeSubProjeto = dadosSubProjeto.nomeSubProjeto();
		this.chefeSubProjeto = dadosSubProjeto.chefeSubProjeto();
		this.prazoSubProjeto = dadosSubProjeto.prazoSubProjeto();
		this.progressoSubProjeto = dadosSubProjeto.progressoSubProjeto();
		this.orcamentoSubProjeto = dadosSubProjeto.orcamentoSubProjeto();
		this.horaHomemSubprojeto = dadosSubProjeto.horaHomemSubProjeto();
		this.projeto = projetoPai;
		if(dadosSubProjeto.nivelSubProjetos() != null) {
			List<NivelSubProjeto> nivelSubProjetos = new ArrayList<NivelSubProjeto>();
			dadosSubProjeto.nivelSubProjetos().forEach((nivelSubProj)->{
				nivelSubProjetos.add(new NivelSubProjeto(nivelSubProj, this)); 
			});
			this.nivelSubProjeto = nivelSubProjetos;
				
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
			this.nomeSubProjeto = dadosSubProjeto.nomeSubProjeto();
			this.chefeSubProjeto = dadosSubProjeto.chefeSubProjeto();
			this.prazoSubProjeto = dadosSubProjeto.prazoSubProjeto();
			this.progressoSubProjeto = dadosSubProjeto.progressoSubProjeto();
			this.orcamentoSubProjeto = dadosSubProjeto.orcamentoSubProjeto();
			this.horaHomemSubprojeto = dadosSubProjeto.horaHumanoSubProjeto();
			this.projeto = projetoPai;
			//Conversão de listas de DadosNivelSubProjetoAtualizacao e DadosTarefaAtualizacao para listas de NivelSubProjeto e de Tarefa
			if(!dadosSubProjeto.nivelSubProjetos().isEmpty()) {
				List<NivelSubProjeto> listaNivelSubProjetos = new ArrayList<NivelSubProjeto>();
				dadosSubProjeto.nivelSubProjetos().forEach((dadosNivelSubProjeto)->{
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

	public List<NivelSubProjeto> getNivelSubProjeto() {
		return nivelSubProjeto;
	}

	public void setNivelSubProjeto(List<NivelSubProjeto> nivelSubProjeto) {
		this.nivelSubProjeto = nivelSubProjeto;
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
		return progressoSubProjeto;
	}

	public void setProgresso(BigDecimal progresso) {
		this.progressoSubProjeto = progresso;
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
