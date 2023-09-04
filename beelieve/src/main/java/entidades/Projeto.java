package entidades;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "projeto")
public class Projeto implements tipoProjeto {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long projetoId;
	
	@Column
	private String nomeProjeto;
	
	@Column
	private String chefeProjeto;
	
	@OneToMany(mappedBy = "atreladoProjeto")
	private List<SubProjeto> subProjeto;
	
	@Column
	private Date prazoProjeto;
	
	@Column
	private BigDecimal orcamentoProjeto;
	
	@Column
	private BigDecimal horaHomemTotal;
	
	
	
	
	public Long getProjetoId() {
		return projetoId;
	}

	public void setProjetoId(Long projetoId) {
		this.projetoId = projetoId;
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
