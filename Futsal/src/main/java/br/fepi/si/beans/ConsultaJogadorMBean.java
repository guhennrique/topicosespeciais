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
import br.fepi.si.util.JpaUtil;

@ManagedBean
@ViewScoped
public class ConsultaJogadorMBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager em;

	private List<Jogador> jogadores = new ArrayList<>();
	private Jogador jogadorSelecionado = new Jogador();

	public ConsultaJogadorMBean() {
	}

	public void consultar() {
		EntityManager em = JpaUtil.getEntityManager();
		this.setJogadores(new Jogadores(em).obterJogadores());
		em.close();
	}

	public void excluir() {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();

		CadastroJogadores cadastroJogadores = new CadastroJogadores(new Jogadores(em));

		FacesContext context = FacesContext.getCurrentInstance();

		try {
			et.begin();
			cadastroJogadores.excluir(jogadorSelecionado);
			context.addMessage(null,
					new FacesMessage("Jogador #" + jogadorSelecionado.getIdJogador() + " removido com sucesso."));
			et.commit();
			this.consultar();
		} catch (Exception e) {
			et.rollback();
			FacesMessage msg = new FacesMessage(e.getMessage());
			msg.setSeverity(FacesMessage.SEVERITY_FATAL);
			context.addMessage(null, msg);
		} finally {
			em.close();
		}
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public Jogador getJogadorSelecionado() {
		return jogadorSelecionado;
	}

	public void setJogadorSelecionado(Jogador jogadorSelecionado) {
		this.jogadorSelecionado = jogadorSelecionado;
	}
}
