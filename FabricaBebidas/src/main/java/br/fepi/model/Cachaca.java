package br.fepi.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cachaca")
public class Cachaca extends Bebida implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Date dataBarril;
	
	public Cachaca(String rotulo, Double volumeAlcoolico, BigDecimal preco, Date dataBarril) {
		super(rotulo, volumeAlcoolico, preco);
		this.dataBarril = dataBarril;
	}
	
	public Cachaca() {
		
	}

	@Column(name = "data_barril", nullable = false)
	public Date getDataBarril() {
		return dataBarril;
	}

	public void setDataBarril(Date dataBarril) {
		this.dataBarril = dataBarril;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dataBarril == null) ? 0 : dataBarril.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cachaca other = (Cachaca) obj;
		if (dataBarril == null) {
			if (other.dataBarril != null)
				return false;
		} else if (!dataBarril.equals(other.dataBarril))
			return false;
		return true;
	}
	
	
	
	

}
