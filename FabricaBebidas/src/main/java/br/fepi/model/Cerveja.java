package br.fepi.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "cerveja")
@PrimaryKeyJoinColumn(name = "id_bebida")
public class Cerveja extends Bebida implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private TiposEnum tiposenum;
	
	public Cerveja(String rotulo, Double volumeAlcoolico, BigDecimal preco, TiposEnum tiposenum) {
		super(rotulo, volumeAlcoolico, preco);
		this.tiposenum = tiposenum;
	}
	
	public Cerveja() {
		
	}

	@Column(name = "tipo", nullable = false)
	@Enumerated(EnumType.STRING)
	public TiposEnum getTiposenum() {
		return tiposenum;
	}

	public void setTiposenum(TiposEnum tiposenum) {
		this.tiposenum = tiposenum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((tiposenum == null) ? 0 : tiposenum.hashCode());
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
		Cerveja other = (Cerveja) obj;
		if (tiposenum != other.tiposenum)
			return false;
		return true;
	}
	
	
	
	

}
