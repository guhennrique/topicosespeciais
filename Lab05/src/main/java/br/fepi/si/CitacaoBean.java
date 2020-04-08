package br.fepi.si;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class CitacaoBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String nome, sobrenome, nomeCompleto;
	
	public void citacao() {
		this.nomeCompleto = this.sobrenome.toUpperCase() + ", " + this.nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	
	

}
