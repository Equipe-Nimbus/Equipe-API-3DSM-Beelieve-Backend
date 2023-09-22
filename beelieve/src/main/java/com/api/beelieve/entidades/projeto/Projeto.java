package com.api.beelieve.entidades.projeto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.api.beelieve.entidades.subprojeto.SubProjeto;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@EqualsAndHashCode
@Table(name = "projeto")
public class Projeto {
	
	@EqualsAndHashCode.Include
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_projeto;
	
	@Column
	private String ordem_projeto;
	
	@Column
	private String nome_projeto;
	
	@Column
	private String chefe_projeto;
	

	@OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL)
	private List<SubProjeto> sub_projetos;
	
	@Column
	private Double progresso_projeto;
	
	@Column
	private Date prazo_projeto;
	
	@Column
	private String descricao_projeto;
	
	@Column
	private Date data_inicio_projeto;
	
	@Column
	private BigDecimal orcamento_projeto;
	
	@Column
	private BigDecimal hora_humano_total;
	
	@Column
	private BigDecimal hora_valor_projeto;
	
	


	public Projeto() {
		
	}
	
	public Projeto(DadosProjetoCadastro dadosProjeto) {
		this.nome_projeto = dadosProjeto.nome_projeto();
		this.ordem_projeto = dadosProjeto.ordem_projeto();
		this.descricao_projeto = dadosProjeto.descricao_projeto();
		this.hora_valor_projeto = dadosProjeto.hora_valor_projeto();
		if(dadosProjeto.sub_projetos() != null) {
			List<SubProjeto> listaSubProjeto = new ArrayList<SubProjeto>();
			dadosProjeto.sub_projetos().forEach((subProj)->{
				listaSubProjeto.add(new SubProjeto(subProj, this));
			});
			this.sub_projetos = listaSubProjeto;
		}
	}

	public Long getId_projeto() {
		return id_projeto;
	}

	public void setId_projeto(Long id_projeto) {
		this.id_projeto = id_projeto;
	}

	public String getOrdem_projeto() {
		return ordem_projeto;
	}

	public void setOrdem_projeto(String ordem_projeto) {
		this.ordem_projeto = ordem_projeto;
	}

	public String getNome_projeto() {
		return nome_projeto;
	}

	public void setNome_projeto(String nome_projeto) {
		this.nome_projeto = nome_projeto;
	}

	public String getChefe_projeto() {
		return chefe_projeto;
	}

	public void setChefe_projeto(String chefe_projeto) {
		this.chefe_projeto = chefe_projeto;
	}

	public List<SubProjeto> getSub_projetos() {
		return sub_projetos;
	}

	public void setSub_projetos(List<SubProjeto> sub_projetos) {
		this.sub_projetos = sub_projetos;
	}

	public Double getProgresso_projeto() {
		return progresso_projeto;
	}

	public void setProgresso_projeto(Double progresso_projeto) {
		this.progresso_projeto = progresso_projeto;
	}

	public Date getPrazo_projeto() {
		return prazo_projeto;
	}

	public void setPrazo_projeto(Date prazo_projeto) {
		this.prazo_projeto = prazo_projeto;
	}

	public String getDescricao_projeto() {
		return descricao_projeto;
	}

	public void setDescricao_projeto(String descricao_projeto) {
		this.descricao_projeto = descricao_projeto;
	}

	public Date getData_inicio_projeto() {
		return data_inicio_projeto;
	}

	public void setData_inicio_projeto(Date data_inicio_projeto) {
		this.data_inicio_projeto = data_inicio_projeto;
	}

	public BigDecimal getOrcamento_projeto() {
		return orcamento_projeto;
	}

	public void setOrcamento_projeto(BigDecimal orcamento_projeto) {
		this.orcamento_projeto = orcamento_projeto;
	}

	public BigDecimal getHora_humano_total() {
		return hora_humano_total;
	}

	public void setHora_humano_total(BigDecimal hora_humano_total) {
		this.hora_humano_total = hora_humano_total;
	}

	public BigDecimal getHora_valor_projeto() {
		return hora_valor_projeto;
	}

	public void setHora_valor_projeto(BigDecimal hora_valor_projeto) {
		this.hora_valor_projeto = hora_valor_projeto;
	}
}


	