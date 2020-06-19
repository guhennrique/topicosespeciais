package br.fepi.si.service;

import java.io.Serializable;

import br.fepi.si.model.Jogador;
import br.fepi.si.repository.Jogadores;

public class CadastroJogadores implements Serializable {

	private static final long serialVersionUID = 1L;

	private Jogadores jogadores;

	public CadastroJogadores(Jogadores jogadores) {
		this.jogadores = jogadores;
	}

	public void salvar(Jogador jogador) throws NegocioException {
		if (jogador.getIdJogador() == null)
			throw new NegocioException("O Jogador precisa de um ID.");
		this.jogadores.guardar(jogador);
	}

	public void excluir(Jogador jogador) throws NegocioException {
		jogador = this.jogadores.porRegistro(jogador.getIdJogador());

		this.jogadores.remover(jogador);
	}
}