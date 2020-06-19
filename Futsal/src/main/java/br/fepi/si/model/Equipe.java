package br.fepi.si.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "equipe")
@Inheritance(strategy = InheritanceType.JOINED)
public class Equipe implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String nomeEquipe;
	private Long idEquipe;
	
	public Equipe(String nomeEquipe, Long idEquipe) {
		this.nomeEquipe = nomeEquipe;
		this.idEquipe = idEquipe;
	}
	
	public Equipe() {
		
	}
	@Column(name = "nome_equipe", length = 100, nullable = false)
	public String getNomeEquipe() {
		return nomeEquipe;
	}

	public void setNomeEquipe(String nomeEquipe) {
		this.nomeEquipe = nomeEquipe;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_time")
	public Long getIdEquipe() {
		return idEquipe;
	}

	public void setIdEquipe(Long idEquipe) {
		this.idEquipe = idEquipe;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEquipe == null) ? 0 : idEquipe.hashCode());
		result = prime * result + ((nomeEquipe == null) ? 0 : nomeEquipe.hashCode());
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
		Equipe other = (Equipe) obj;
		if (idEquipe == null) {
			if (other.idEquipe != null)
				return false;
		} else if (!idEquipe.equals(other.idEquipe))
			return false;
		if (nomeEquipe == null) {
			if (other.nomeEquipe != null)
				return false;
		} else if (!nomeEquipe.equals(other.nomeEquipe))
			return false;
		return true;
	}
	
	
	

	

	

	

	
}


