package br.fepi.si.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;

import br.fepi.si.model.Equipe;
import br.fepi.si.repository.Equipes;
import br.fepi.si.util.JpaUtil;

@FacesConverter(forClass = Equipe.class)
public class EquipeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Equipe retorno = null;
		EntityManager em = JpaUtil.getEntityManager();
		try {
			if (value != null && !"".equals(value)) {
				Equipes equipes = new Equipes(em);
				retorno = equipes.porRegistro(new Long(value));
			}
			return retorno;
		} finally {
			em.close();
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Equipe equipe = (Equipe) value;
			
			return equipe.getIdEquipe() == null ? null : equipe.getIdEquipe().toString();
		}
		return null;
	}

}