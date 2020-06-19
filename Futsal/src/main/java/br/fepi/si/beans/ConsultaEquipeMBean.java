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
import br.fepi.si.util.JpaUtil;

@ManagedBean
@ViewScoped
public class ConsultaEquipeMBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager em;

	private List<Equipe> equipes = new ArrayList<>();
	private Equipe equipeSelecionado = new Equipe();

	public ConsultaEquipeMBean() {
	}

	public void consultar() {
		EntityManager em = JpaUtil.getEntityManager();
		this.setEquipes(new Equipes(em).obterEquipes());
		em.close();
	}

	public void excluir() {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();

		CadastroEquipes cadastroEquipes = new CadastroEquipes(new Equipes(em));

		FacesContext context = FacesContext.getCurrentInstance();

		try {
			et.begin();
			cadastroEquipes.excluir(equipeSelecionado);
			context.addMessage(null,
					new FacesMessage("Equipe #" + equipeSelecionado.getIdEquipe() + " removido com sucesso."));
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

	public List<Equipe> getEquipes() {
		return equipes;
	}

	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}

	public Equipe getEquipeSelecionado() {
		return equipeSelecionado;
	}

	public void setEquipeSelecionado(Equipe equipeSelecionado) {
		this.equipeSelecionado = equipeSelecionado;
	}


}
