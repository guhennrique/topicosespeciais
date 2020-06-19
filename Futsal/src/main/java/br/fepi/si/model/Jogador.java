package br.fepi.si.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "jogador")
public class Jogador implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nomeJogador;
	//private String posicao;
	private Long idJogador;
	private Equipe equipe;
	
	public Jogador(Long idJogador, String nomeJogador) {
		this.nomeJogador = nomeJogador;
		this.idJogador = idJogador;

	}

	public Jogador() {

	}

	@Column(name = "nome_jogador", length = 100, nullable = false)
	public String getNomeJogador() {
		return nomeJogador;
	}

	public void setNomeJogador(String nomeJogador) {
		this.nomeJogador = nomeJogador;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_jogador")
	public Long getIdJogador() {
		return idJogador;
	}

	public void setIdJogador(Long idJogador) {
		this.idJogador = idJogador;
	}
	
	@OneToOne
	@JoinColumn(name = "equipe")
	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}



	
	
}
