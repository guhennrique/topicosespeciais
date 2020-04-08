package br.fepi.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bebida")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Bebida implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long idBebida;
	private String rotulo;
	private Double volumeAlcoolico;
	private BigDecimal preco;
	
	private Formula formula;
	
	public Bebida(String rotulo, Double volumeAlcoolico, BigDecimal preco) {
		super();
		this.rotulo = rotulo;
		this.volumeAlcoolico = volumeAlcoolico;
		this.preco = preco;
	}
	
	public Bebida() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_bebida")
	public Long getIdBebida() {
		return idBebida;
	}

	public void setIdBebida(Long idBebida) {
		this.idBebida = idBebida;
	}

	@Column(name = "rotulo", length = 120, nullable = true)
	public String getRotulo() {
		return rotulo;
	}

	public void setRotulo(String rotulo) {
		this.rotulo = rotulo;
	}

	@Column(name = "volume_alcoolico", nullable = false)
	public Double getVolumeAlcoolico() {
		return volumeAlcoolico;
	}

	public void setVolumeAlcoolico(Double volumeAlcoolico) {
		this.volumeAlcoolico = volumeAlcoolico;
	}

	@Column(name = "preco", nullable = false)
	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idBebida == null) ? 0 : idBebida.hashCode());
		result = prime * result + ((preco == null) ? 0 : preco.hashCode());
		result = prime * result + ((rotulo == null) ? 0 : rotulo.hashCode());
		result = prime * result + ((volumeAlcoolico == null) ? 0 : volumeAlcoolico.hashCode());
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
		Bebida other = (Bebida) obj;
		if (idBebida == null) {
			if (other.idBebida != null)
				return false;
		} else if (!idBebida.equals(other.idBebida))
			return false;
		if (preco == null) {
			if (other.preco != null)
				return false;
		} else if (!preco.equals(other.preco))
			return false;
		if (rotulo == null) {
			if (other.rotulo != null)
				return false;
		} else if (!rotulo.equals(other.rotulo))
			return false;
		if (volumeAlcoolico == null) {
			if (other.volumeAlcoolico != null)
				return false;
		} else if (!volumeAlcoolico.equals(other.volumeAlcoolico))
			return false;
		return true;
	}

	@OneToOne
	@JoinColumn(name = "id_bebida")
	public Formula getFormula() {
		return formula;
	}

	public void setFormula(Formula formula) {
		this.formula = formula;
	}
}
