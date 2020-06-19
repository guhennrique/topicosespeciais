package br.fepi.si.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.fepi.si.model.Jogador;

public class Jogadores implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager em;

	public Jogadores(EntityManager em) {
		this.em = em;
	}

	public Jogador porRegistro(Long id) {
		return em.find(Jogador.class, id);
	}

	public void remover(Jogador jogador) {
		this.em.remove(jogador);
	}

	public void adicionar(Jogador jogador) {
		this.em.persist(jogador);
	}

	public void guardar(Jogador jogador) {
		System.out.println(jogador.getIdJogador() + " " + jogador.getNomeJogador());
		this.em.merge(jogador);
	}

	public List<Jogador> obterJogadores() {
		TypedQuery<Jogador> query = em.createQuery("FROM Jogador", Jogador.class);
		return query.getResultList();
	}

}