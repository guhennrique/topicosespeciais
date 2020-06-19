package br.fepi.si.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.fepi.si.model.Jogador;
import br.fepi.si.repository.Jogadores;
import br.fepi.si.service.CadastroJogadores;
import br.fepi.si.service.NegocioException;
import br.fepi.si.util.JpaUtil;

@ManagedBean
@ViewScoped
public class CadastroJogadorMBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Jogador jogador = new Jogador();

	private List<Jogador> jogadores = new ArrayList<>();

	public void preparaCadastrados() {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			this.setJogadores(new Jogadores(em).obterJogadores());
		} finally {
			em.close();
		}
	}

	public void salvar() {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		FacesContext context = FacesContext.getCurrentInstance();

		try {
			et.begin();
			CadastroJogadores cadastroJogadores = new CadastroJogadores(new Jogadores(em));
			cadastroJogadores.salvar(this.jogador);
			this.jogador = new Jogador();
			context.addMessage(null, new FacesMessage("Jogador incluido com sucesso!"));
			et.commit();
		} catch (NegocioException e) {
			et.rollback();
			FacesMessage msg = new FacesMessage(e.getMessage());
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, msg);
		} finally {
			em.close();
		}
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	
}
