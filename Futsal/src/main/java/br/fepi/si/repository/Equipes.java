package br.fepi.si.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.fepi.si.model.Equipe;

public class Equipes implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager em;

	public Equipes(EntityManager em) {
		this.em = em;
	}

	public Equipe porRegistro(Long id) {
		return em.find(Equipe.class, id);
	}

	public void remover(Equipe equipe) {
		this.em.remove(equipe);
	}

	public void adicionar(Equipe equipe) {
		this.em.persist(equipe);
	}

	public void guardar(Equipe equipe) {
		System.out.println(equipe.getIdEquipe() + " " + equipe.getNomeEquipe());
		this.em.merge(equipe);
	}

	public List<Equipe> obterEquipes() {
		TypedQuery<Equipe> query = em.createQuery("FROM Equipe", Equipe.class);
		return query.getResultList();
	}

}