package br.fepi.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "formula")
public class Formula implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long idFormula;
	private String descricao;
	
	public Formula(Long idFormula, String descricao) {
		super();
		this.idFormula = idFormula;
		this.descricao = descricao;
	}
	
	public Formula(){
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getIdFormula() {
		return idFormula;
	}

	public void setIdFormula(Long idFormula) {
		this.idFormula = idFormula;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((idFormula == null) ? 0 : idFormula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Formula other = (Formula) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (idFormula == null) {
			if (other.idFormula != null)
				return false;
		} else if (!idFormula.equals(other.idFormula))
			return false;
		return true;
	}
}
