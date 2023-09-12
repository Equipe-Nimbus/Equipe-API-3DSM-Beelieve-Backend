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
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@EqualsAndHashCode
@Table(name = "projeto")
@ToString
public class Projeto implements tipoProjeto {
	
	@EqualsAndHashCode.Include
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long projeto_id;
	
	@Column
	private String nomeProjeto;
	
	@Column
	private String chefeProjeto;
	
	@OneToMany(mappedBy = "projeto", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<SubProjeto> subProjeto;
	
	@Column
	private Date prazoProjeto;
	
	@Column
	private BigDecimal orcamentoProjeto;
	
	@Column
	private BigDecimal horaHomemTotal;
	

	@PrePersist
	public void persistenciaChaveEstrangeira() {
		if(subProjeto != null) {
			subProjeto.forEach((sub) -> {
				sub.setProjeto(this);
			});
		}
	}
	
	

	public Long getProjeto_id() {
		return projeto_id;
	}

	public void setProjeto_id(Long projeto_id) {
		this.projeto_id = projeto_id;
	}

	public String getNomeProjeto() {
		return nomeProjeto;
	}

	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;
	}



	public String getChefeProjeto() {
		return chefeProjeto;
	}

	public void setChefeProjeto(String chefeProjeto) {
		this.chefeProjeto = chefeProjeto;
	}

	public List<SubProjeto> getSubProjeto() {
		return subProjeto;
	}

	public void setSubProjeto(List<SubProjeto> subProjeto) {
		this.subProjeto = subProjeto;
	}

	public Date getPrazoProjeto() {
		return prazoProjeto;
	}

	public void setPrazoProjeto(Date prazoProjeto) {
		this.prazoProjeto = prazoProjeto;
	}

	public BigDecimal getOrcamentoProjeto() {
		return orcamentoProjeto;
	}

	public void setOrcamentoProjeto(BigDecimal orcamentoProjeto) {
		this.orcamentoProjeto = orcamentoProjeto;
	}

	public BigDecimal getHoraHomemTotal() {
		return horaHomemTotal;
	}

	public void setHoraHomemTotal(BigDecimal horaHomemTotal) {
		this.horaHomemTotal = horaHomemTotal;
	}

}
