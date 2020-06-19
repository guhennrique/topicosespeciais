package br.fepi.si.service;

import java.io.Serializable;

import br.fepi.si.model.Equipe;
import br.fepi.si.repository.Equipes;

public class CadastroEquipes implements Serializable {

	private static final long serialVersionUID = 1L;

	private Equipes equipes;

	public CadastroEquipes(Equipes equipes) {
		this.equipes = equipes;
	}

	public void salvar(Equipe equipe) throws NegocioException {
		if (equipe.getIdEquipe() == null)
			throw new NegocioException("A Equipe precisa de um ID.");
		this.equipes.guardar(equipe);
	}

	public void excluir(Equipe equipe) throws NegocioException {
		equipe = this.equipes.porRegistro(equipe.getIdEquipe());

		this.equipes.remover(equipe);
	}
}