package br.fepi.si.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "quadra")
public class Quadra implements Serializable{
		
	private static final long serialVersionUID = 1L;
	
	private int capacidade;
	private String local;
	private Date dataPartida;
	private Long idPartida;
	
	private Equipe equipe;
	
	public Quadra(Equipe equipe, int capacidade, String local, Date dataPartida, Long idPartida) {
		this.capacidade = capacidade;
		this.local = local;
		this.dataPartida = dataPartida;
		this.idPartida = idPartida;
		this.equipe = equipe;
	}
	
	public Quadra() {
		
	}
	@Column(name = "capacidade", nullable = false)
	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	
	@Id
	@GeneratedValue
	@Column(name = "id_partida")
	public Long getIdPartida() {
		return idPartida;
	}
	
	public void setIdPartida(Long idPartida) {
		this.idPartida = idPartida;
	}
	
	@Column(name = "local_partida", length = 100, nullable = false)
	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	@Column(name = "data_jogo")
	public Date getDataPartida() {
		return dataPartida;
	}

	public void setDataPartida(Date dataPartida) {
		this.dataPartida = dataPartida;
	}

	@ManyToOne
	@JoinColumn(name = "equipe_id")
	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + capacidade;
		result = prime * result + ((dataPartida == null) ? 0 : dataPartida.hashCode());
		result = prime * result + ((equipe == null) ? 0 : equipe.hashCode());
		result = prime * result + ((idPartida == null) ? 0 : idPartida.hashCode());
		result = prime * result + ((local == null) ? 0 : local.hashCode());
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
		Quadra other = (Quadra) obj;
		if (capacidade != other.capacidade)
			return false;
		if (dataPartida == null) {
			if (other.dataPartida != null)
				return false;
		} else if (!dataPartida.equals(other.dataPartida))
			return false;
		if (equipe == null) {
			if (other.equipe != null)
				return false;
		} else if (!equipe.equals(other.equipe))
			return false;
		if (idPartida == null) {
			if (other.idPartida != null)
				return false;
		} else if (!idPartida.equals(other.idPartida))
			return false;
		if (local == null) {
			if (other.local != null)
				return false;
		} else if (!local.equals(other.local))
			return false;
		return true;
	}

	



}

