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

import br.fepi.si.model.Equipe;
import br.fepi.si.repository.Equipes;
import br.fepi.si.service.CadastroEquipes;
import br.fepi.si.service.NegocioException;
import br.fepi.si.util.JpaUtil;

@ManagedBean
@ViewScoped
public class CadastroEquipeMBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Equipe equipe = new Equipe();

	private List<Equipe> equipes = new ArrayList<>();

	public void preparaCadastrados() {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			this.setEquipes(new Equipes(em).obterEquipes());
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
			CadastroEquipes cadastroEquipes = new CadastroEquipes(new Equipes(em));
			cadastroEquipes.salvar(this.equipe);
			this.equipe = new Equipe();
			context.addMessage(null, new FacesMessage("Equipe inserido com sucesso!"));
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

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public List<Equipe> getEquipes() {
		return equipes;
	}

	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}





	
}
